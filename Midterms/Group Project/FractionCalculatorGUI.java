package edu.slu.prog2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractionCalculatorGUI extends JFrame {
    /*
     The structure the JFrame consists of 5 JPanels (horizontally down).

     1st Panel: titlePanel
     The title with the program description

     2nd Panel: functionButtonPanel
     The 2 buttons below the program description, reduce and calculator

     3rd Panel: calculatorPanel
     This consists of 2 panels, the panel for reduce and the panel for arithmetic operation.
     If the reduce button is clicked, then the reduce panel will show. If the calculator button is clicked, then
     the calculator panel will show. This is done with the use of CardLayout.

     4th Panel: resultPanel
     This consists of two panels, the panel where the result will show and the error message panel

     5th Panel: buttonPanel
     This is where the 3 buttons are placed, clear, calculate, and exit.

     */

    private JPanel titlePanel;
    private JPanel functionButtonPanel;
    private JPanel calculatorPanel;
    private JPanel resultPanel;
    private JPanel buttonPanel;

    JTextField whole, whole1, whole2, numerator, numerator1, numerator2, denominator, denominator1, denominator2;
    JTextField resultTF;
    JLabel errorMessage;

    private final JButton reduceButton = new JButton("Reduce");
    private final JButton calculatorButton = new JButton("Calculator");
    final JButton clearButton = new JButton("clear");
    final JButton calculateButton = new JButton("calculate");
    final JButton exitButton = new JButton("exit");

    JComboBox<String> operation;

    static boolean isReducePanelShowing = false;

    JPanel cardPanel;
    CardLayout cardLayout;

    private static final Font font = new Font("Arial", Font.PLAIN, 20);


    public FractionCalculatorGUI() {
        setTitle("Bag-eoMalasanMartinPajaraSambotYu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        setTitlePanel();
        setFunctionPanel();
        setCalculatorPanel();
        setResultPanel();
        setButtonsPanel();

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        getContentPane().add(titlePanel);
        getContentPane().add(functionButtonPanel);
        getContentPane().add(calculatorPanel);
        getContentPane().add(resultPanel);
        getContentPane().add(buttonPanel);

        setVisible(true);
    }

    private void setFunctionPanel() {
        functionButtonPanel = new JPanel();
        ButtonHandler buttonHandler = new ButtonHandler();

        calculatorButton.addActionListener(buttonHandler);
        reduceButton.addActionListener(buttonHandler);

        functionButtonPanel.add(reduceButton);
        functionButtonPanel.add(calculatorButton);
    }

    private void setTitlePanel() {
        titlePanel = new JPanel();
        JLabel titleName = new JLabel("Mixed Fraction Calculator");
        titleName.setVerticalAlignment(JLabel.TOP);
        titleName.setHorizontalAlignment(JLabel.CENTER);
        titleName.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel description = new JLabel("With this calculator, you can reduce and perform arithmetic operations on fractions, mixed fractions or both.");
        description.setVerticalAlignment(JLabel.TOP);
        description.setHorizontalAlignment(JLabel.CENTER);
        description.setFont(new Font("Arial", Font.BOLD, 15));

        titlePanel.setLayout(new GridLayout(2,1));
        titlePanel.add(titleName);
        titlePanel.add(description);
    }



    private void setCalculatorPanel() {
        // Create card panel and set CardLayout
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        JPanel reducePanel = new JPanel();
        setReducePanel(reducePanel);
        JPanel calculatorP = new JPanel();
        setCalculatorP(calculatorP);

        // Add panels to a card panel with unique names
        cardPanel.add(calculatorP, "panel2");
        cardPanel.add(reducePanel, "panel1");

        calculatorPanel = new JPanel();
        calculatorPanel.add(cardPanel);
    }


    private void setCalculatorP(JPanel calculatorP) {
        whole1 = new JTextField();
        whole1.setHorizontalAlignment(0);
        whole1.setPreferredSize(new Dimension(70, 40));
        whole1.setFont(font);

        numerator1 = new JTextField();
        numerator1.setHorizontalAlignment(0);
        numerator1.setPreferredSize(new Dimension(70, 40));
        numerator1.setFont(font);

        JLabel lineLabel = new JLabel("━━━━━━━━━━━━");

        denominator1 = new JTextField();
        denominator1.setPreferredSize(new Dimension(70, 40));
        denominator1.setHorizontalAlignment(0);
        denominator1.setFont(font);

        JPanel fraction = new JPanel(new GridLayout(3,1));

        // Add components to the panel
        fraction.add(numerator1);
        fraction.add(lineLabel);
        fraction.add(denominator1);

        JComboBox<String> operation = getStringJComboBox();

        whole2 = new JTextField();
        whole2.setHorizontalAlignment(0);
        whole2.setPreferredSize(new Dimension(70, 40));
        whole2.setFont(font);

        numerator2 = new JTextField();
        numerator2.setHorizontalAlignment(0);
        numerator2.setPreferredSize(new Dimension(70, 40));
        numerator2.setFont(font);

        JLabel lineLabel1 = new JLabel("━━━━━━━━━━━━");

        denominator2 = new JTextField();
        denominator2.setPreferredSize(new Dimension(70, 40));
        denominator2.setHorizontalAlignment(0);
        denominator2.setFont(font);

        JPanel fraction1 = new JPanel(new GridLayout(3,1));

        // Add components to the panel
        fraction1.add(numerator2);
        fraction1.add(lineLabel1);
        fraction1.add(denominator2);

        calculatorP.setLayout(new FlowLayout());
        calculatorP.add(whole1);
        calculatorP.add(fraction);
        calculatorP.add(new JLabel("   ")); // for spacing
        calculatorP.add(operation);
        calculatorP.add(new JLabel("   ")); // for spacing
        calculatorP.add(whole2);
        calculatorP.add(fraction1);
    }

    private JComboBox<String> getStringJComboBox() {
        String[] items = {"+", "-", "x", "÷"};
        operation = new JComboBox<>(items);
        // Set custom renderer to center the text
        operation.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setHorizontalAlignment(SwingConstants.CENTER); // Center the text
                return this;
            }
        });
        operation.setPreferredSize(new Dimension(70, 40));
        operation.setFont(font);
        return operation;
    }

    private void setReducePanel(JPanel reducePanel) {
        whole = new JTextField();
        whole.setHorizontalAlignment(0);
        whole.setPreferredSize(new Dimension(70, 40));
        whole.setFont(font);

        numerator = new JTextField();
        numerator.setHorizontalAlignment(0);
        numerator.setPreferredSize(new Dimension(70, 40));
        numerator.setFont(font);

        JLabel lineLabel = new JLabel("━━━━━━━━━━━━");

        denominator = new JTextField();
        denominator.setPreferredSize(new Dimension(70, 40));
        denominator.setHorizontalAlignment(0);
        denominator.setFont(font);

        JPanel fraction = new JPanel(new GridLayout(3,1));


        // Add components to the panel
        fraction.add(numerator);
        fraction.add(lineLabel);
        fraction.add(denominator);

        reducePanel.add(whole);
        reducePanel.add(fraction);
    }


    private void setResultPanel() {
        resultPanel = new JPanel(new GridLayout(2,1));

        JPanel resultContainer = new JPanel();
        errorMessage = new JLabel("", SwingConstants.CENTER);
        errorMessage.setForeground(Color.RED);
        resultTF = new JTextField("");
        resultTF.setHorizontalAlignment(JTextField.CENTER);
        resultTF.setPreferredSize(new Dimension(250, 40));
        JLabel resultText = new JLabel("Result: ");
        resultContainer.add(resultText);
        resultContainer.add(resultTF);
        resultPanel.add(resultContainer);
        resultPanel.add(errorMessage);
        resultTF.setFont(font);
    }

    private void setButtonsPanel() {
        buttonPanel = new JPanel();
        ButtonHandler buttonHandler = new ButtonHandler();

        clearButton.addActionListener(buttonHandler);
        calculateButton.addActionListener(buttonHandler);
        exitButton.addActionListener(buttonHandler);

        buttonPanel.add(clearButton);
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);
    }

    public static void main(String[] args) {
        new FractionCalculatorGUI();
    }



    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object choice = e.getSource();

            if (choice == exitButton){
                System.exit(0);
            }
            else if (choice == clearButton){
                if (isReducePanelShowing){
                    whole.setText("");
                    numerator.setText("");
                    denominator.setText("");
                } else {
                    whole1.setText("");
                    numerator1.setText("");
                    denominator1.setText("");
                    whole2.setText("");
                    numerator2.setText("");
                    denominator2.setText("");
                }
                errorMessage.setText("");
            }
            else if (choice == calculateButton){
                errorMessage.setText("");
                if (isReducePanelShowing){
                    reduce();
                } else {
                    performArithmetic();
                }
            } else if (choice == reduceButton){
                resultTF.setText("");
                errorMessage.setText("");
                cardLayout.show(cardPanel, "panel1");
                isReducePanelShowing = true;
            } else if (choice == calculatorButton){
                resultTF.setText("");
                errorMessage.setText("");
                cardLayout.show(cardPanel, "panel2");
                isReducePanelShowing = false;
            }
        }

        private void reduce() {
            if (numerator.getText().isEmpty() || denominator.getText().isEmpty())
            {
                errorMessage.setText("Some values are still missing");
                return;
            }
            int wholeR = 0;
            int numeratorR, denominatorR;

            try{
                if (!whole.getText().isEmpty()){ // if the whole is not empty, else let it be 0
                    wholeR = Integer.parseInt(whole.getText());
                }
                numeratorR = Integer.parseInt(numerator.getText());
                denominatorR = Integer.parseInt(denominator.getText());
            } catch (NumberFormatException e){
                errorMessage.setText("Some values are not valid. ");
                return;
            }

            MixedFraction fraction;
            try {
                fraction = new MixedFraction(wholeR, numeratorR, denominatorR);
            } catch (ArithmeticException e){
                errorMessage.setText("Denominator cannot be 0");
                resultTF.setText("");
                return;
            }
            fraction.simplify();
            resultTF.setText(fraction.toString());
        }

        private void performArithmetic() {
            String operationChoice = (String) operation.getSelectedItem();
            if (numerator1.getText().isEmpty() || denominator1.getText().isEmpty() ||
                numerator2.getText().isEmpty() || denominator2.getText().isEmpty())
            {
                errorMessage.setText("Some values are still missing");
                return;
            }
            int firstWhole = 0, secondWhole = 0;
            int firstNumerator, secondNumerator, firstDenominator, secondDenominator;

            try{
                if (!whole1.getText().isEmpty()){ // if the whole is not empty, else let it be 0
                    firstWhole = Integer.parseInt(whole1.getText());
                }
                if (!whole2.getText().isEmpty()){
                    secondWhole = Integer.parseInt(whole2.getText());
                }
                firstNumerator = Integer.parseInt(numerator1.getText());
                secondNumerator = Integer.parseInt(numerator2.getText());
                firstDenominator = Integer.parseInt(denominator1.getText());
                secondDenominator = Integer.parseInt(denominator2.getText());
            } catch (NumberFormatException e){
                errorMessage.setText("Some values are not valid. ");
                return;
            }

            MixedFraction first;
            MixedFraction second;
            try {
                first = new MixedFraction(firstWhole, firstNumerator, firstDenominator);
                second = new MixedFraction(secondWhole, secondNumerator, secondDenominator);
            } catch (ArithmeticException e){
                errorMessage.setText("Denominator cannot be 0");
                resultTF.setText("");
                return;
            }

            try {
                switch (operationChoice) {
                    case "+" -> resultTF.setText(first.add(second).toString());
                    case "-" -> resultTF.setText(first.subtract(second).toString());
                    case "x" -> resultTF.setText(first.multiplyBy(second).toString());
                    case "÷" -> resultTF.setText(first.divideBy(second).toString());
                }
            } catch (ArithmeticException e){
                errorMessage.setText("The divisor cannot be 0");
                resultTF.setText("");
            }
        }
    }
}
