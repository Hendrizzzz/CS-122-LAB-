package CS122Exercises;

import java.util.Scanner;

public class BAGEOPrelimExercise2 {
    public static void main(String[] args) {
        // (1) Declaration and Instantiation of a Scanner Object
        Scanner scanner = new Scanner(System.in);

        // (2) Declaration of operands
        double operand1;
        double operand2;

        // (3) Declaration and Initialization of the result container when the operator is applied to operand1 and operand2
        double runningResult = 0;

        // (4) Declaration and Initialization of arithmetic operator that will be entered.
        char operator = 'j';


        System.out.print("Enter a number: ");
        operand1 = readNumber(scanner);
        boolean firstOperatorIsValid = true;

        while(operator != '='){ // (5) The loop continues as long as the operator is not the equal sign (=)
            operator = readOperator(scanner);
            if (firstOperatorIsValid && operator == '='){
                System.out.println("= cannot be the first operator.");
                operator = 'x';
                continue;
            }
            firstOperatorIsValid = false;
            switch (operator) {
                case '+' -> { // (6) For case addition (+)
                    System.out.print("Enter a number: ");
                    operand2 = readNumber2(scanner);
                    runningResult = add(operand1, operand2);
                    System.out.println("Running Result: " + runningResult);
                    operand1 = runningResult;
                }
                case '-' -> { // (7) For case subtraction (-)
                    System.out.print("Enter a number: ");
                    operand2 = readNumber2(scanner);
                    runningResult = subtract(operand1, operand2);
                    System.out.println("Running Result: " + runningResult);
                    operand1 = runningResult;
                }
                case '*' -> { // (8) For case multiplication (*)
                    System.out.print("Enter a number: ");
                    operand2 = readNumber2(scanner);
                    runningResult = multiply(operand1, operand2);
                    System.out.println("Running Result: " + runningResult);
                    operand1 = runningResult;
                }
                case '/' -> { // (9) For case division (/)
                    System.out.print("Enter a number: ");
                    operand2 = readNumber2(scanner);
                    runningResult = divide(operand1, operand2);
                    System.out.println("Running Result: " + runningResult);
                    operand1 = runningResult;
                }
                case '=' ->
                    System.out.println("Final Result: " + runningResult);
            } // end of switch
        } // end of the while loop
    } // end of the main method





    /**
     The following method returns the sum of two given numbers
     Input: two numbers n1 and n2
     Output : sum of n1 and n2
     */
    private static double add(double n1, double n2){
        return n1+n2;
    }


    /**
     The following method returns the difference of two given numbers
     Input: two numbers n1 and n2
     Output : difference of n1 and n2
     */
    private static double subtract(double n1, double n2){
        return n1-n2;
    }


    /**
     The following method returns the product of two given numbers
     Input: two numbers n1 and n2
     Output : product of n1 and n2
     */
    private static double multiply (double n1, double n2){
        return n1*n2;
    }


    /**
     The following method returns the quotient of two given numbers
     Input: two numbers n1 and n2
     Output : quotient of n1 and n2
     */
    private static double divide(double n1, double n2){
        return n1/n2;
    }





    /**
     The following method returns a character read from the keyboard
     Algorithm
     1. Let operator represent a character (variable of type char)
     2. do
        2.1 Read a string
        2.3. Extract the first character of the string read and assign it to operator
        2.4. if operator is not any of + , - , * , / or = , print a message
      While the value of operator is not any of + , - , / , * or =
     3. Return the operator.
     */
    private static char readOperator(Scanner scan){
        char operator;
        do {
            System.out.print("Enter an operator: ");

            operator = scan.nextLine().charAt(0);
            if (operator!='+'&&operator!='-'&&operator!='*'&&operator!='/'&&operator!='='){
                System.out.println("You must enter +, -, *, / or =");
            }
        } while (operator!='+'&&operator!='-'&&operator!='*'&&operator!='/'&&operator!='=');
        return operator;
    } // end of readOperator method





    /**
     The following method returns a number read from the keyboard
     Algorithm:
     1. Let valueRead represent a double (variable of type double)
     2. Let repeatProcess be a boolean variable initialized to false
     3. do
        3.1. Try to read a String from the input device.
        3.2. Convert the String read into a number and assign false to repeatProcess
        3.3. If the String read cannot be converted into a number,
            catch the exception and let the process
            repeat from step 1 (set repeatProcess to true)
            after giving a message to the user saying the user
            has to enter a number
        3.4. If the String is converted into a number, assign the
            number to valueRead
     while the entered string is not convertible into a number.
     4. return valueRead.
     */
    private static double readNumber(Scanner scan){
        double valueRead=0.0;
        boolean repeatProcess = false;
        do {
            try {
                String entry = scan.nextLine();
                valueRead = Double.parseDouble(entry);
                repeatProcess = false;
            } catch (Exception x){
                repeatProcess = true;
                System.out.print("The input is not a number. Please enter a number. ");
            }
        } while (repeatProcess);
        return valueRead;
    } // end readNumber method





    /**
     The following method returns a number read from the keyboard
     Algorithm:
     1. Let valueRead represent a double(variable of type double)
     2. Let repeatProcess be a boolean variable initialized to true
     3. while repeatProcess is true
        3.1. Try to read a String from the input device.
        3.2. Convert the String read into a number
        3.3. If the String read cannot be converted into a number,
            catch the exception and let the process repeat from step 1
            (let repeatProcess=true) after giving a message to the user
            saying the user has to enter a number
        3.4. If the String is converted into a number, assign the number to valueRead
     4. return valueRead.
     */
    private static double readNumber2(Scanner scan){
        double valueRead=0.0;
        boolean repeatProcess = true;
        while (repeatProcess) {
            try {
                String entry = scan.nextLine();
                valueRead = Double.parseDouble(entry);
                repeatProcess = false;
            } catch (Exception x){
                repeatProcess = true;
                System.out.print("The input is not a number. Please enter a number. ");
            }
        }
        return valueRead;
    } // end readNumber2 method
} // end of the class
