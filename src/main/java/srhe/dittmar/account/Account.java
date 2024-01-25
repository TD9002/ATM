package srhe.dittmar.account;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
    private int accountNumber;
    private String customerName;
    private int pin;
    private int accountValue;
    private boolean state;
    private int counter = 0;
    private List<Transaction> transactionList = new ArrayList<>();


    public Account(int accountNumber, String customerName, int pin, int accountValue) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.pin = pin;
        this.accountValue = accountValue;
        state = true;

    }

    @Override
    public boolean withdraw(int amount) {
        accountValue -= amount;
        return true;
    }

    @Override
    public boolean deposit(int amount) {
        accountValue += amount;
        return true;
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
    public int getAccountNumber() {
        return accountNumber;
    }
    @Override
    public int getPin() {
        return pin;
    }
    @Override
    public String getCustomerName() {
        return customerName;
    }
    @Override
    public boolean isState() {
        return state;
    }

    @Override
    public void setState(boolean state) {
        this.state = state;
    }
    @Override
    public int getCounter() {
        return counter;
    }
    @Override
    public void setCounter(int counter) {
        this.counter = counter;
    }
    @Override
    public int getAccountValue() {
        return accountValue;
    }

    @Override
    public boolean addTransaction(Transaction transaction) {
       return transactionList.add(transaction);
    }
    @Override
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", customerName='" + customerName + '\'' +
                ", pin=" + pin +
                ", accountValue=" + accountValue +
                ", state=" + state +
                '}';
    }
}
