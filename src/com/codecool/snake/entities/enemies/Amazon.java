package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;

public class Amazon extends Enemy {

    public Amazon(Pane pane) {
        super(pane);
        this.setDamage(25);
        setImage(Globals.amazon);
        pane.getChildren().add(this);
        this.setSpeed(2);
        this.setSpawnPos();
        this.setDirection();
    }

    public GameEntity createInstance(){
        return new Amazon(pane);
    }
}