package srhe.dittmar.ui;

import srhe.dittmar.account.Account;
import srhe.dittmar.logic.AccountManagement;

public abstract class Menu implements IMenu {

    private String name = "Menu";
    private Account account;
    private AccountManagement accountManagement;

    public Menu(AccountManagement accountManagement) {
        this.accountManagement = accountManagement;
    }

    public Menu() {
    }

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

    public boolean updateAccount() {
        for (int i = 0; i < accountManagement.getInMemoryDB().getAccountList().size(); i++) {
            if (accountManagement.getInMemoryDB().getAccountList().get(i).getAccountNumber() ==
                    account.getAccountNumber()) {
                setAccount(accountManagement.getInMemoryDB().getAccountList().get(i));
                System.out.println(account.getAccountValue());
                return true;
            }
        }
        return false;
    }
}
