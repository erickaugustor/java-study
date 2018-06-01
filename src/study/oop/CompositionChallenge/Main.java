package study.oop.CompositionChallenge;

public class Main {

    public static void main(String[] args) {

        study.oop.CompositionChallenge.Wall wallone = new study.oop.CompositionChallenge.Wall("West");
        study.oop.CompositionChallenge.Wall walltwo = new study.oop.CompositionChallenge.Wall("West");
        study.oop.CompositionChallenge.Wall wallthree = new study.oop.CompositionChallenge.Wall("West");
        study.oop.CompositionChallenge.Wall wallfour = new study.oop.CompositionChallenge.Wall("West");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 4, 3, 2, 1);

        Lamp lamp = new Lamp("Classiic", false, 75);

        Bedroom bedroom = new Bedroom("Tim", wallone, walltwo, wallthree, wallfour, ceiling, bed, lamp);

        bedroom.makeBed();
        bedroom.getLamp().turnOn();
    }
}
