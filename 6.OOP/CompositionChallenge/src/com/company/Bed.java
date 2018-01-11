package com.company;

public class Bed {
    private String style;
    private int pillows;
    private int height;
    private int sheets;
    private int quit;

    public Bed(String style, int pillows, int height, int sheets, int quit) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quit = quit;
    }

    public void make(){
        System.out.println("Bed -> Making");
    }

    public String getStyle() {
        return style;
    }

    public int getPillows() {
        return pillows;
    }

    public int getHeight() {
        return height;
    }

    public int getSheets() {
        return sheets;
    }

    public int getQuit() {
        return quit;
    }
}
