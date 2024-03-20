/**
 Name of programmer: Bag-eo, Jim Hendrix T.
 Class Code and Schedule: 9322A/B CS 122/122L MTH/TF
 Date: March 16, 2024
 */




//5. Include the NumberConverterBoard class in the package called prog2.samcis
package prog2.samcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NumberConverterBoard extends JFrame{
    private JPanel numberPanel;
    private JPanel buttonPanel;
    private JButton convertButton, clearButton, exitButton;
    private JTextField binaryTF, decimalTF, octalTF, hexadecimalTF;
    private EquivalentNumbers number;
    private JLabel problemDisplayer;
    private JPanel reminderPanel;
    private ButtonsHandler buttonsHandler;
    private JPanel headPanel;
    public static void main(String[] args){
        new NumberConverterBoard();
    }

    public NumberConverterBoard(){
        setTitle("Number Converter");
        setSize(800,400);
        headPanel = new JPanel();
        JLabel textArea = new JLabel();
        textArea.setText("This application helps you convert a decimal number to binary, octal and hexadecimal. Please enter the decimal number in the field provided. Then, press the convert key.");
        headPanel.add(textArea);
        numberPanel = new JPanel();
        setNumberPanel(numberPanel);
        buttonPanel = new JPanel();
        setButtonPanel(buttonPanel);
        reminderPanel = new JPanel();
        problemDisplayer = new JLabel("");
        problemDisplayer.setFont(new Font("Arial", Font.ITALIC, 20));
        reminderPanel.add(problemDisplayer);
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,1));
        pane.add(headPanel);
        pane.add(numberPanel);
        pane.add(reminderPanel);
        pane.add(buttonPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        // Disabling the
        binaryTF.setEnabled(false);
        binaryTF.setDisabledTextColor(Color.BLACK);

        octalTF.setEnabled(false);
        octalTF.setDisabledTextColor(Color.black);

        hexadecimalTF.setEnabled(false);
        hexadecimalTF.setDisabledTextColor(Color.BLACK);
    }
    public void setButtonPanel(JPanel panel){
        convertButton = new JButton("convert");
        clearButton = new JButton("clear");
        exitButton = new JButton("exit");
        buttonsHandler = new ButtonsHandler();
        convertButton.addActionListener(buttonsHandler);
        clearButton.addActionListener(buttonsHandler);
        exitButton.addActionListener(buttonsHandler);
        panel.add(convertButton);
        panel.add(clearButton);
        panel.add(exitButton);
    }
    public void setNumberPanel(JPanel panel){
        JLabel decimalLabel = new JLabel("<html><div style='text-align: left; width: 200px;'>Decimal Number:</div></html>", SwingConstants.CENTER); // make it to the right
        decimalLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel binaryLabel = new JLabel("<html><div style='text-align: left; width: 200px;'>Binary Number:</div></html>", SwingConstants.CENTER);
        binaryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel octalLabel = new JLabel("<html><div style='text-align: left; width: 200px;'>Octal Number:</div></html>", SwingConstants.CENTER);
        octalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel hexadecimalLabel = new JLabel("<html><div style='text-align: left; width: 200px;'>Hexadecimal Number:</div></html>", SwingConstants.CENTER);
        hexadecimalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        decimalTF = new JTextField(20);
        decimalTF.setFont(new Font("Arial",Font.BOLD,20));
        binaryTF = new JTextField(20);
        binaryTF.setFont(new Font("Arial",Font.BOLD,20));
        octalTF = new JTextField(20);
        octalTF.setFont(new Font("Arial",Font.BOLD,20));
        hexadecimalTF = new JTextField(20);
        hexadecimalTF.setFont(new Font("Arial",Font.BOLD,20));
        panel.setLayout(new GridLayout(5,4));
        panel.add(decimalLabel);
        panel.add(decimalTF);
        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(binaryLabel);
        panel.add(binaryTF);
        panel.add(octalLabel);
        panel.add(octalTF);
        panel.add(hexadecimalLabel);
        panel.add(hexadecimalTF);
    }

    private class ButtonsHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == exitButton)
                System.exit(0);
            if (e.getSource()== clearButton){
                decimalTF.setText("");
                binaryTF.setText("");
                octalTF.setText("");
                hexadecimalTF.setText("");
                problemDisplayer.setText("");
            }
            if (e.getSource()== convertButton)
                try{
                    if (decimalTF.getText().isEmpty()){
                        throw new Exception("No specified decimal number.");
                    }

                    problemDisplayer.setText("");
                    number = new EquivalentNumbers();

                    if (decimalTF.getText().matches("\\d+")) { // if it is a whole number
                        number.setDecimalNumber(Integer.parseInt(decimalTF.getText()));
                    } else {
                        number.setFloatingDecimalNumber(Double.parseDouble(decimalTF.getText()));
                    }

                    binaryTF.setText(number.getBinaryString());
                    octalTF.setText(number.getOctalString());
                    hexadecimalTF.setText(number.getHexadecimalString());
                } catch (NumberFormatException x ){
                    problemDisplayer.setText("One of the numbers does not follow the format of a number.");
                } catch (Exception e2){
                    problemDisplayer.setText(e2.getMessage());
                }
        }
    }
}