package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.snakes.SnakeBody;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

public class MenuFactory {

    public static MenuBar getMenuBar() {

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create menus
        Menu gameMenu = new Menu("Game");

        // Create MenuItems
        MenuItem newItem = new MenuItem("New Game");
        MenuItem exitItem = new MenuItem("Exit Game");

        // Set Accelerator for MenuItems.
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

        // When user click on the New item.
        newItem.setOnAction(__ -> {
//            for (GameEntity gameObject : Globals.gameObjects) {
//                Globals.removeGameObject(gameObject);
//            }
//            System.out.println(Globals.gameObjects);
//            Game game = new Game();
//            game.start();
        });

        // When user click on the Exit item.
        exitItem.setOnAction(__ -> {
            System.exit(0);
        });

        // Add menuItems to the Menus
        gameMenu.getItems().addAll(newItem, exitItem);

        // Add Menus to the MenuBar
        menuBar.getMenus().add(gameMenu);

        return menuBar;
    }
}