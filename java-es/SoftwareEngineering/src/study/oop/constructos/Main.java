package study.oop.constructos;

public class Main {
    public static void main(String[] args){
        Constructors erickAccount = new Constructors();
        //Constructors() é um Construtor!

        erickAccount.setAccountBalance(0.00);

        erickAccount.withdrawal(100.0);
        erickAccount.deposit(50.0);
    }
}
