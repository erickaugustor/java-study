package study.oop.CompositionChallenge;

public class Bedroom {
    private String name;
    private study.oop.CompositionChallenge.Wall wallone;
    private study.oop.CompositionChallenge.Wall walltwo;
    private study.oop.CompositionChallenge.Wall wallthree;
    private study.oop.CompositionChallenge.Wall wallfour;
    private study.oop.CompositionChallenge.Ceiling ceiling;
    private study.oop.CompositionChallenge.Bed bed;
    private study.oop.CompositionChallenge.Lamp lamp;

    public Bedroom(String name, study.oop.CompositionChallenge.Wall wallone, study.oop.CompositionChallenge.Wall walltwo, study.oop.CompositionChallenge.Wall wallthree, study.oop.CompositionChallenge.Wall wallfour, study.oop.CompositionChallenge.Ceiling ceiling, study.oop.CompositionChallenge.Bed bed, study.oop.CompositionChallenge.Lamp lamp) {
        this.name = name;
        this.wallone = wallone;
        this.walltwo = walltwo;
        this.wallthree = wallthree;
        this.wallfour = wallfour;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public study.oop.CompositionChallenge.Lamp getLamp() {
        return lamp;
    }

    public void makeBed(){
        System.out.println("Bedroom -> Making bed");
        bed.make();
    }

}
