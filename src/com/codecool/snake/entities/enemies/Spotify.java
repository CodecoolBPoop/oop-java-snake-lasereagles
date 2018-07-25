package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class Spotify extends Enemy  {

    public Spotify(Pane pane) {
        super(pane);
        this.setDamage(25);
        setImage(Globals.spotify);
        pane.getChildren().add(this);
        this.setSpeed(2);
        this.setPosition();
        this.setDirection();
    }
}
