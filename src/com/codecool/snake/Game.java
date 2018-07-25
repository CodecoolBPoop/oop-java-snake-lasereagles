package com.codecool.snake;

import com.codecool.snake.entities.enemies.*;

import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Game extends Pane {

    public Game() {
        snake();
        setEnemy();
        setPowerUp();
    }

    public void snake() {

        new SnakeHead(this, 500, 500);
        setEnemy();
        setPowerUp();

    }

    public void setEnemy(){
        for (int i = 0; i < 3; i++) {

            new LinkedIn(this);
            new Facebook(this);
            new Spotify(this);

            new SimpleEnemy(this);
        }
    }

    public void setPowerUp(){
        for (int i = 0; i < 4; i++) {
            new SimplePowerup(this);
        }

    }

    public void oneNewPowerUp(){
        new SimplePowerup(this);

    }

    public void start() {
        Scene scene = getScene();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    Globals.leftKeyDown = true;
                    break;
                case RIGHT:
                    Globals.rightKeyDown = true;
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:
                    Globals.leftKeyDown = false;
                    break;
                case RIGHT:
                    Globals.rightKeyDown = false;
                    break;
            }
        });
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();
    }

    public void setGameBackground(Image gameBackground) {
        setBackground(new Background(new BackgroundImage(gameBackground,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }
}