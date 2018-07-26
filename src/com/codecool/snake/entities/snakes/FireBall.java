package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import com.codecool.snake.Position;
import com.codecool.snake.RandomNumber;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class FireBall extends GameEntity implements Animatable {

    // Position.getSnakePos.
    protected Point2D heading;
    private double direction;
    private int speed;

    public FireBall(Pane pane){
        super(pane);
        this.speed = 5 ;
        setDirection();
        setImage(Globals.fire);
        pane.getChildren().add(this);
        setPosition();
    }

    protected void setDirection(){ // TODO this is not working yet
        this.direction = SnakeHead.getSnaceDirection();
        this.setRotate(this.direction);
        this.heading = Utils.directionToVector(this.direction, this.speed);  //what is the difference between line 31 and 32?
    }

    public void setPosition(){
        Position snakHeadPos = Position.getSnakePos(pane);
        System.out.println(snakHeadPos.x);
        System.out.println(snakHeadPos.y);

        this.setX(snakHeadPos.x);
        this.setY(snakHeadPos.y);
    }

    @Override
    public void step(){
        if(isOutOfBounds()){
            destroy();
        }
        this.setX(getX() + this.heading.getX());
        this.setY(getY() + this.heading.getY());

    }

    @Override
    public  GameEntity createInstance(){
        return new FireBall(pane);
    }

}
