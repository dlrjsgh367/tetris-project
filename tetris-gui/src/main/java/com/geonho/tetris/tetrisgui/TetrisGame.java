package com.geonho.tetris.tetrisgui;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class TetrisGame extends Application {

    private static final int BLOCK_SIZE = 25;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;

    private Canvas canvas;
    private GraphicsContext gc;

    private TetrominoType currentTetromino;
    private int currentX = 3;
    private int currentY = 0;

    private final Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(WIDTH * BLOCK_SIZE, HEIGHT * BLOCK_SIZE);
        gc = canvas.getGraphicsContext2D();

        currentTetromino = getRandomTetromino();

        draw();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), e -> {
            currentY++;
            draw();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Scene scene = new Scene(new StackPane(canvas));
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                currentX--;
                draw();
            } else if (e.getCode() == KeyCode.RIGHT) {
                currentX++;
                draw();
            } else if (e.getCode() == KeyCode.DOWN) {
                currentY++;
                draw();
            }
        });

        primaryStage.setTitle("Tetris - 자동 낙하 + 이동");
        primaryStage.setScene(scene);
        primaryStage.show();

        canvas.requestFocus();
    }

    private void draw() {
        drawField(gc);
        drawTetromino(gc, currentTetromino, currentX, currentY);
    }

    private void drawField(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH * BLOCK_SIZE, HEIGHT * BLOCK_SIZE);

        gc.setStroke(Color.DARKGRAY);
        for (int x = 0; x <= WIDTH; x++) {
            gc.strokeLine(x * BLOCK_SIZE, 0, x * BLOCK_SIZE, HEIGHT * BLOCK_SIZE);
        }
        for (int y = 0; y <= HEIGHT; y++) {
            gc.strokeLine(0, y * BLOCK_SIZE, WIDTH * BLOCK_SIZE, y * BLOCK_SIZE);
        }
    }

    private void drawTetromino(GraphicsContext gc, TetrominoType tetromino, int posX, int posY) {
        int[][] shape = tetromino.shape;
        gc.setFill(tetromino.color);

        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] == 1) {
                    int x = (posX + col) * BLOCK_SIZE;
                    int y = (posY + row) * BLOCK_SIZE;
                    gc.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }
    }

    private TetrominoType getRandomTetromino() {
        TetrominoType[] types = TetrominoType.values();
        return types[random.nextInt(types.length)];
    }

    public static void main(String[] args) {
        launch(args);
    }
}
