package com.codecool.snake;

import java.util.Random;

public class RandomNumber {

    public static int getRandomInt(){
        Random number = new Random();
        int num = number.nextInt();
        System.out.println(num);
        return num;
    }

    public static double getRandomDouble(){
        Random number = new Random();
        double intt =  number.nextDouble();
        System.out.println(intt);
        return intt;
    }

}
