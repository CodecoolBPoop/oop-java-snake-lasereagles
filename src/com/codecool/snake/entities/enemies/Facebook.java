package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

public class Facebook extends Enemy implements Interactable {


    public Facebook(Pane pane) {
        super(pane);
        this.damage = 15;
        setImage(Globals.facebook);
        pane.getChildren().add(this);
        this.speed = 1;
        this.setPosition();
        this.setDirection();
    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-this.damage);
        destroy();
    }

    @Override
    public String getMessage(){return "15 damage"; }

}
