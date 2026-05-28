import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class MenuInterfaceApp extends JFrame {

    private JTextArea textBox;
    private JPanel mainPanel;
    private String currentGreenHex = "";

    public MenuInterfaceApp() {
        setTitle("Menu Interface Application");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());

        textBox = new JTextArea();
        textBox.setEditable(false);
        textBox.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(textBox);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        setJMenuBar(createMenuBar());
        add(mainPanel);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem dateTimeItem = new JMenuItem("Print Date and Time");
        JMenuItem saveItem = new JMenuItem("Save to log.txt");
        JMenuItem greenItem = new JMenuItem("Change Green Hue");
        JMenuItem exitItem = new JMenuItem("Exit");

        dateTimeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printDateTime();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        greenItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeGreenHue(greenItem);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(dateTimeItem);
        menu.add(saveItem);
        menu.add(greenItem);
        menu.add(exitItem);

        menuBar.add(menu);

        return menuBar;
    }

    private void printDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

        textBox.setText("Current Date and Time:\n" + now.format(formatter));
    }

    private void saveToFile() {
        try {
            FileWriter writer = new FileWriter("log.txt");
            writer.write(textBox.getText());
            writer.close();

            JOptionPane.showMessageDialog(this, "Text box contents saved to log.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to file.");
        }
    }

    private void changeGreenHue(JMenuItem greenItem) {
        Random random = new Random();

        int red = random.nextInt(80);
        int green = 100 + random.nextInt(156);
        int blue = random.nextInt(80);

        Color randomGreen = new Color(red, green, blue);
        mainPanel.setBackground(randomGreen);
        textBox.setBackground(randomGreen);

        currentGreenHex = String.format("#%02X%02X%02X", red, green, blue);
        greenItem.setText("Green Hue: " + currentGreenHex);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuInterfaceApp().setVisible(true);
            }
        });
    }
}