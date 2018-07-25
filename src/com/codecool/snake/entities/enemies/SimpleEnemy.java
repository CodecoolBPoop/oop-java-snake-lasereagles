package com.codecool.snake.entities.enemies;


import com.codecool.snake.Globals;
import javafx.scene.layout.Pane;



public class SimpleEnemy extends Enemy {


    public SimpleEnemy(Pane pane) {
        super(pane);
        this.setDamage(10);
        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
    
        this.setSpeed(1);
        this.setSpawnPos();
        this.setDirection();

    }

}