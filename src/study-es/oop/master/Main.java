package study.oop.master;

public class Main {
    public static void main (String[] args){
        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");


        double price = hamburger.itemizeHamburger();
        System.out.println("Total === " + price);

        System.out.println("---------");

        hamburger.addHamburgerAddition1("Tomato", 8.23);
        hamburger.addHamburgerAddition2("Cheese", 1.23);
        hamburger.addHamburgerAddition3("Tomato", 8.23);
        hamburger.addHamburgerAddition4("Cheese", 1.23);
        System.out.println("Total === " + hamburger.itemizeHamburger());


        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.64);
        healthyBurger.addHealthyAddition1("Egg", 1.3);
        healthyBurger.addHealthyAddition1("Lentls", 3.11);
        healthyBurger.itemizeHamburger();

        DeluxeBurger db = new DeluxeBurger();
        db.itemizeHamburger();
        db.addHamburgerAddition1("Should not do this", 50.32);
    }
}
