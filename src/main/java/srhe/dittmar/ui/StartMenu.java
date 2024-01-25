package srhe.dittmar.ui;
import srhe.dittmar.logic.AccountManagement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StartMenu {
    private final String MENU_NAME = "Login";
    private AccountManagement accountManagement;

    public StartMenu(AccountManagement accountManagement) {
        this.accountManagement = accountManagement;
    }
    public void showDialog() {
        Scanner scanner = new Scanner(System.in);
        int accountNumber;
        int pin;

        while (true) {
            try {
                System.out.println("--------" + MENU_NAME + "--------" );
                System.out.println("Please enter your account number:");
                accountNumber = scanner.nextInt();
                System.out.println("Please enter your pin:");
                pin = scanner.nextInt();

                if (accountManagement.login(accountNumber,pin) != null)
                {
                    IMenu userInterface = new UserInterface();
                    userInterface.setAccount(accountManagement.loadAccount(accountNumber));
                    userInterface.setAccountManagement(accountManagement);
                    userInterface.showDialog();
                    break;
                }
                else
                {
                    if (accountManagement.lockAccount(accountNumber,pin))
                    {
                        System.out.println("Account is now locked due to too many failed logins. " +
                                "Please contact support for more information");}
                    else if (!accountManagement.checkStatus(accountNumber))
                    {
                        System.out.println("The account is locked, please contact support for more information");
                    }
                    else
                    {
                    System.out.println("account number or pin incorrect");
                    System.out.println();}
                }


            } catch (InputMismatchException exception )
            {
                System.out.println("Only numbers are allowed");
                scanner.nextLine();
            }
        }
    }
}

