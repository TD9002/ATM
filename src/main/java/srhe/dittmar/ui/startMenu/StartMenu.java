package srhe.dittmar.ui.startMenu;

import srhe.dittmar.logic.AccountManagement;
import srhe.dittmar.ui.IMenu;
import srhe.dittmar.ui.Menu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartMenu extends Menu {
    private List<IMenu> menuList = new ArrayList<>();

    public StartMenu() {
        menuList.add(new LoginMenu(new AccountManagement()));
        menuList.add(new ExitMenu());
    }

    @Override
    public void showDialog() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println(i + 1 + ":" + menuList.get(i).getName());
            }
            int choice = scanner.nextInt();
            menuList.get(choice - 1).showDialog();
            if (choice == 2) {
                break;
            }
        }
    }
}
