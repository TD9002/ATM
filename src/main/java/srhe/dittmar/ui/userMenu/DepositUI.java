package srhe.dittmar.ui.userMenu;

import srhe.dittmar.Validation;
import srhe.dittmar.account.Transaction;
import srhe.dittmar.ui.Menu;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DepositUI extends Menu {

    private final String MENU_NAME = "Deposit";

    public DepositUI() {
        super.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------" + MENU_NAME + "--------");
            System.out.println("Please enter the amount you would like to deposit.");
            System.out.println("Minimum deposit 10€, Maximum 10.000€, only intervals of ten possible.");
            System.out.println("Enter 0 to abort");
            try {
            double amount = scanner.nextDouble();
            if (amount == 0) {
                System.out.println("Aborted");
            }
            if (!Validation.incrementValidation(amount)) {
                System.out.println("Deposit only in increments of 10 possible");
            }
            else if (Validation.depositAmountValidation(amount) == 1) {
                System.out.println("Amount less than 10€.");
            }
            else if (Validation.depositAmountValidation(amount) == 2) {
            System.out.println("Amount more than 10.000€.");
            }
            else if (Validation.depositAmountValidation(amount) == 3) {
                System.out.println("Do you want to deposit " + String.format("%,.2f€", amount) + "? (yes or no)");
                String approval = scanner.next().toLowerCase(Locale.ROOT);
                if (approval.equals("yes")) {
                    System.out.println("Please insert the money.");
                    System.out.println("Money inserted? (yes or no)");
                    String insertMoney = scanner.next().toLowerCase();
                    if (insertMoney.equals("yes")) {
                        super.getAccountManagement().depositMoney(amount, super.getAccount().getAccountNumber());
                        super.getAccountManagement().addLogEntry(new Transaction(Transaction.TransactionType.deposit, amount), super.getAccount());
                        System.out.println(String.format("%+,.2f€", amount) + " deposited.");
                        for (int i = 0; i < super.getAccountManagement().getInMemoryDB().getAccountList().size(); i++) {
                            if (super.getAccountManagement().getInMemoryDB().getAccountList().get(i).getAccountNumber() ==
                                    super.getAccount().getAccountNumber()) {
                                super.setAccount(super.getAccountManagement().getInMemoryDB().getAccountList().get(i));
                                }
                            }
                            System.out.println("New account balance is " + String.format("%+,.2f€", super.getAccount().getAccountValue()));
                            break;
                        }
                    }
                }
            }catch (InputMismatchException exception){
                System.out.println("Only numbers allowed.");
            }
        }
    }

}