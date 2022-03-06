package io.github.tandemdude.disjord.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.tandemdude.disjord.models.enums.Opcode;
import io.github.tandemdude.disjord.models.payloads.gateway.*;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class GatewayClient {
    private final WebsocketClient websocketClient;

    public GatewayClient(ObjectMapper objectMapper, String url, String token) {
        this.websocketClient = new WebsocketClient(url, token, objectMapper);
    }

    static class WebsocketClient extends WebSocketListener implements AutoCloseable, Runnable {
        private final OkHttpClient client;
        private final Request request;
        private final ObjectMapper objectMapper;
        private final String token;

        private final Logger logger = LoggerFactory.getLogger(WebsocketClient.class);
        private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        private final AtomicInteger seq = new AtomicInteger();
        private final AtomicBoolean expectingAck = new AtomicBoolean();

        private WebSocket openSocket;
        private ScheduledFuture<?> heartbeatFuture;
        private Function<GatewayRecvPayload, GatewaySendPayload> eventCallback;

        public WebsocketClient(String url, String token, ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
            this.token = token;
            this.request = new Request.Builder()
                    .url(url)
                    .build();
            this.client = new OkHttpClient.Builder()
                    .readTimeout(0, SECONDS)
                    .build();
        }

        class HeartbeatRunnable implements Runnable {
            private boolean firstHeartbeat = true;

            @Override
            public void run() {
                if (expectingAck.get()) {
                    logger.warn("Heartbeat window elapsed but previous ACK was not received");
                    heartbeatFuture.cancel(true);
                    return;
                }
                GatewayHeartbeatPayload pl = new GatewayHeartbeatPayload(firstHeartbeat ? null : seq.get());
                firstHeartbeat = false;

                try {
                    logger.debug("Sending HEARTBEAT");
                    expectingAck.set(true);
                    openSocket.send(
                            objectMapper.writeValueAsString(pl)
                    );
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setEventCallback(Function<GatewayRecvPayload, GatewaySendPayload> eventCallback) {
            this.eventCallback = eventCallback;
        }

        @Override
        public void run() {
            openSocket = client.newWebSocket(request, this);
        }

        @Override
        public void close() {
            client
                    .dispatcher()
                    .executorService()
                    .shutdown();
        }

        @Override
        public void onOpen(@NotNull WebSocket socket, @NotNull Response response) {
            logger.debug("Gateway connection opened, sending IDENTIFY");
            GatewaySendPayload pl = new GatewaySendPayload(Opcode.IDENTIFY, new GatewayIdentify(token));
            try {
                openSocket.send(objectMapper.writeValueAsString(pl));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onMessage(@NotNull WebSocket socket, @NotNull String message) {
            try {
                GatewayRecvPayload payload = objectMapper.readValue(message, GatewayRecvPayload.class);
                if (payload.getSequence() != null) {
                    seq.set(payload.getSequence());
                }
                logger.debug("Received {} ({})", payload.getOpcode(), payload.getEventType());
                if (payload.getOpcode().equals(Opcode.HELLO)) {
                    int heartbeatInterval = payload.deserialiseData(objectMapper, GatewayHello.class).getHeartbeatInterval();
                    int initialHeartbeat = (int) (heartbeatInterval * (new Random()).nextFloat());
                    logger.debug(
                            "Heartbeat interval: {}ms, First heartbeat in: {}ms", heartbeatInterval, initialHeartbeat
                    );
                    heartbeatFuture = scheduler
                            .scheduleAtFixedRate(
                                    new HeartbeatRunnable(), initialHeartbeat, heartbeatInterval, MILLISECONDS
                            );
                    return;
                } else if (payload.getOpcode().equals(Opcode.HEARTBEAT_ACK)) {
                    expectingAck.set(false);
                    return;
                }

                GatewaySendPayload toSend = eventCallback.apply(payload);
                if (toSend == null) {
                    return;
                }
                socket.send(objectMapper.writeValueAsString(toSend));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    public void startCommunication(Function<GatewayRecvPayload, GatewaySendPayload> eventCallback) {
        websocketClient.setEventCallback(eventCallback);
        websocketClient.run();
    }
}
