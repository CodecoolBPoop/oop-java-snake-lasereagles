package com.codecool.snake;

import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StageSetter {

    public static Stage setStage(Game game, Stage primaryStage) {

        game.setGameBackground(Globals.background);
        game.getChildren().add(SnakeHead.create());
        game.getChildren().add(game.addVBox(game));
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();

        return primaryStage;
    }

}
