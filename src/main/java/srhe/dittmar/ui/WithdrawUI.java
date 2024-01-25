package srhe.dittmar.ui;

import srhe.dittmar.Validation;
import srhe.dittmar.account.Transaction;

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
            int amount = scanner.nextInt();
            if (amount == 0)
            {
                System.out.println("Aborted");
                break;
            }
            if (!Validation.withdrawAmountValidation(amount, super.getAccount().getAccountValue()))
            {
                System.out.println("Withdrawl amount exceeds current balance value.");
            }
            else
            {
                if (Validation.incrementValidation(amount))
                {
                    super.getAccountManagement().withdrawMoney(amount,super.getAccount().getAccountNumber());
                    super.getAccountManagement().addLogEntry(new Transaction(Transaction.TransactionType.withdrawal,amount),super.getAccount());
                    System.out.println(String.format("%,d,00€",amount) + " withdrawn.");
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
                else
                {
                    System.out.println("Withdrawal only in increments of 10 possible. ");
                }
            }
        }
    }
}