package study.oop.constructos;

public class Constructors {

    private String accountNumber;
    private double accountBalance;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;

    public Constructors(){
        this("58210", 2.43, "Default name", "Default name", "Default phone");
        // Call another constructor!
        // Must be the first line!

        System.out.println("Empty constructor called!");
    }

    public Constructors(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        this("99999", 100.55, customerName, customerEmailAddress, customerPhoneNumber);
    }

    public Constructors(String accountNumber,
                        double accountBalance,
                        String customerName,
                        String customerEmailAddress,
                        String customerPhoneNumber){

        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;

    }


    public void deposit(double depositAmount){
        this.accountBalance += depositAmount;
        System.out.println("Balance = " + this.accountBalance);
    }

    public void withdrawal(double withdrawsAccount){
        if(this.accountBalance - withdrawsAccount < 0){
            System.out.println("Only " + this.accountBalance + " available. Withdrawal not processed");
        }else{
            this.accountBalance -= withdrawsAccount;
            System.out.println("Balance = " + this.accountBalance);
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }



}
