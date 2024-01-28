package srhe.dittmar.ui.userMenu;

import srhe.dittmar.account.Transaction;
import srhe.dittmar.ui.Menu;

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
            String owner = super.getAccount().getCustomerName();
            int accountNumber = super.getAccount().getAccountNumber();
            double accountBalance = super.getAccount().getAccountValue();
            System.out.println("Account number: " + accountNumber + "|  Account owner: " + owner + " | Account balance: " + String.format("%+,.2f€",accountBalance));
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'|'HH:mm:ss");
            for (int i = 0; i < super.getAccount().getTransactionList().size(); i++)
            {
                Transaction transaction = super.getAccount().getTransactionList().get(i);
                    System.out.println(dateTimeFormatter.format(transaction.getTransactionTime()) + " || Transaction type: " +
                            String.format("%-12s|| %+,12.2f€",transaction.getTransactionType(),transaction.getAmount()));
                if (i == super.getAccount().getTransactionList().size()-1)
                {
                    System.out.println("Account balance = " + String.format("%+,.2f€",super.getAccount().getAccountValue()));
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