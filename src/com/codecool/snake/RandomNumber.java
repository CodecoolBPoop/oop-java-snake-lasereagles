package com.codecool.snake;

import java.util.Random;

public class RandomNumber {


    public static double getRandomDouble(){
        Random number = new Random();
        return number.nextDouble();
    }

}
