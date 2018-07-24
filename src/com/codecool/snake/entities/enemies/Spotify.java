package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class Spotify extends Enemy implements Animatable, Interactable {


    public Spotify(Pane pane) {
        super(pane);
        this.damage = 25;

        setImage(Globals.spotify);
        pane.getChildren().add(this);
        this.speed = 2;
        this.setPosition();
        this.setDirection();
        //System.out.println(this.positionX + " " + this.direction);
    }

    @Override
    public void step(){
        if(isOutOfBounds()){
            this.setDirection();
        }
        this.setX(getX() + this.heading.getX());
        this.setY(getY() + this.heading.getY());
    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-this.damage);
        destroy();
    }

    @Override
    public String getMessage(){return "25 damage"; }

}
