package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;


public class SimpleEnemy extends Enemy implements Interactable {

    public SimpleEnemy(Pane pane) {
        super(pane);
        this.setDamage(10);

        setImage(Globals.simpleEnemy);
        pane.getChildren().add(this);
        this.setSpeed(1);
        this.setPosition();
        this.setDirection();
    }

    @Override
    public void apply(SnakeHead player) {
        player.changeHealth(-this.getDamage());
        destroy();
    }

    @Override
    public String getMessage(){return "10 damage"; }
}
