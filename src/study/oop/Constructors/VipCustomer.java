package study.oop.Constructors;

public class VipCustomer {

    private String name;
    private double creditLimit;
    private String email;



    public VipCustomer(){
        this("Default name", 50200.00, "default email");
    }

    public VipCustomer(String name, double creditLimit) {
        this(name, creditLimit, "unknowm@hotmail.com");
    }

    public VipCustomer(String name, double creditLimit, String email) {
        //unico que salva valores

        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

}
