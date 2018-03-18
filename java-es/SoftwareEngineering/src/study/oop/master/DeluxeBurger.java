package study.oop.master;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("Delux", "Sausage & Bacon", 14.4, "White");
        super.addHamburgerAddition1("Chips", 254);
        super.addHamburgerAddition2("Drink", 1.43);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Can not add addtional burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Can not add addtional burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Can not add addtional burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Can not add addtional burger");
    }
}
