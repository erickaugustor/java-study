package com.company;

public class Bedroom {
    private String name;
    private Wall wallone;
    private Wall walltwo;
    private Wall wallthree;
    private Wall wallfour;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    public Bedroom(String name, Wall wallone, Wall walltwo, Wall wallthree, Wall wallfour, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wallone = wallone;
        this.walltwo = walltwo;
        this.wallthree = wallthree;
        this.wallfour = wallfour;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public Lamp getLamp() {
        return lamp;
    }

    public void makeBed(){
        System.out.println("Bedroom -> Making bed");
        bed.make();
    }

}
