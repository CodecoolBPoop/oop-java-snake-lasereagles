package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import javafx.scene.layout.Pane;

public class Facebook extends Enemy {

    public Facebook(Pane pane) {
        super(pane);
        this.setDamage(15);
        setImage(Globals.facebook);
        pane.getChildren().add(this);
        this.setSpeed(1);
        this.setSpawnPos();
        this.setDirection();
    }

    public GameEntity createInstance(){
        return new Facebook(pane);
    }

}
