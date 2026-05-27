import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class BankBalanceGUI extends JFrame {

    private JTextField startingBalanceField;
    private JTextField amountField;
    private JLabel balanceLabel;

    private BankAccount2 account;

    private DecimalFormat moneyFormat = new DecimalFormat("$#,##0.00");

    public BankBalanceGUI() {

        setTitle("Bank Balance Application");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel startingBalanceLabel = new JLabel("Starting Balance:");
        startingBalanceField = new JTextField();

        JLabel amountLabel = new JLabel("Deposit/Withdraw Amount:");
        amountField = new JTextField();

        JButton createAccountButton = new JButton("Create Account");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        balanceLabel = new JLabel("Balance: $0.00");

        panel.add(startingBalanceLabel);
        panel.add(startingBalanceField);

        panel.add(amountLabel);
        panel.add(amountField);

        panel.add(createAccountButton);
        panel.add(balanceLabel);

        panel.add(depositButton);
        panel.add(withdrawButton);

        panel.add(exitButton);

        add(panel);

        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    double startingBalance =
                            Double.parseDouble(startingBalanceField.getText());

                    account = new BankAccount2(startingBalance);

                    balanceLabel.setText(
                            "Balance: " +
                            moneyFormat.format(account.getBalance()));

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter a valid starting balance.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    if (account == null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Please create an account first.");
                        return;
                    }

                    double amount =
                            Double.parseDouble(amountField.getText());

                    account.deposit(amount);

                    balanceLabel.setText(
                            "Balance: " +
                            moneyFormat.format(account.getBalance()));

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter a valid deposit amount.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    if (account == null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Please create an account first.");
                        return;
                    }

                    double amount =
                            Double.parseDouble(amountField.getText());

                    account.withdraw(amount);

                    balanceLabel.setText(
                            "Balance: " +
                            moneyFormat.format(account.getBalance()));

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter a valid withdrawal amount.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (account != null) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Remaining Balance: " +
                            moneyFormat.format(account.getBalance()));

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "No account was created.");
                }

                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {

        BankBalanceGUI app = new BankBalanceGUI();
        app.setVisible(true);
    }
}