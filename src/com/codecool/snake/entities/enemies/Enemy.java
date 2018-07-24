package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.RandomNumber;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class Enemy extends GameEntity{

    protected Point2D heading;
    int damage;
    double direction;
    int speed;

    public Enemy(Pane pane) {
        super(pane);
    }

    protected void setPosition(){
        setX(RandomNumber.getRandomDouble() * Globals.WINDOW_WIDTH);
        setY(RandomNumber.getRandomDouble() * Globals.WINDOW_HEIGHT);
    }

    protected void setDirection(){
        this.direction = RandomNumber.getRandomDouble() * 360;
        this.setRotate(this.direction);
        this.heading = Utils.directionToVector(this.direction, this.speed);  //what is the difference between line 31 and 32?
    }

}
