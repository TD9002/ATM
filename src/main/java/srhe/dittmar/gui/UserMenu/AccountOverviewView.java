package srhe.dittmar.gui.UserMenu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AccountOverviewView extends JFrame {
    private JButton deposit, withdrawal, transfer, accountDetails, logout;
    private JLabel welcomeText;
    private List<JButton> buttonList = new ArrayList<>();

    public AccountOverviewView(){
        deposit = new JButton("1. deposit");
        withdrawal = new JButton("2. withdrawal");
        transfer = new JButton("3. transfer");
        accountDetails = new JButton("4. detail");
        logout = new JButton("5. logout");


        buttonList.add(deposit);
        buttonList.add(withdrawal);
        buttonList.add(transfer);
        buttonList.add(accountDetails);
        buttonList.add(logout);

        JFrame frame = new JFrame("Menu");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(400,250);
        GridBagConstraints constraints = new GridBagConstraints();

        welcomeText = new JLabel();
        welcomeText.setText("Hello User");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = 10;
        constraints.insets = new Insets(15,10,0,0);
        frame.add(welcomeText);

        for (int i = 0; i <buttonList.size() ; i++) {
            buttonList.get(i).setPreferredSize(new Dimension(100,20));
            constraints.gridx = 0;
            constraints.gridy = 2+i;
            constraints.ipadx = 10;
            constraints.insets = new Insets(15,10,0,0);
            frame.add(buttonList.get(i),constraints);
        }
        pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AccountOverviewView accountOverviewView = new AccountOverviewView();
    }
}
