package srhe.dittmar.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface extends Menu {
    private final String MENU_NAME = "Account Overview";
    private List<IMenu> menuList = new ArrayList<>();

    public UserInterface() {
        super.setName(MENU_NAME);
        menuList.add(new DepositUI());
        menuList.add(new WithdrawUI());
        menuList.add(new TransferUI());
        menuList.add(new AccountDetailsUI());
        menuList.add(new ExitMenu());

    }
    @Override
    public void showDialog() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------" + MENU_NAME + "--------");
            System.out.println("Hello " + super.getAccount().getCustomerName() + ", your current account balance is " +
                 String.format("%,d,00€",super.getAccount().getAccountValue()));
            System.out.println("Choose your action");
            for (int i = 0; i < menuList.size(); i++)
            {
                System.out.println(i + 1 + ":" + menuList.get(i).getName());
            }
            int choice = scanner.nextInt();
            menuList.get(choice - 1).setAccount(super.getAccount());
            menuList.get(choice - 1).setAccountManagement(super.getAccountManagement());
            menuList.get(choice - 1).showDialog();
            if (choice == 5)
            {
                break;
            }
        }
    }
}
