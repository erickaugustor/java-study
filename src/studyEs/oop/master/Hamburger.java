package study.oop.master;

public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String name, double price){
        this.addition1Name = name;
        this.addition1Price = price;
    }

    public void addHamburgerAddition2(String name, double price){
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void addHamburgerAddition3(String name, double price){
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void addHamburgerAddition4(String name, double price){
        this.addition4Name = name;
        this.addition4Price = price;
    }
    public double itemizeHamburger(){
        double HamburgerPrice = this.price;
        System.out.println(this.name + " hamburguer / " + this.breadRollType + " roll / " + this.price +" = price!");

        if(this.addition1Name != null){
            HamburgerPrice += this.addition1Price;
            System.out.println(this.addition1Name + " " + this.addition1Price);
        }

        if(this.addition2Name != null){
            HamburgerPrice += this.addition2Price;
            System.out.println(this.addition2Name + " " + this.addition2Price);
        }

        if(this.addition3Name != null){
            HamburgerPrice += this.addition3Price;
            System.out.println(this.addition3Name + " " + this.addition3Price);
        }

        if(this.addition4Name != null){
            HamburgerPrice += this.addition4Price;
            System.out.println(this.addition4Name + " " + this.addition4Price);
        }

        return HamburgerPrice;

    }
}

