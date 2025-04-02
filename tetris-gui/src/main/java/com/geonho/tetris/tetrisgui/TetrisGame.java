package com.geonho.tetris.tetrisgui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class TetrisGame extends Application {

    private static final int BLOCK_SIZE = 25;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;

    private TetrominoType currentTetromino;
    private int currentX = 3;  // 시작 위치 (중앙)
    private int currentY = 0;

    private final Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH * BLOCK_SIZE, HEIGHT * BLOCK_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // 블록 선택
        currentTetromino = getRandomTetromino();

        // 화면 그리기
        drawField(gc);
        drawTetromino(gc, currentTetromino, currentX, currentY);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Tetris - 랜덤 블록 그리기");
        primaryStage.setScene(scene);
        primaryStage.show();
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
