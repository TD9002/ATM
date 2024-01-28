package srhe.dittmar;

import srhe.dittmar.datenbank.InMemoryDB;

import java.util.Locale;
import java.util.Objects;

public class Validation {

    public static int depositAmountValidation (double amount) {
        if (amount < 10)
        return 1;
        else if (amount >10000) {
            return 2;}
        else return 3;
    }
    public static boolean incrementValidation(double amount){
        return amount % 10 == 0;
    }

    public static boolean withdrawAmountValidation (double amount, double currentBalance){
        return amount <= currentBalance;
    }
    public static boolean ceckIfAccountNumberExists(int accountNumber, InMemoryDB inMemoryDB){
        for (int i = 0; i <inMemoryDB.getAccountList().size() ; i++) {
            if (accountNumber == inMemoryDB.getAccountList().get(i).getAccountNumber()){
                return true;
            }
        }
        return false;
    }
    public static boolean ceckIfAccountHolderExists(String accountHolder, InMemoryDB inMemoryDB){
        for (int i = 0; i <inMemoryDB.getAccountList().size() ; i++) {
            if (Objects.equals(accountHolder, inMemoryDB.getAccountList().get(i).getCustomerName().toLowerCase(Locale.ROOT))){
                return true;
            }
        }
        return false;
    }

}
