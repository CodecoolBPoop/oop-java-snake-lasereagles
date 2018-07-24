package com.codecool.snake;

import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class Position {
    public Double x;
    public Double y;

    public Position(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public static Position getSnakePos(Pane pane) {
        int index = pane.getChildren().indexOf(SnakeHead.snakeHead);
        SnakeHead snake = (SnakeHead) pane.getChildren().get(index);
        return new Position(snake.getX(), snake.getY());
    }

}
