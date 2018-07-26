package com.codecool.snake.entities.enemies;

import com.codecool.snake.*;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Animatable;

import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.FireBall;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;


public abstract class Enemy extends GameEntity implements Animatable, Interactable {

    protected Point2D heading;
    private int damage;
    private double direction;
    private int speed;

    public Enemy(Pane pane) {
        super(pane);
    }

    protected void setDirection(){
        this.direction = RandomNumber.getRandomDouble() * 360;
        this.setRotate(this.direction);
        this.heading = Utils.directionToVector(this.direction, this.speed);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
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
        player.changeHealth(-this.getDamage());
        destroy();
    }

    @Override
    public void fireBallApply(FireBall fireBall){
        System.out.println("The fire is hot");
        destroy();
    }

    @Override
    public String getMessage(){return this.getDamage() + " damage" ; }

    public void setSpawnPos() {
        Position snakePos = Position.getSnakePos(pane);
        snakePos = Position.getAvailablePos(snakePos);
        setX(snakePos.x);
        setY(snakePos.y);
    }
}
