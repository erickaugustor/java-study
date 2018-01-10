package com.company;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("2208", "Dell", "248", dimensions);
        //System.out.println(theCase.getDimensions().getDepth());

        Monitor theMonitor = new Monitor("27inh Beast", "Acer", 27 , new Resolution(2548, 1440));

        Motherboard theMotherboard = new Motherboard("B3-3434", "Asus", 4, 5, "v5.22");

        PC thePC = new PC(theCase, theMonitor, theMotherboard);

        thePC.getMonitor().drawPixelArt(1500, 1200, "red");
        thePC.getMotherboard().loadProgram("Windows 1.0");
        thePC.getTheCase().pressPowerButton();
    }
}
