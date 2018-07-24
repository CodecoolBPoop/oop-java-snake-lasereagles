package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class LinkedIn extends Enemy {


    public LinkedIn(Pane pane) {
        super(pane);
        this.setDamage(20);
        setImage(Globals.linkedIn);
        pane.getChildren().add(this);
        this.setSpeed(3);
        this.setPosition();
        this.setDirection();
    }
}
