package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Game game = new Game();

        BorderPane root = new BorderPane();
        root.setTop(MenuFactory.getMenuBar());
        root.setBottom(game);

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(root, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        game.start();
    }

}
