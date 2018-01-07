package com.company;

//access to the class, public is a access modifier
public class Car {

    //fields
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model){
        String validModel = model.toLowerCase();
        //validation

        if(validModel.equals("carrera") || validModel.equals("commodore"))
            this.model = model;
        else
            this.model = "Unknown";
    }

    public String getModel(){
        return this.model;
    }
}
