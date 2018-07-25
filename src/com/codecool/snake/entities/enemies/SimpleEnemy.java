package com.codecool.snake.entities.enemies;

import com.codecool.snake.Position;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple enemy TODO make better ones.
public class SimpleEnemy extends GameEntity implements Animatable, Interactable {
    private Random rnd = new Random();
    private Point2D heading;
    private static final int damage = 10;

    public SimpleEnemy(Pane pane) {
        super(pane);

        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        int speed = 1;

        setSpawnPos();
        double direction = rnd.nextDouble() * 360;
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);  //what is the difference between line 31 and 32?
    }

    public void setSpawnPos() {
        Position snakePos = Position.getSnakePos(pane);
        snakePos = Position.getAvailablePos(snakePos);
        setX(snakePos.x);
        setY(snakePos.y);
    }

    @Override
    public void step() {

        if (isOutOfBounds()) {
            destroy();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-damage);
        destroy();
    }

    @Override
    public String getMessage() {
        return "10 damage";
    }
}
