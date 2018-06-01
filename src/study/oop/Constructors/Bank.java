package study.oop.Constructors;

public class Bank {
    private String accountNumber;
    private double accountBalance;
    private String costumerName;
    private String costumerEmailAddress;
    private String costumerPhoneNumber;


    public Bank(){
        //default values!
        //Object was created


        //System.out.println("Empty constructor was called");
        this("53984", 2.50, "Default", "Default", "Default");
        System.out.println("Empty constructor was called");
    }

    public Bank(String number, double balance, String customerName, String customerNameAddress, String customerPhoneNumber){

     //setAccountNumber(number);
     this.accountNumber = number;
     this.accountBalance = balance;
     this.costumerName = customerName;
     this.costumerEmailAddress = customerNameAddress;
     this.costumerEmailAddress = customerPhoneNumber;

     System.out.println("Was called");
    }








    public void deposit(double depositAmount){
        this.accountBalance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " mode. Now balance is " + this.accountBalance);
    }

    public void withdrawal(double withdrawalAccount){
        if(accountBalance - withdrawalAccount <= 0){
            System.out.println("Only " + this.accountBalance + " available. Withdrawal not processed");
        } else {
            accountBalance -= withdrawalAccount;
            System.out.println("Withdrawal of " + withdrawalAccount + " processed. Remaining balance = " + this.accountBalance);
        }
    }





    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }


    public String getCostumerName() {
        return costumerName;
    }

    public void setCostumerName(String costumerName) {
        this.costumerName = costumerName;
    }


    public String getCostumerEmailAddress() {
        return costumerEmailAddress;
    }

    public void setCostumerEmailAddress(String costumerEmailAddress) {
        this.costumerEmailAddress = costumerEmailAddress;
    }


    public String getCostumerPhoneNumber() {
        return costumerPhoneNumber;
    }

    public void setCostumerPhoneNumber(String costumerPhoneNumber) {
        this.costumerPhoneNumber = costumerPhoneNumber;
    }
}
