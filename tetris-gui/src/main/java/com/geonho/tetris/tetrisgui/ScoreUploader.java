package com.geonho.tetris.tetrisgui;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ScoreUploader {
    public static void uploadScore(String player, int score, String duration) {
        try {
            URL url = new URL("http://localhost:8080/api/score");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = String.format(
                    "{\"player\":\"%s\", \"score\":%d, \"duration\":\"%s\"}",
                    player, score, duration
            );

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
            }

            int responseCode = conn.getResponseCode();
            System.out.println("서버 응답 코드: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
