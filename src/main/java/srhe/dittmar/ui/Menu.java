package srhe.dittmar.ui;

import srhe.dittmar.account.Account;
import srhe.dittmar.logic.AccountManagement;

public abstract class Menu implements IMenu {

    private String name = "Menu";
    private Account account;
    private AccountManagement accountManagement;

    @Override
    public void showDialog() {

    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public void setAccountManagement(AccountManagement accountManagement) {
        this.accountManagement = accountManagement;
    }

    public AccountManagement getAccountManagement() {
        return accountManagement;
    }
}
