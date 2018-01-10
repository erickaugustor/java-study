package com.company;

public class Motherboard {
    private String model;
    private String manufacturer;
    private int rawSlots;
    private int cardsSlotes;
    private String bios;

    public Motherboard(String model, String manufacturer, int rawSlots, int cardsSlotes, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.rawSlots = rawSlots;
        this.cardsSlotes = cardsSlotes;
        this.bios = bios;
    }


    public void loadProgram(String programName){
        System.out.println("Program "+ programName + " is now loading...");
    }



    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRawSlots() {
        return rawSlots;
    }

    public int getCardsSlotes() {
        return cardsSlotes;
    }

    public String getBios() {
        return bios;
    }
}
