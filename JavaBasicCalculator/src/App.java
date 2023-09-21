import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener{

    private JTextField display;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton,
            equalsButton, clearButton;
    private double num1, num2;
    private char operator;

    public App() {
        setTitle("This is Calculator App");
        setSize(300, 400);
        setLayout(new BorderLayout());
        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
        numberButtons[i] = new JButton(String.valueOf(i));
        numberButtons[i].addActionListener(this);
        panel.add(numberButtons[i]);
        }
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(equalsButton);
        panel.add(clearButton);
        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

  @Override
        public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9')) {
        display.setText(display.getText() + command);
        } else if (command.charAt(0) == 'C') {
        } else if (command.charAt(0) == '=') {
        num2 = Double.parseDouble(display.getText());
        switch (operator) {
        case '+':
        display.setText(String.valueOf(num1 + num2));
        break;
        case '-':
        display.setText(String.valueOf(num1 - num2));
        break;
        case '*':
        display.setText(String.valueOf(num1 * num2));
        break;
        case '/':
        display.setText(String.valueOf(num1 / num2));
        break;
        }
        } else {
        if (!display.getText().isEmpty()) {
        num1 = Double.parseDouble(display.getText());
        operator = command.charAt(0);
        display.setText("");
        }
        }
        }

    public static void main(String[] args) throws Exception {
                new App();
            }
        
}
