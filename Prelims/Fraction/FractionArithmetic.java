package prog2.prelim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FractionArithmetic {
    private static final BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    // Define ANSI escape codes for text formatting in the terminal
    // These codes are used to display text in different colors and styles
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String PURPLE = "\u001B[34m";
    public static final String BOLD = "\u001B[1m";

    private static final String INVALID_INPUT = RED + BOLD + "Invalid input. Please enter an integer. Try again. " + RESET;
    private static final String INVALID_DENOMINATOR = RED + "Denominator cannot be zero. Try again. " + RESET;


    public static void main(String[] args) {
        FractionArithmetic fractionArithmetic;
        try{
            fractionArithmetic = new FractionArithmetic();
            fractionArithmetic.run();
        } catch (IOException e){
            System.out.println(RED + "An error occurred while reading the input: " + e.getMessage() + RESET);
        }
    } // end of the main method




    /**
     * Runs the fraction arithmetic program.
     *
     * @throws IOException If an I/O error occurs.
     */
    private void run() throws IOException {
        while(true){
            int choice = getUserChoice();

            // if the user chose 'quit' :<
            if (choice == 6) {
                System.out.println(GREEN + "Thank you for using the program! ");
                break;
            }
            // if the user chose to reduce a fraction
            else if (choice == 5){
                Fraction fraction = new Fraction();
                setUpNumerator("Enter Numerator: ", fraction);
                setUpDenominator("Enter Denominator: ", fraction);
                Fraction reducedFraction = new Fraction (fraction);
                reducedFraction.reduce();
                displayResult(fraction, reducedFraction);
            }

            // else, operate
            operate(choice);
        }
    } // end of the run method


    /**
     * Performs arithmetic operations on fractions based on user choice.
     *
     * @param choice The operation to perform: 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division, 5 for a single fraction operation.
     * @throws IOException If an I/O error occurs.
     */
    private void operate(int choice) throws IOException {
        // Set up the first fraction
        Fraction firstFraction = setUpFraction("First");
        // Set up the second fraction
        Fraction secondFraction = setUpFraction("Second");

        // Display the result of the arithmetic operation
        switch (choice){
            case 1 -> displayResult(firstFraction, secondFraction, firstFraction.add(secondFraction), "+", "adding");
            case 2 -> displayResult(firstFraction, secondFraction, firstFraction.subtract(secondFraction), "-", "subtracting");
            case 3 -> displayResult(firstFraction, secondFraction, firstFraction.multiplyBy(secondFraction), "x", "multiplying");
            case 4 -> displayResult(firstFraction, secondFraction, firstFraction.divideBy(secondFraction), "÷", "dividing");
        }
    } // end of method -> operate



    

    /**
     * Prompts the user for their choice until a valid one is entered.
     *
     * @return The user's choice.
     * @throws IOException If an I/O error occurs.
     */
    private int getUserChoice() throws IOException {
        // Display the menu
        displayMenu();
        while (true){
            try{
                // Ask and read the input
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(read.readLine());

                // Check if the choice is in the menu, if not, display error message and loop again
                if(choice > 6 || choice < 1){
                    System.out.println(RED + "Choice not found. Try again. " + RESET);
                    continue;
                }

                // return if choice is valid
                return choice;
            } catch (NumberFormatException e){
                System.out.println(INVALID_INPUT);
            }
        }
    } // end of method -> displayUserChoice()


    // Display the menu of the program
    private void displayMenu() {
        System.out.print(GREEN + BOLD + """
                        
                        +-------------------------------+
                        | What do you want to do?       |
                        |                               |
                        |   <1>. Add fractions          |
                        |   <2>. Subtract fractions     |
                        |   <3>. Multiply fractions     |
                        |   <4>. Divide fractions       |
                        |   <5>. Reduce a fraction      |
                        |   <6>. Quit                   |
                        +-------------------------------+
                        """ + RESET);
    } // end of method -> displayMenu



    // Set up a fraction with a specified prompt
    private Fraction setUpFraction(String prompt) throws IOException {
        Fraction fraction = new Fraction();
        System.out.println(PURPLE + "--------------------------------" + RESET);
        System.out.println(BOLD + "Setting up " + prompt + " Fraction..." + RESET);
        setUpNumerator("Enter Numerator of " + prompt + " Fraction: ", fraction);
        setUpDenominator("Enter Denominator of " + prompt + " Fraction: ", fraction);
        return fraction;
    }
    

    // Set up the numerator for a fraction
    private void setUpNumerator(String message, Fraction fraction) throws IOException {
        int numerator = readInteger(message);
        fraction.setNumerator(numerator);
    }

    // Set up the denominator for a fraction
    private void setUpDenominator(String prompt, Fraction fraction) throws IOException {
        do {
            int denominator = readInteger(prompt);
            if (fraction.setDenominator(denominator)) return;
            System.out.println(INVALID_DENOMINATOR);
        } while (true);
    }


    // Read an integer from the user
    private int readInteger(String prompt) throws IOException {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(read.readLine());
            } catch (NumberFormatException e) {
                System.out.println(INVALID_INPUT);
            }
        }
    }


    // Display the result of fraction arithmetic with format
    private void displayResult(Fraction firstFraction, Fraction secondFraction, Fraction result, String operation, String term) {
        System.out.println(BOLD + "Result of " + term + " fractions:");
        System.out.println("╔═════════════════════════╗");
        System.out.printf("%-6s%9s%12s%n","║", firstFraction.toString(), "║");
        System.out.println("║          " + operation + "              ║");
        System.out.printf("%-6s%9s%12s%n","║", secondFraction.toString(), "║");
        System.out.println("║═════════════════════════║");
        if(result.toString().contains("/")) {
            System.out.printf(GREEN + "%2s%9s%4s%.4f%n", " =", result, " or ", result.toDouble());
        } else {
            System.out.printf(GREEN + "%3s%12s%n", "= ",result);
        }
        System.out.println(RESET + BOLD + "╚═════════════════════════╝\n\n" + RESET);
    }

    // Display result for reducing fraction operation
    private void displayResult(Fraction fraction, Fraction resultingFraction) {
        System.out.println("The simplest form of " + fraction.toString() + " is " + resultingFraction.toString());
    }

} // end of the class
