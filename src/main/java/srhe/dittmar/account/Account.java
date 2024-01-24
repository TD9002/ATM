package srhe.dittmar.account;

public class Account implements IAccount {
    private int accountNumber;
    private String customerName;
    private int pin;
    private double accountValue;
    public boolean state;


    public Account(int accountNumber, String customerName, int pin, double accountValue) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.pin = pin;
        this.accountValue = accountValue;
        state = true;

    }

    @Override
    public boolean withdraw(int amount) {
        return false;
    }

    @Override
    public boolean deposit(int amount) {
        return false;
    }

    @Override
    public boolean transfer() {
        return false;
    }

    @Override
    public boolean printAccount() {
        return false;
    }

    @Override
    public boolean showAccountState() {
        return false;
    }
}
