package io.github.tandemdude.disjord.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.tandemdude.disjord.exceptions.RequestFailedException;
import io.github.tandemdude.disjord.models.Guild;
import io.github.tandemdude.disjord.models.payloads.GatewayBot;
import io.github.tandemdude.disjord.models.payloads.gateway.GatewayRecvPayload;
import io.github.tandemdude.disjord.models.payloads.gateway.GatewaySendPayload;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Bot {
    private static final Logger logger = LoggerFactory.getLogger(Bot.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Getter
    private final RestClient restClient;
    @Getter
    private final GatewayClient gatewayClient;

    public Bot(String token) throws RuntimeException {
        this.restClient = new RestClient(objectMapper, token);
        logger.debug("Fetching gateway information");
        try {
            GatewayBot gatewayBot = this.restClient.getGatewayBot();
            logger.info(
                    "Remaining session starts: {}", gatewayBot.getSessionStartLimit().getRemaining() - 1
            );
            this.gatewayClient = new GatewayClient(objectMapper, gatewayBot.getUrlWithParams(), token);
        } catch (RequestFailedException e) {
            throw new RuntimeException(String.format("Could not fetch gateway information: %s", e.getMessage()));
        }
    }

    private GatewaySendPayload handleRawGatewayEvent(GatewayRecvPayload event) {
        if (Objects.equals(event.getEventType(), "GUILD_CREATE")) {
            Guild data = event.deserialiseData(objectMapper, Guild.class);
        }
        return null;
    }

    public void run() {
        gatewayClient.startCommunication(this::handleRawGatewayEvent);
    }
}
