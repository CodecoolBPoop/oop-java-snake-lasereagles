package com.codecool.snake;

import com.codecool.snake.entities.enemies.*;
import com.codecool.snake.entities.powerups.*;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Game extends Pane {

    public Game() {
        snake1player();
        setEnemy();
        setPowerUp();
    }

    public void snake1player() {
        new SnakeHead(this, 500, 500);
    }

    public void snake2player() {
        new SnakeHead(this, 400, 400);
        new SnakeHead(this, 600, 400);
    }

    public void setEnemy(){
        for (int i = 0; i < 3; i++) {

            new LinkedIn(this);
            new Facebook(this);
            new Amazon(this);
        }
    }

    public void setPowerUp(){
        for (int i = 0; i < 4; i++) {
            new GdprSnakeGrow(this);
            new BlockchainSpeedUp(this);
            new FirewallHealthRestore(this);
        }

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
                case A:
                    Globals.aKeyDown  = true;
                    break;
                case D:
                    Globals.dKeyDown  = true;
                    break;
                case W:
                    Globals.topKeyDown = true;
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
                case A:
                    Globals.aKeyDown  = false;
                    break;
                case D:
                    Globals.dKeyDown  = false;
                    break;
                case W:
                    Globals.topKeyDown = false;
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
        vbox.setPadding(new Insets(5, 5, 5, 5));
        vbox.setLayoutX(5);
        vbox.setLayoutY(5);
        vbox.setSpacing(10);

        Button buttonSinglePlayer = new Button("1 Player");
        buttonSinglePlayer.setPrefSize(100, 20);
        buttonSinglePlayer.setOnAction(__ ->
        {
            Globals.gameLoop.stop();
            Globals.gameObjects.clear();
            Globals.oldGameObjects.clear();
            Globals.newGameObjects.clear();

            SnakeHead.instance = 0;
            SnakeHead.speed = 2;
            game.getChildren().clear();
            game.start();
            game.snake1player();
            game.setEnemy();
            game.setPowerUp();
            game.getChildren().add(SnakeHead.create());
            game.getChildren().add(game.addVBox(game));
        });

        Button buttonMultiPlayer = new Button("2 Players");
        buttonMultiPlayer.setPrefSize(100, 20);
        buttonMultiPlayer.setOnAction(__ ->
        {
            Globals.gameLoop.stop();
            Globals.gameObjects.clear();
            Globals.oldGameObjects.clear();
            Globals.newGameObjects.clear();

            SnakeHead.instance = 0;
            SnakeHead.speed = 2;
            game.getChildren().clear();
            game.start();
            game.snake2player();
            game.setEnemy();
            game.setPowerUp();
            game.getChildren().add(SnakeHead.create());
            game.getChildren().add(SnakeHead.createHealthPlayer2());

            game.getChildren().add(game.addVBox(game));

        });

        vbox.getChildren().addAll(buttonSinglePlayer, buttonMultiPlayer);
        return vbox;
    }

}