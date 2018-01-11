package com.company;

public class Main {

    public static void main(String[] args) {

        Wall wallone = new Wall("West");
        Wall walltwo = new Wall("West");
        Wall wallthree = new Wall("West");
        Wall wallfour = new Wall("West");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 4, 3, 2, 1);

        Lamp lamp = new Lamp("Classiic", false, 75);

        Bedroom bedroom = new Bedroom("Tim", wallone, walltwo, wallthree, wallfour, ceiling, bed, lamp);

        bedroom.makeBed();
        bedroom.getLamp().turnOn();
    }
}
