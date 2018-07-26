package com.codecool.snake.entities.snakes;

import com.codecool.snake.GameOver;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class SnakeHead extends GameEntity implements Animatable {

    public static float speed = 2;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    public static GameEntity snakeHead;
    public static int instance = 0;
    private int health;
    public static Label label = new Label("100");
    public static Label label2 = new Label("100");
    private String name = "snake";

    public static Label create() {
        label.setText("100");
        label.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        label.setLayoutX(0.5 * Globals.WINDOW_WIDTH);
        return label;
    }

    public static Label createHealthPlayer2() {
        label2.setText("100");
        label2.setFont(Font.font ("Verdana", FontWeight.EXTRA_BOLD, 20));
        label2.setLayoutX(0.3 * Globals.WINDOW_WIDTH);
        return label2;
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
        this.name = name+instance;
        System.out.println(this.name);
        instance++;
        System.out.println("startinstance"+instance);
    }


    public void step() {
        double dir = getRotate();

        if (name.equals("snake0")) {
            if (Globals.leftKeyDown) {
                System.out.println("left");
                dir = dir - turnRate;
            }
            if (Globals.rightKeyDown) {
                dir = dir + turnRate;
            }
        }

        if (name.equals("snake1")) {
            if (Globals.aKeyDown) {
                System.out.println("a");
                dir = dir - turnRate;
            }
            if (Globals.dKeyDown) {
                System.out.println("d");
                dir = dir + turnRate;
            }
        }

        // set rotation and position
        setRotate(dir);
        Point2D heading = Utils.directionToVector(dir, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());


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
            if (this.name.equals("snake1")) {
                System.out.println(name+"Game Over");

            }
            if (this.name.equals("snake2")) {
                System.out.println(name+"Game Over");
            }
            instance--;
            destroy();
            System.out.println("deathinstance" + instance);
            if (instance==0) {
                Globals.gameLoop.stop();
                GameOver.gameover("Game over");
            }
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
