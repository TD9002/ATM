package srhe.dittmar.account;

import java.util.List;

public interface IAccount {

     boolean withdraw (int amount);
     boolean deposit (int amount);
     boolean transfer();
     boolean printAccount();
     boolean addTransaction(Transaction transaction);
     int getAccountNumber();
     int getPin();
     String getCustomerName();
     boolean isState();
     int getCounter();
     void setCounter(int counter);
     int getAccountValue();
     List<Transaction> getTransactionList();
     void setState(boolean state);


}
