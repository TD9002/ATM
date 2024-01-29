package srhe.dittmar.gui.UserMenu;

import srhe.dittmar.logic.AccountManagement;

import javax.swing.*;

public class DepositView extends UserView{
    public DepositView(AccountManagement accountManagement) {
        super(accountManagement);
    }
    private JLabel intructionText, infoText;
    private JTextField amount;
    private JButton confirm, back;
}
