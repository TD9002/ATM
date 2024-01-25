package srhe.dittmar.ui;

import srhe.dittmar.account.Transaction;

import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class AccountDetailsUI extends Menu {
    private final String MENU_NAME = "Account Details";

    public AccountDetailsUI() {
        super.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        while (true) {
            System.out.println("--------" + MENU_NAME + "--------");
            Scanner scanner = new Scanner(System.in);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'|'HH:mm:ss");
            for (int i = 0; i < super.getAccount().getTransactionList().size(); i++)
            {
                Transaction transaction = super.getAccount().getTransactionList().get(i);
                System.out.println(dateTimeFormatter.format(transaction.getTransactionTime()) + " || Transaction type: " +
                        transaction.getTransactionType() + " || Amount: " + String.format("%,d,00€",transaction.getAmount()));
                if (i == super.getAccount().getTransactionList().size()-1)
                {
                    System.out.println("Account balance = " + String.format("%,d,00€",super.getAccount().getAccountValue()));
                }
            }
            System.out.println("Go Back? (yes or no)");
            if (Objects.equals(scanner.nextLine(), "yes"))
            {
                break;
            }
        }
    }
}