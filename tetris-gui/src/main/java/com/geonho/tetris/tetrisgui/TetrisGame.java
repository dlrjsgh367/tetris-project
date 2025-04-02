package com.geonho.tetris.tetrisgui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TetrisGame extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("점수 전송 테스트");

        btn.setOnAction(e -> {
            ScoreUploader.uploadScore("geonho", 90000, "00:04:20");
        });

        StackPane root = new StackPane(btn);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Tetris - 서버 연동 테스트");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
