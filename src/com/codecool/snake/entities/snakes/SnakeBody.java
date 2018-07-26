package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;
import javafx.scene.effect.MotionBlur;
import javafx.scene.layout.Pane;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeBody extends GameEntity implements Animatable {

    public void motion(SnakeBody snakeb, Double radius) {
        MotionBlur motionBlur2 = new MotionBlur();
        motionBlur2.setRadius(radius);
        motionBlur2.setAngle(getRotate());
        snakeb.setEffect(motionBlur2);
    }

    private GameEntity parent;

    public Queue<Vec2d> getHistory() {
        return history;
    }

    private Queue<Vec2d> history = new LinkedList<>();
    private static final int historySize = 5; // is this the max length?

    public SnakeBody(Pane pane, GameEntity parent) {
        super(pane);
        this.parent = parent;
        setImage(Globals.snakeBody);

        // place it visually below the current tail
        List<Node> children = pane.getChildren();
        children.add(children.indexOf(parent), this);

        double xc = parent.getX();
        double yc = parent.getY();
        setX(xc);
        setY(yc);
        for (int i = 0; i < historySize; i++) {
            history.add(new Vec2d(xc, yc));
        }
        motion(this, 1.2);

/*       MotionBlur motionBlur2 = new MotionBlur();
        motionBlur2.setRadius(SnakeHead.getSpeed());
        motionBlur2.setAngle(getRotate());
        this.setEffect(motionBlur2);*/
    }

    public void step() {

        Vec2d pos = history.poll(); // remove the oldest item from the history
        setX(pos.x);
        setY(pos.y);
        motion(this, getX());
        history.add(new Vec2d(parent.getX(), parent.getY())); // add the parent's current position to the beginning of the history
    }

    public GameEntity createInstance(){
        return null;
    }

}
