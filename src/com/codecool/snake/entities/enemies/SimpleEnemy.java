package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;


// a simple enemy TODO make better ones.
public class SimpleEnemy extends Enemy implements Interactable {

    public SimpleEnemy(Pane pane) {
        super(pane);
        this.damage = 10;

        setImage(Globals.simpleEnemy);
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
    public String getMessage(){return "10 damage"; }
}
