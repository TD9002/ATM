package srhe.dittmar.ui;

import srhe.dittmar.Validation;
import srhe.dittmar.account.Transaction;

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
            int amount = scanner.nextInt();
            if (amount == 0)
            {
                System.out.println("Aborted");
                break;
            }
            if (Validation.depositAmountValidation(amount) == 1)
            {
                System.out.println("Amount less than 10€.");
            }
            else if (Validation.depositAmountValidation(amount) == 2)
            {
                System.out.println("Amount more than 10.000€.");
            }
            else if (Validation.depositAmountValidation(amount) == 3)
            {
                if (!Validation.incrementValidation(amount))
                {
                    System.out.println("Deposit only in increments of 10 possible");
                }
                else
                {
                    super.getAccountManagement().depositMoney(amount,super.getAccount().getAccountNumber());
                    super.getAccountManagement().addLogEntry(new Transaction(Transaction.TransactionType.deposit,amount),super.getAccount());
                    System.out.println(String.format("%,d,00€",amount) + " deposited.");
                    for (int i = 0; i <super.getAccountManagement().getInMemoryDB().getAccountList().size() ; i++)
                    {
                       if(super.getAccountManagement().getInMemoryDB().getAccountList().get(i).getAccountNumber() ==
                               super.getAccount().getAccountNumber())
                       {
                           super.setAccount(super.getAccountManagement().getInMemoryDB().getAccountList().get(i));
                       }
                    }
                    System.out.println("New account balance is " + String.format("%,d,00€",super.getAccount().getAccountValue()));
                    break;
                }
            }
        }
    }
}