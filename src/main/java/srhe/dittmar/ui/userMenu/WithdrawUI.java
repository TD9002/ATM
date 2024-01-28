package srhe.dittmar.ui.userMenu;

import srhe.dittmar.Validation;
import srhe.dittmar.account.Transaction;
import srhe.dittmar.ui.Menu;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class WithdrawUI extends Menu {
    private final String MENU_NAME = "Withdraw";

    public WithdrawUI() {
        super.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        while (true) {
            System.out.println("--------" + MENU_NAME + "--------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the amount you would like to withdraw.");
            System.out.println("Enter 0 to abort");
            try {
                double amount = scanner.nextDouble();
                if (amount == 0) {
                    System.out.println("Aborted");
                    break;
                }
                if (!Validation.incrementValidation(amount)) {
                    System.out.println("Withdrawal only in increments of 10 possible. ");
                } else {
                    String approval;
                    System.out.println("Do you want to withdraw " + String.format("%,.2f€", amount) + "?");
                    System.out.println("(yes or no)");
                    approval = scanner.next();
                    if (Objects.equals(approval, "yes")) {
                        if (!Validation.withdrawAmountValidation(amount, super.getAccount().getAccountValue())) {
                            System.out.println("Withdrawl amount exceeds current balance value of:" + String.format("%+,.2f€", super.getAccount().getAccountValue()));
                        } else {
                            System.out.println("Please take the money.");
                            System.out.println("Money taken? (yes or no)");
                            String moneyTaken = scanner.next().toLowerCase();
                            if (moneyTaken.equals("yes")) {
                                super.getAccountManagement().withdrawMoney(amount, super.getAccount().getAccountNumber());
                                super.getAccountManagement().addLogEntry(new Transaction(Transaction.TransactionType.withdrawal, -1 * amount), super.getAccount());
                                System.out.println(String.format("%+,.2f€", amount) + " withdrawn.");
                                for (int i = 0; i < super.getAccountManagement().getInMemoryDB().getAccountList().size(); i++) {
                                    if (super.getAccountManagement().getInMemoryDB().getAccountList().get(i).getAccountNumber() ==
                                            super.getAccount().getAccountNumber()) {
                                        super.setAccount(super.getAccountManagement().getInMemoryDB().getAccountList().get(i));
                                    }
                                }
                                // TODO: 26.01.2024 Abfrage ob geld genommen, dann erst update
                                System.out.println("New account balance is " + String.format("%+,.2f€", super.getAccount().getAccountValue()));
                                break;
                            }
                        }
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Only numbers allowed.");
            }
        }
    }
}