package srhe.dittmar.ui.userMenu;

import srhe.dittmar.Validation;
import srhe.dittmar.ui.Menu;

import java.util.Scanner;

public class TransferUI extends Menu {
    private final String MENU_NAME = "Transfer";

    public TransferUI() {
        super.setName(MENU_NAME);
    }

    @Override
    public void showDialog() {
        while (true) {
            System.out.println("--------" + MENU_NAME + "--------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the recipient's account number.");
            int recipientAccountNumber = scanner.nextInt();
            System.out.println("Enter the name of the account holder.");
            String name = scanner.next().toLowerCase();
            System.out.println("Enter the transfer amount");
            double transferAmount = scanner.nextDouble();
            System.out.println("Transfer " + String.format("%,.2f€", transferAmount) + " to" + " account number:" + recipientAccountNumber +
                    " account holder:" + name + "?,(yes, no or abort) ");
            String confirmation = scanner.next().toLowerCase();
            if (confirmation.equals("abort")) {
                break;
            }
            else if (confirmation.equals("yes")){
                System.out.println("Enter pin for transfer");
                int transferPin = scanner.nextInt();
                if (transferPin == super.getAccount().getPin()) {
                    if (!Validation.withdrawAmountValidation(transferAmount, super.getAccount().getAccountValue())) {
                        System.out.println("Transfer amount exceeds current balance value of:" + String.format("%+,.2f€", super.getAccount().getAccountValue()));
                        if (askAgain()) break;
                    } else {
                        if (!Validation.ceckIfAccountHolderExists(name,super.getAccountManagement().getInMemoryDB())){
                            System.out.println("Account holder does not exist.");
                            if (askAgain()) break;
                        }
                        if (!Validation.ceckIfAccountNumberExists(recipientAccountNumber,super.getAccountManagement().getInMemoryDB())){
                            System.out.println("Recipient's account number does not exist.");
                            if (askAgain()) break;
                        }
                        if (super.getAccountManagement().transferMoney(recipientAccountNumber, name, transferAmount, super.getAccount())){
                            super.getAccountManagement().addTransferLog(recipientAccountNumber,name,super.getAccount(),transferAmount);
                            super.updateAccount();
                            break;
                        }
                    }
                } else {
                    System.out.println("Incorrect pin.");
                    if (askAgain()) break;
                }
            }
        }
    }

    public boolean askAgain(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Again or back to account overview? (yes or no)");
        String choice = scanner.next().toLowerCase();
        return choice.equals("no");
    }
}