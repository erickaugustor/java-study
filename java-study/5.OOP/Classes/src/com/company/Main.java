package com.company;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car();
        Car holden = new Car();
        //two objects created


        System.out.println("Model is " + porsche.getModel());
        porsche.setModel("Teste");
        System.out.println("Model is " + porsche.getModel());
        porsche.setModel("CARRERA");
        System.out.println("Model is " + porsche.getModel());
    }
}
