package com.codecool.snake;

import com.codecool.snake.entities.enemies.*;

import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

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

    public VBox addVBox(Game game) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 115, 12));
        vbox.setLayoutX(458);
        vbox.setLayoutY(70);
        vbox.setSpacing(10);


        Button buttonNewGame = new Button("Single");
        buttonNewGame.setPrefSize(100, 20);
        buttonNewGame.setOnAction(__ ->
        {
            Globals.gameLoop.stop();
            Globals.gameObjects.clear();
            Globals.oldGameObjects.clear();
            Globals.newGameObjects.clear();
            game.getChildren().clear();
            System.out.println("lefut");
            game.start();
            game.snake();
            game.setEnemy();
            game.setPowerUp();
            game.getChildren().add(SnakeHead.create());
            game.getChildren().add(game.addVBox(game));
            System.out.println("started a new game");

        });


        Button buttonRestartGame = new Button("Multi");
        buttonRestartGame.setPrefSize(100, 20);
        buttonRestartGame.setLayoutY(50);

        buttonRestartGame.setOnAction(__ ->
        {

            System.out.println("multi game");
        });

        vbox.getChildren().addAll(buttonNewGame, buttonRestartGame);
        return vbox;
    }

}