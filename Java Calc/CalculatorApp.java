import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorApp extends JFrame implements ActionListener {
    private JTextField textField;
    private String operator;
    private double num1, num2, result;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton;
    private JPanel panel;

    public CalculatorApp() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 550);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setPreferredSize(new Dimension(400, 70));
        add(textField, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            numberButtons[i].setForeground(Color.BLACK);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }

        addButton = createFunctionButton("+");
        subButton = createFunctionButton("-");
        mulButton = createFunctionButton("*");
        divButton = createFunctionButton("/");
        decButton = createFunctionButton(".");
        equButton = createFunctionButton("=");
        delButton = createFunctionButton("Del");
        clrButton = createFunctionButton("Clr");

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        add(panel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2, 10, 10));
        bottomPanel.add(clrButton);
        bottomPanel.add(delButton);
        bottomPanel.setPreferredSize(new Dimension(400, 70));
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JButton createFunctionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.BLACK);
        button.setFocusable(false);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String text = textField.getText();
            textField.setText(text.isEmpty() ? "" : text.substring(0, text.length() - 1));
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}
