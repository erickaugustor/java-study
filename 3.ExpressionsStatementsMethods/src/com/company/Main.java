package com.company;

public class Main {

    public static void main(String[] args) {

        //Expressions
        //Ex: a = 100;
        // a mile is equal to 1.609344 kilometres
        double kilometres = (100 * 1.609344);

        int highScore = 50;
        if(highScore == 50){
            System.out.println("This is an expression");
        }



        //Statements
        //Entire line!
        int myVariable = 50;
        myVariable++;
        myVariable--;
        System.out.println("This is a test");

        System.out.println("This is" +
                           " another ");

        System.out.println("This is" + " my code");

        int anotherVariable = 50; myVariable--;


s
        //If, else
        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

        if(score == 5000)
        System.out.println("Your score was 5000");

        if(gameOver){
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }



        //Methods
        calculateScore(true, 1000, 8,100);

    }

    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        if(gameOver){
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
}
