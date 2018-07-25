package com.codecool.snake;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MenuFactory {

    public static MenuBar getMenuBar(Game game, Stage primaryStage) {

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create menus
        Menu gameMenu = new Menu("Game");

        // Create MenuItems
        MenuItem singlePlayer = new MenuItem("Single Player");
        MenuItem multiPlayer = new MenuItem("Multi Player");
        MenuItem exitGame = new MenuItem("Exit Game");

        // Set Accelerator for MenuItems.
        singlePlayer.setAccelerator(KeyCombination.keyCombination("Ctrl+1"));
        multiPlayer.setAccelerator(KeyCombination.keyCombination("Ctrl+2"));
        exitGame.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

        // When user click on the Single Player item.
        singlePlayer.setOnAction(__ -> {
            primaryStage.close();
            StageSetter.setStage(game, primaryStage);
            game.start();
        });

        // When user click on the Multi Player item.
        multiPlayer.setOnAction(__ -> {

        });

        // When user click on the Exit Game item.
        exitGame.setOnAction(__ -> {
            System.exit(0);
        });

        // Add menuItems to the Menus
        gameMenu.getItems().addAll(singlePlayer, multiPlayer, exitGame);

        // Add Menus to the MenuBar
        menuBar.getMenus().add(gameMenu);

        return menuBar;
    }
}