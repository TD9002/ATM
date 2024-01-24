package srhe.dittmar;

import srhe.dittmar.account.Account;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Account frank = new Account(1,"Frank",1111,-660);
        Account till = new Account(2,"Till", 2222, 100000);

        List<Account> konten = new ArrayList<>();
        konten.add(frank);
        konten.add(till);



    }
}