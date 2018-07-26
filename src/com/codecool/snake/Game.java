package com.codecool.snake;

import com.codecool.snake.entities.enemies.*;
import com.codecool.snake.entities.powerups.HealthRestore;
import com.codecool.snake.entities.powerups.GDPR;
import com.codecool.snake.entities.powerups.SpeedUp;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
            new GDPR(this);
            new SpeedUp(this);
            new HealthRestore(this);
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
            game.getChildren().clear();
            System.out.println("lefut");
            game.start();
            game.snake();
            game.setEnemy();
            game.setPowerUp();
            game.getChildren().add(SnakeHead.create());
            game.getChildren().add(game.addVBox(game));
            System.out.println("Started a single player game.");
        });

        Button buttonMultiPlayer = new Button("2 Players");
        buttonMultiPlayer.setPrefSize(100, 20);
        buttonMultiPlayer.setOnAction(__ ->
        {
            System.out.println("Started a multi player game.");
        });

        vbox.getChildren().addAll(buttonSinglePlayer, buttonMultiPlayer);
        return vbox;
    }

}