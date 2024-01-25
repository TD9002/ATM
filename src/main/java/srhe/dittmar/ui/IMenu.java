package srhe.dittmar.ui;

import srhe.dittmar.account.Account;
import srhe.dittmar.logic.AccountManagement;

public interface IMenu {

    void showDialog();
    String getName();
    void setName(String name);
    void setAccount(Account account);
    void setAccountManagement(AccountManagement accountManagement);

    Account getAccount();

}
