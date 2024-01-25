package srhe.dittmar.logic;

import srhe.dittmar.account.Account;
import srhe.dittmar.account.Transaction;
import srhe.dittmar.datenbank.InMemoryDB;


public class AccountManagement {

    private InMemoryDB inMemoryDB;

    public AccountManagement() {
        inMemoryDB = new InMemoryDB();
    }

    public Account login(int accountNumber, int pin) {

        for (int i = 0; i < inMemoryDB.getAccountList().size(); i++) {
            if (inMemoryDB.getAccountList().get(i).getAccountNumber() == accountNumber && inMemoryDB.getAccountList().
                    get(i).getPin() == pin && inMemoryDB.getAccountList().get(i).isState()) {
                inMemoryDB.getAccountList().get(i).setCounter(0);
                return inMemoryDB.getAccountList().get(i);
            }
        }
        return null;
    }

    public boolean lockAccount(int accountNumber, int pin) {

        for (int i = 0; i < inMemoryDB.getAccountList().size(); i++) {
            if (inMemoryDB.getAccountList().get(i).getAccountNumber() == accountNumber &&
                    inMemoryDB.getAccountList().get(i).getPin() != pin &&
                    inMemoryDB.getAccountList().get(i).isState() &&
                    inMemoryDB.getAccountList().get(i).getCounter() < 3)
            {
                inMemoryDB.getAccountList().get(i).setCounter(
                        inMemoryDB.getAccountList().get(i).getCounter() + 1);

                if (inMemoryDB.getAccountList().get(i).getAccountNumber() == accountNumber &&
                        inMemoryDB.getAccountList().get(i).getCounter() == 3)
                {
                    inMemoryDB.getAccountList().get(i).setState(false);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkStatus(int accountNumber) {
        for (int i = 0; i < inMemoryDB.getAccountList().size(); i++)
        {
            if (inMemoryDB.getAccountList().get(i).getAccountNumber() == accountNumber)
                return inMemoryDB.getAccountList().get(i).isState();
        }
        return true;
    }

    public Account loadAccount(int accountNumber) {
        for (int i = 0; i < inMemoryDB.getAccountList().size(); i++)
        {
            if (inMemoryDB.getAccountList().get(i).getAccountNumber() == accountNumber)
                return inMemoryDB.getAccountList().get(i);
        }
        return null;
    }

    public boolean depositMoney(int amount, int accountNumber) {
        for (int i = 0; i < inMemoryDB.getAccountList().size(); i++)
        {
            if (inMemoryDB.getAccountList().get(i).getAccountNumber() == accountNumber)
            {
                inMemoryDB.getAccountList().get(i).deposit(amount);
                Account account = inMemoryDB.getAccountList().get(i);
                inMemoryDB.updateAccount(accountNumber,account);
                return true;
            }
        }
        return false;
    }

    public boolean withdrawMoney (int amount, int accountNumber) {
        for (int i = 0; i < inMemoryDB.getAccountList().size(); i++) {
            if (inMemoryDB.getAccountList().get(i).getAccountNumber() == accountNumber)
            {
                inMemoryDB.getAccountList().get(i).withdraw(amount);
                Account account = inMemoryDB.getAccountList().get(i);
                inMemoryDB.updateAccount(accountNumber,account);
                return true;
            }
        }
        return false;
    }

    public boolean addLogEntry (Transaction transaction, Account account){
        if (transaction !=null)
            return account.addTransaction(transaction);
        return false;
    }

    public InMemoryDB getInMemoryDB() {
        return inMemoryDB;
    }
}