package srhe.dittmar;

import srhe.dittmar.logic.AccountManagement;
import srhe.dittmar.ui.StartMenu;
public class Main {
    public static void main(String[] args) {
        AccountManagement accountManagement = new AccountManagement();
        StartMenu startMenu = new StartMenu(accountManagement);
        startMenu.showDialog();
    }
}