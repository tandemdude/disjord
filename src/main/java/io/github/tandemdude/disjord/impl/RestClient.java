package io.github.tandemdude.disjord.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.tandemdude.disjord.exceptions.RequestFailedException;
import io.github.tandemdude.disjord.models.payloads.GatewayBot;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClient {
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper;
    private static final String baseUrl = "https://discord.com/api/v9";
    private final String token;

    public RestClient(ObjectMapper objectMapper, String token) {
        this.token = "Bot " + token;
        this.objectMapper = objectMapper;
    }

    private <T> T makeRequest(HttpRequest request, Class<T> targetClass) throws RequestFailedException {
        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), targetClass);
        } catch (IOException | InterruptedException e) {
            throw new RequestFailedException(e.getMessage());
        }
    }

    public GatewayBot getGatewayBot() throws RequestFailedException {
        var request = HttpRequest.newBuilder(URI.create(baseUrl + "/gateway/bot"))
                .header("accept", "application/json")
                .header("Authorization", token)
                .build();
        return makeRequest(request, GatewayBot.class);
    }
}
