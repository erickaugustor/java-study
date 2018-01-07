package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bobAccount = new Bank("12345", 0.00, "Bob", "teste", "teste");
        Bank test = new Bank();
        //Bank() created the constructor

        bobAccount.getAccountBalance();


        bobAccount.withdrawal(100.0);

        bobAccount.deposit(50.0);
        bobAccount.withdrawal(100);

        bobAccount.deposit(50.0);
        bobAccount.withdrawal(100.0);

        VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getEmail());

        VipCustomer person2 = new VipCustomer("Bob", 1200);
        System.out.println(person2.getEmail());

        VipCustomer person3 = new VipCustomer("Tim", 10.20, "teste");
        System.out.println(person3.getName());
    }
}
