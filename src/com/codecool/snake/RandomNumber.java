package com.codecool.snake;

import java.util.Random;

public class RandomNumber {

    public static int getRandomInt(){ // I dont neew this
        Random number = new Random();
        return number.nextInt();
    }

    public static double getRandomDouble(){
        Random number = new Random();
        return number.nextDouble();
    }

}
