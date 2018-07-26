package com.codecool.snake;

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

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);

        Button restartButton = new Button("Restart");
        // TODO button onAction need to be implemented

        Label label = new Label();
        String StrHighScore = Integer.toString(highscore);
        label.setText("Your HighScore is " + StrHighScore);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, restartButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();



    }
}
