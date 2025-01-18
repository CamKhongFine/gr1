package com.example.image.TelegramService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Telegram {
    public static final Logger LOG = LoggerFactory.getLogger(Telegram.class);
    private static final String BOT_TOKEN = "";
    private static final String CHAT_ID = "";

    public static void sendMessage(String message) {
        try {
            String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
            String url = String.format(
                    "",
                    BOT_TOKEN, CHAT_ID, encodedMessage
            );
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            LOG.info("Response: {}", response.body());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
