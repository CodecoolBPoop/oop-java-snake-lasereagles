package com.codecool.snake.entities.snakes;

import com.codecool.snake.Game;
import com.codecool.snake.GameOver;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

public class SnakeHead extends GameEntity implements Animatable {

    private static float speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    public static GameEntity snakeHead;
    private int health;
    public static Label label = new Label("100");
    public static ProgressBar p2 = new ProgressBar();

    public static ProgressBar createBar() {
        p2.setProgress(0.6);
        return p2;
    }

    public static Label create() {
        label.setText("100");
        label.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        label.setLayoutX(0.5 * Globals.WINDOW_WIDTH);
        return label;
    }

    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);
        setX(xc);
        setY(yc);
        health = 100;
        tail = this;
        snakeHead = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);
        addPart(4);
    }

    public void step() {
        double dir = getRotate();
        if (Globals.leftKeyDown) {
            dir = dir - turnRate;
        }
        if (Globals.rightKeyDown) {
            dir = dir + turnRate;
        }
        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

        // check if collided with an enemy or a powerup
        // ez jó helyen lakik-e ez a collide?

        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    entity.createInstance();
                    interactable.apply(this);
                    System.out.println(interactable.getMessage());
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds() || health <= 0) {
            System.out.println("Game Over");
            Globals.gameLoop.stop();
            GameOver.gameover("Game over");


        }
    }

    public void addPart(int numParts) {
        for (int i = 0; i < numParts; i++) {
            SnakeBody newPart = new SnakeBody(pane, tail);
            tail = newPart;
        }
    }

    public void changeHealth(int diff) {
        health += diff;
        System.out.println(diff);
        if (health <= 0) {
            label.setText("0");
        }else{
            label.setText(String.valueOf(health));
        }
    }

    public GameEntity createInstance() {
        return null;
    }
  
    public void changeSpeed(int increase){
        speed += increase;
    }
}
