package com.codecool.snake;

import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Position {
    public Double x;
    public Double y;
    private final static int RATIO = 50;

    private Position(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public static Position getSnakePos(Pane pane) {
        int index = pane.getChildren().indexOf(SnakeHead.snakeHead);
        SnakeHead snake = (SnakeHead) pane.getChildren().get(index);
        return new Position(snake.getX(), snake.getY());
    }

    public static Position getAvailablePos(Position position) {
        double rndX = 1;
        double rndY = 1;
        Random rnd = new Random();
        double distance = RATIO-1;
        while (distance < RATIO) {
            rndX = (rnd.nextDouble() * Globals.WINDOW_WIDTH);
            rndY = (rnd.nextDouble() * Globals.WINDOW_HEIGHT);
            distance = Math.hypot(position.x - rndX, position.y - rndY);
        }
        return new Position(rndX, rndY);
    }

}
