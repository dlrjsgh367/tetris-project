package com.geonho.tetris.tetrisgui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TetrisGame extends Application {

    private static final int BLOCK_SIZE = 25;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH * BLOCK_SIZE, HEIGHT * BLOCK_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawGrid(gc);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        primaryStage.setTitle("JavaFX Tetris - 블록 그리기");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawGrid(GraphicsContext gc) {
        // 배경
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH * BLOCK_SIZE, HEIGHT * BLOCK_SIZE);

        // 격자선
        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(1);
        for (int x = 0; x <= WIDTH; x++) {
            gc.strokeLine(x * BLOCK_SIZE, 0, x * BLOCK_SIZE, HEIGHT * BLOCK_SIZE);
        }
        for (int y = 0; y <= HEIGHT; y++) {
            gc.strokeLine(0, y * BLOCK_SIZE, WIDTH * BLOCK_SIZE, y * BLOCK_SIZE);
        }

        // 샘플 블록 하나 그려보기
        gc.setFill(Color.CYAN);
        gc.fillRect(4 * BLOCK_SIZE, 0, BLOCK_SIZE, BLOCK_SIZE);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
