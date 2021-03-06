package com.codecool.snake;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Game game = new Game();

        StageSetter.setStage(game, primaryStage);

        game.start();
    }
}
