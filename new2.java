import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class new2 extends JFrame implements ActionListener {
    JTextField text1 = new JTextField();

    // store operator and operands
    String s0, s1, s2;

    JButton button1 = new JButton("A");
    JButton button2 = new JButton("NOT");
    JButton button3 = new JButton("<<");
    JButton button4 = new JButton(">>");
    JButton button5 = new JButton("C");
    JButton button6 = new JButton("B");
    JButton button7 = new JButton("And");
    JButton button8 = new JButton("Or");
    JButton button9 = new JButton("XOR");
    JButton button10 = new JButton("+");
    JButton button11 = new JButton("C");
    JButton button12 = new JButton("7");
    JButton button13 = new JButton("8");
    JButton button14 = new JButton("9");
    JButton button15 = new JButton("-");
    JButton button16 = new JButton("D");
    JButton button17 = new JButton("4");
    JButton button18 = new JButton("5");
    JButton button19 = new JButton("6");
    JButton button20 = new JButton("*");
    JButton button21 = new JButton("E");
    JButton button22 = new JButton("1");
    JButton button23 = new JButton("2");
    JButton button24 = new JButton("3");
    JButton button25 = new JButton("/");
    JButton button26 = new JButton("F");
    JButton button28 = new JButton("0");
    JButton button30 = new JButton("=");

    JLabel blank1 = new JLabel("");
    JLabel blank2 = new JLabel("");
    JLabel blank4 = new JLabel("");
    JLabel blank5 = new JLabel("");
    JLabel blank6 = new JLabel("");

    JPanel panel1 = new JPanel();
    ButtonGroup radixGroup = new ButtonGroup();
    JRadioButton binaryRadio = new JRadioButton("Binary");
    JRadioButton decimalRadio = new JRadioButton("Decimal");
    JRadioButton hexadecimalRadio = new JRadioButton("Hexadecimal");

    public new2() {
        s0 = s1 = s2 = "";
        setTitle("Calculator");
        setSize(900, 900);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setLayout(new GridLayout(7, 5, 2, 2));
        setVisible(true);

        radixGroup.add(binaryRadio);
        radixGroup.add(decimalRadio);
        radixGroup.add(hexadecimalRadio);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(3, 1));
        radioPanel.add(binaryRadio);
        radioPanel.add(decimalRadio);
        radioPanel.add(hexadecimalRadio);

        panel1.add(radioPanel);

        panel1.add(text1);
        panel1.add(blank4);
        panel1.add(blank5);
        panel1.add(blank6);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(button6);
        panel1.add(button7);
        panel1.add(button8);
        panel1.add(button9);
        panel1.add(button10);
        panel1.add(button11);
        panel1.add(button12);
        panel1.add(button13);
        panel1.add(button14);
        panel1.add(button15);
        panel1.add(button16);
        panel1.add(button17);
        panel1.add(button18);
        panel1.add(button19);
        panel1.add(button20);
        panel1.add(button21);
        panel1.add(button22);
        panel1.add(button23);
        panel1.add(button24);
        panel1.add(button25);
        panel1.add(button26);
        panel1.add(blank1);
        panel1.add(button28);
        panel1.add(blank2);
        panel1.add(button30);

        binaryRadio.addActionListener(this);
        decimalRadio.addActionListener(this);
        hexadecimalRadio.addActionListener(this);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button10.addActionListener(this);
        button11.addActionListener(this);
        button12.addActionListener(this);
        button13.addActionListener(this);
        button14.addActionListener(this);
        button15.addActionListener(this);
        button16.addActionListener(this);
        button17.addActionListener(this);
        button18.addActionListener(this);
        button19.addActionListener(this);
        button20.addActionListener(this);
        button21.addActionListener(this);
        button22.addActionListener(this);
        button23.addActionListener(this);
        button24.addActionListener(this);
        button25.addActionListener(this);
        button26.addActionListener(this);
        button28.addActionListener(this);
        button30.addActionListener(this);

        add(panel1);
    }

    private void enableButtonsForBinary() {
        setButtonsEnabled("01", "23456789ABCDEF");
    }

    private void enableButtonsForDecimal() {
        setButtonsEnabled("0123456789", "ABCDEF");
    }

    private void enableAllButtons() {
        setButtonsEnabled("0123456789ABCDEF", "");
    }

    private void setButtonsEnabled(String enabledChars, String disabledChars) {
        for (Component comp : panel1.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                char buttonChar = button.getText().charAt(0);

                if (enabledChars.indexOf(buttonChar) != -1) {
                    button.setEnabled(true);
                } else if (disabledChars.indexOf(buttonChar) != -1) {
                    button.setEnabled(false);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == binaryRadio) {
            enableButtonsForBinary();
            button5.setEnabled(true);
            button7.setEnabled(true);
            button8.setEnabled(true);
            button9.setEnabled(true);
        } else if (source == decimalRadio) {
            enableButtonsForDecimal();
            button5.setEnabled(true);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
        } else if (source == hexadecimalRadio) {
            enableAllButtons();
        } else if (source instanceof JButton) {
            JButton clickedButton = (JButton) source;
            String buttonText = clickedButton.getText();

            if ((buttonText.charAt(0) >= '0' && buttonText.charAt(0) <= '9')) {
                if (!s1.equals(""))
                    s2 = s2 + buttonText;
                else
                    s0 = s0 + buttonText;

                text1.setText(s0 + s1 + s2);
            } else if (buttonText.charAt(0) == 'C') {
                s0 = s1 = s2 = "";
                text1.setText(s0 + s1 + s2);
            } else {
                if (s1.equals("") || s2.equals(""))
                    s1 = buttonText;
                else {
                    if (decimalRadio.isSelected()) {
                        int result;
                        if (s1.equals("+"))
                            result = Integer.parseInt(s0) + Integer.parseInt(s2);
                        else if (s1.equals("-"))
                            result = Integer.parseInt(s0) - Integer.parseInt(s2);
                        else if (s1.equals("/"))
                            result = Integer.parseInt(s0) / Integer.parseInt(s2);
                        else
                            result = Integer.parseInt(s0) * Integer.parseInt(s2);

                        s0 = Integer.toString(result);
                        s1 = buttonText;
                        s2 = "";
                    } else if (binaryRadio.isSelected()) {
                        String binaryNum1 = Integer.toBinaryString(Integer.parseInt(s0, 2));
                        String binaryNum2 = Integer.toBinaryString(Integer.parseInt(s2, 2));

                        String binaryResult = "";
                        if (s1.equals("+")) {
                            binaryResult = Integer.toBinaryString(Integer.parseInt(binaryNum1, 2) + Integer.parseInt(binaryNum2, 2));
                        } else if (s1.equals("-")) {
                            binaryResult = Integer.toBinaryString(Integer.parseInt(binaryNum1, 2) - Integer.parseInt(binaryNum2, 2));
                        } else if (s1.equals("*")) {
                            binaryResult = Integer.toBinaryString(Integer.parseInt(binaryNum1, 2) * Integer.parseInt(binaryNum2, 2));
                        } else if (s1.equals("/")) {
                            binaryResult = Integer.toBinaryString(Integer.parseInt(binaryNum1, 2) / Integer.parseInt(binaryNum2, 2));
                        } 

                        text1.setText(binaryNum1 + s1 + binaryNum2 + "=" + binaryResult);
                        s0 = binaryResult;
                        s1 = s2 = "";
                    }
                    
                }
            }

            text1.setText(s0 + s1 + s2);
        }
    }

    public static void main(String[] args) {
        new new2();
    }
}
