package srhe.dittmar.gui.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame {

    private JButton login;
    private JLabel infoText;
    private JTextField fieldAccountNumber;
    private JPasswordField fieldPin;

    public Login() {
        JFrame frame = new JFrame("ATM");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setSize(400,200);
        GridBagConstraints constraints = new GridBagConstraints();

        fieldAccountNumber = new JTextField();
        addHint(fieldAccountNumber, "Account number");
        fieldAccountNumber.setPreferredSize(new Dimension(90,20));

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = 10;
        constraints.insets = new Insets(15,10,0,0);
        frame.add(fieldAccountNumber,constraints);

        fieldPin = new JPasswordField();
        addHintPassword(fieldPin,"pin");
        fieldPin.setPreferredSize(new Dimension(90,20));

        fieldPin.setEchoChar((char) 0);


        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.ipadx = 10;
        constraints.insets = new Insets(15,10,0,0);
        frame.add(fieldPin,constraints);

        login = new JButton();
        login.setText("login");

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(15,10,0,0);

        frame.add(login,constraints);



        pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Login login = new Login();
    }

    public static void addHint(JTextField textField, String hint) {
        // Set the foreground color to a light gray
        textField.setForeground(Color.GRAY);

        // Set the hint text as the initial text of the JTextField
        textField.setText(hint);

        // Add a focus listener to remove the hint when the JTextField gains focus
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(hint)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(hint);
                }
            }
        });
    }

    public static void addHintPassword(JPasswordField passwordField, String hint) {
        // Set the tool tip text as the hint
        passwordField.setToolTipText(hint);

        // Add a focus listener to clear the hint when the JPasswordField gains focus
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                char[] password = passwordField.getPassword();
                if (password.length == 0 || String.valueOf(password).equals(hint)) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*'); // Reset the echo char for password masking
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                char[] password = passwordField.getPassword();
                if (password.length == 0) {
                    passwordField.setText(hint);
                    passwordField.setEchoChar((char) 0); // Show the hint as plain text
                }
            }
        });
    }


}
