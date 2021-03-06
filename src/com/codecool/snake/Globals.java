package com.codecool.snake;

import com.codecool.snake.entities.GameEntity;
import javafx.scene.image.Image;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 700;

    public static Image snakeHead = new Image("snake_head.png");
    public static Image background = new Image("background.png");
    public static Image snakeBody = new Image("snake_body.png");
    public static Image linkedIn = new Image("linkedin.png"); // Itt a kép nem felel meg
    public static Image facebook = new Image("facebook.png");
    public static Image amazon = new Image("amazon.png");
    public static Image gdpr = new Image("gdpr.png");
    public static Image blockchain = new Image("blockchain.png");
    public static Image firewall = new Image("firewall.png");

    //.. put here the other images you want to use

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static boolean aKeyDown;
    public static boolean dKeyDown;
    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static GameLoop gameLoop;

    static {
        gameObjects = new LinkedList<>();
        newGameObjects = new LinkedList<>();
        oldGameObjects = new LinkedList<>();
    }

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }
}
