package srhe.dittmar.account;

import java.time.ZonedDateTime;

public class Transaction {
    public enum TransactionType {
        deposit,
        withdrawal,
        transfer
    }

    private ZonedDateTime transactionTime;
    private TransactionType transactionType;
    private double amount;

    public Transaction(TransactionType transactionType, double amount) {
        transactionTime = ZonedDateTime.now();
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public ZonedDateTime getTransactionTime() {
        return transactionTime;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionTime=" + transactionTime +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                '}';
    }
}
