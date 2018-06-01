package study.oop.Constructors;

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

        study.oop.Constructors.VipCustomer person1 = new study.oop.Constructors.VipCustomer();
        System.out.println(person1.getEmail());

        study.oop.Constructors.VipCustomer person2 = new study.oop.Constructors.VipCustomer("Bob", 1200);
        System.out.println(person2.getEmail());

        study.oop.Constructors.VipCustomer person3 = new study.oop.Constructors.VipCustomer("Tim", 10.20, "teste");
        System.out.println(person3.getName());
    }
}
