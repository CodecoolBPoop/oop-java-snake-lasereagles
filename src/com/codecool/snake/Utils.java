package com.codecool.snake;

import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class Utils {

    /*
    Converts a direction in degrees (0...360) to x and y coordinates.
    The length of this vector is the second parameter
    */
    public static Point2D directionToVector(double directionInDegrees, double length) {
        double directionInRadians = directionInDegrees / 180 * Math.PI;
        Point2D heading = new Point2D(length * Math.sin(directionInRadians), - length * Math.cos(directionInRadians));
        return heading;
    }


    public static Position getSnakePos(Pane pane) {
        int index = pane.getChildren().indexOf(SnakeHead.snakeHead);
        SnakeHead snake = (SnakeHead) pane.getChildren().get(index);
        return new Position(snake.getX(), snake.getY());
    }

    public int getFreeQuadrant() {
        return 1;
    }

}
