package com.codecool.snake.entities;

import com.codecool.snake.entities.snakes.FireBall;
import com.codecool.snake.entities.snakes.SnakeHead;

// TODO interface that all game objects that can be interacted with must implement.
public interface Interactable {

    void apply(SnakeHead snakeHead);

    void fireBallApply(FireBall fireBall);

    String getMessage();

}
