package org.example.mode.robot;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChatBotApp {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private final String webhookUrl = "https://open.feishu.cn/open-apis/bot/v2/hook/YOUR_WEBHOOK_URL";

    public void start() {
        scheduler.scheduleAtFixedRate(this::sendChatMessage, 0, 1, TimeUnit.MINUTES);
    }

    private void sendChatMessage() {
        String message = "这是一条来自机器人的消息";
        String requestBody = "{\"msg_type\":\"text\",\"content\":{\"text\":\"" + message + "\"}}";

        HttpRequest request;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(webhookUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode() + " " + response.body());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatBotApp app = new ChatBotApp();
        app.start();
    }
}