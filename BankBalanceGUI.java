import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class BankBalanceGUI extends JFrame {
    private JTextField startingBalanceField;
    private JTextField amountField;
    private JLabel balanceLabel;
    private BankAccount2 account;
    private final DecimalFormat moneyFormat = new DecimalFormat("$#,##0.00");

    public BankBalanceGUI() {
        setTitle("Bank Balance Application");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        startingBalanceField = new JTextField();
        amountField = new JTextField();
        balanceLabel = new JLabel("Balance: $0.00");

        JButton createAccountButton = new JButton("Create Account");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton exitButton = new JButton("Exit");

        panel.add(new JLabel("Starting Balance:"));
        panel.add(startingBalanceField);
        panel.add(new JLabel("Deposit/Withdraw Amount:"));
        panel.add(amountField);
        panel.add(createAccountButton);
        panel.add(balanceLabel);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(exitButton);

        add(panel);

        // IMPROVED: Lambda expressions replace repetitive anonymous inner classes.
        createAccountButton.addActionListener(e -> createAccount());
        depositButton.addActionListener(e -> depositMoney());
        withdrawButton.addActionListener(e -> withdrawMoney());
        exitButton.addActionListener(e -> exitApplication());
    }

    private void createAccount() {
        try {
            double startingBalance = Double.parseDouble(startingBalanceField.getText());

            account = new BankAccount2(startingBalance);
            updateBalanceLabel();

            JOptionPane.showMessageDialog(this, "Account created successfully.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid starting balance.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void depositMoney() {
        if (!accountExists()) {
            return;
        }

        try {
            double amount = Double.parseDouble(amountField.getText());

            account.deposit(amount);
            updateBalanceLabel();

            JOptionPane.showMessageDialog(this, "Deposit successful.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid deposit amount.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void withdrawMoney() {
        if (!accountExists()) {
            return;
        }

        try {
            double amount = Double.parseDouble(amountField.getText());

            account.withdraw(amount);
            updateBalanceLabel();

            JOptionPane.showMessageDialog(this, "Withdrawal successful.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid withdrawal amount.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private boolean accountExists() {
        if (account == null) {
            JOptionPane.showMessageDialog(this, "Please create an account first.");
            return false;
        }
        return true;
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: " + moneyFormat.format(account.getBalance()));
    }

    private void exitApplication() {
        if (account != null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Remaining Balance: " + moneyFormat.format(account.getBalance())
            );
        } else {
            JOptionPane.showMessageDialog(this, "No account was created.");
        }

        System.exit(0);
    }

    public static void main(String[] args) {
        BankBalanceGUI app = new BankBalanceGUI();
        app.setVisible(true);
    }
}