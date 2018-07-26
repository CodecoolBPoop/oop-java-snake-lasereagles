package com.codecool.snake;

import com.codecool.snake.entities.snakes.SnakeHead;
import com.sun.xml.internal.bind.v2.TODO;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class GameOver {

    public static int highscore;

    public static void gameover(String title) {

        Game game = new Game();
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);

        Button buttonSinglePlayer = new Button("1 player");
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

        Button buttonMultiPlayer = new Button("2 players");
        buttonSinglePlayer.setPrefSize(100, 20);

        Label label = new Label();
        String StrHighScore = Integer.toString(highscore);
        label.setText("Your score is " + StrHighScore);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, buttonSinglePlayer, buttonMultiPlayer);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();



    }
}
