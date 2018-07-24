package com.codecool.snake.entities.enemies;

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
public class SimpleEnemy extends Enemy implements Animatable, Interactable {

    public SimpleEnemy(Pane pane) {
        super(pane);
        this.damage = 10;

        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        this.speed = 1;
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
    public String getMessage(){return "10 damage"; }
}
