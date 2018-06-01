package study.dataType;

public class Main {

    public static void main(String[] args) {

        //DataTypes:


        //Integer has a width of 32
        int maxValue = 2_147_483_647;
        int minValue = -2_147_483_648;

        //Byte has a width of 8
        byte byteMaxValue = 127;
        byte byteMinValue = -128;
        byte myNewByteValue = (byte) (byteMinValue/2);

        //Short has a width of 16
        short shortMaxValue = 32767;
        short shortMinValue = -32768;

        //Put L in the end
        //Long has a witdh of 64
        long longValue = 9_223_372_036_854_775_807L;


        int myIntValue = 5/3;
        float myFloatValue = 5f/3f;
        //float myFloatValue = 5.4; daria erro, necessida casting! Java considera double!
        float myFloatCasting = (float) 5.4;
        double myDoubleValue = 5d/3d;


        char myChar = '\u00A9';
        System.out.println(myChar);

        boolean myBooleanFalse = false;
        boolean myBooleanTrue = true;


        String mySting = "This is a string!";

        boolean isCar = false;
        if(isCar == true)
            System.out.println("This is not supposed o happen");


        isCar = true;
        boolean wasCar = isCar ? true : false;
        if(wasCar)
            System.out.println("wasCar is true");
    }
}
