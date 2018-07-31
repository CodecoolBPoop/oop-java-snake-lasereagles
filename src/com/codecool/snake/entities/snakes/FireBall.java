package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import com.codecool.snake.Position;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

public class FireBall extends GameEntity implements Animatable {

    protected Point2D heading;
    private double direction;
    private int speed;

    public FireBall(Pane pane){
        super(pane);
        this.speed = 5;
        setImage(Globals.fire);
        pane.getChildren().add(this);
        setDirection();
        setPosition();
        //getLastShotsTime(); System.currentTimeMillis();
    }

    public void setDirection(){
        int index = pane.getChildren().indexOf(SnakeHead.snakeHead);
        SnakeHead snake = (SnakeHead) pane.getChildren().get(index);
        this.direction = snake.getSnakeDirection();
        this.setRotate(this.direction);
        this.heading = Utils.directionToVector(this.direction, this.speed);
    }

    public void setPosition(){
        Position snakHeadPos = Position.getSnakePos(pane);
//        System.out.println(snakHeadPos.x);
//        System.out.println(snakHeadPos.y);

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

        for (GameEntity entity: Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {
                    Interactable interactable = (Interactable) entity;
                    interactable.fireBallApply(this);
                    this.destroy();
                    System.out.println(interactable.getMessage());
                    //entity.createInstance();
                }
            }
        }
    }

    @Override
    public  GameEntity createInstance(){
        return new FireBall(pane);
    }

}
