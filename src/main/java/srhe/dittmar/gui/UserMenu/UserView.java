package srhe.dittmar.gui.UserMenu;

import srhe.dittmar.logic.AccountManagement;

public abstract class UserView {
    private AccountManagement accountManagement;

    public UserView (AccountManagement accountManagement) {
        this.accountManagement = accountManagement;
    }
}
