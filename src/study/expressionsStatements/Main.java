package study.expressionsStatements;

public class Main {

    public static void main(String[] args) {
//
//        //Expressions
//        //Ex: a = 100;
//        // a mile is equal to 1.609344 kilometres
//        double kilometres = (100 * 1.609344);
//
//        int highScore = 50;
//        if(highScore == 50){
//            System.out.println("This is an expression");
//        }
//
//
//
//        //Statements
//        //Entire line!
//        int myVariable = 50;
//        myVariable++;
//        myVariable--;
//        System.out.println("This is a test");
//
//        System.out.println("This is" +
//                           " another ");
//
//        System.out.println("This is" + " my code");
//
//        int anotherVariable = 50; myVariable--;
//
//
//
//        //If, else
//        boolean gameOver = true;
//        int score = 5000;
//        int levelCompleted = 5;
//        int bonus = 100;
//
//        if(score == 5000)
//        System.out.println("Your score was 5000");
//
//        if(gameOver){
//            int finalScore = score + (levelCompleted * bonus);
//            System.out.println("Your final score was " + finalScore);
//        }
//
//
//
//        //Methods
//        calculateScore(true, 1000, 8,100);




        //Method Overloading
        //The same method name, with different parameters

//        int newScore = calculateScore("Tim", 500);
//        System.out.println("New score is " + newScore);
//        calculateScore(75);
//        calculateScore();

        calcFeetAndInchesToCentimeters(156);

    }


    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if((feet < 0) || (inches < 0) || (inches >12)){
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }

        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + "cm");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        if(inches < 0){
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet and = " + remainingInches );
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }
//    public static int calculateScore(String playerName, int score){
//        System.out.println("Player " + playerName + " scored " + score + " points");
//        return score * 1000;
//    }
//
//    public static int calculateScore(int score){
//        System.out.println("Unnamed player scored " + score + " points");
//        return score * 1000;
//    }
//
//    public static int calculateScore(){
//        System.out.println("No player name, no player score");
//        return 0;
//    }


//    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
//        if(gameOver){
//            int finalScore = score + (levelCompleted * bonus);
//            System.out.println("Your final score was " + finalScore);
//        }
//    }
}
