package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;


public class SimpleEnemy extends Enemy {

    public SimpleEnemy(Pane pane) {
        super(pane);
        this.setDamage(10);
        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        this.setSpeed(1);
        this.setPosition();
        this.setDirection();
    }
}
