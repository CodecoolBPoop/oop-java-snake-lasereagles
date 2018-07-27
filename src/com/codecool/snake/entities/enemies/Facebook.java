package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Position;
import com.codecool.snake.RandomNumber;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class Facebook extends Enemy {
    private double direction;


    public Facebook(Pane pane) {
        super(pane);
        this.setDamage(15);
        setImage(Globals.facebook);
        pane.getChildren().add(this);
        this.setSpeed2(0.7F);
        this.setSpawnPos();
        this.setDirection();
    }

    protected void headPlayer(){
        Position snakePos = Position.getSnakePos(pane);
        double headX = snakePos.x;
        double headY = snakePos.y;
        double chaserX = this.getX();
        double chaserY = this.getY();
        double angle = (double) Math.toDegrees(Math.atan2(headY - chaserY, headX - chaserX));

        if (angle < 0) {angle += 360;}
        angle += 90;
        if (angle > 360) {angle -= 360;}

        this.direction = angle;
        setRotate(direction);
        heading = Utils.directionToVector(direction, this.getSpeed2());
        this.setX(getX() + heading.getX());
        this.setY(getY() + heading.getY());
    }

    public GameEntity createInstance(){
        return new Facebook(pane);
    }

    @Override
    public void step(){
        this.headPlayer();
        if(isOutOfBounds()){
            this.setDirection();
        }
        this.setX(getX() + this.heading.getX());
        this.setY(getY() + this.heading.getY());
    }

}
