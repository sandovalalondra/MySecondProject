import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankApplicationGUI extends JFrame {

    private double balance;
    private JTextField amountField;
    private JLabel balanceLabel;

    public BankApplicationGUI() {
        balance = 0.0;

        setTitle("Bank Balance Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        JLabel instructionLabel = new JLabel("Enter amount:");
        amountField = new JTextField();

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton showBalanceButton = new JButton("Show Balance");

        balanceLabel = new JLabel("Current Balance: $0.00");

        depositButton.addActionListener(new ButtonListener());
        withdrawButton.addActionListener(new ButtonListener());
        showBalanceButton.addActionListener(new ButtonListener());

        panel.add(instructionLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(showBalanceButton);
        panel.add(balanceLabel);

        add(panel);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            try {
                if (command.equals("Show Balance")) {
                    balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
                    return;
                }

                double amount = Double.parseDouble(amountField.getText());

                if (amount <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter an amount greater than 0.");
                    return;
                }

                if (command.equals("Deposit")) {
                    balance += amount;
                } else if (command.equals("Withdraw")) {
                    if (amount <= balance) {
                        balance -= amount;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient funds.");
                    }
                }

                balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
                amountField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        new BankApplicationGUI();
    }
}