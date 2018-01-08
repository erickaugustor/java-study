package com.company;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Animal", 1, 1, 3, 5);

        Dog dog = new Dog("Yorkie", 8, 20, 3, 4, 1, 20, "long silky");
        dog.eat();
        dog.walk();
        dog.run();
    }
}
