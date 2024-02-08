package CS122Exercises.OperationsOnFractions.Version2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    /**
     * Represents an instance of the FractionOperations class used for performing operations on fractions.
     * It provides methods for addition, subtraction, multiplication, and division of fractions.
     */
    private static final FractionOperations operate = new FractionOperations();

    /**
     * Represents a BufferedReader object used for reading input from the standard input stream (System.in).
     * It is used to read user input for the fractions and operation choices in the program.
     */
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    /**
     * Represents the number of attempts made to perform a certain operation.
     * This variable is used to control the maximum number of attempts allowed.
     */
    private static int attempts = 0;

    /**
     * Represents the maximum number of attempts allowed for a certain operation.
     * If the maximum number of attempts is reached, the operation may terminate
     * or take appropriate action as defined by the program logic.
     */
    private static final int MAX_ATTEMPTS = 3;


    /**
     * Enumeration representing various arithmetic operations.
     */
    enum Operations {
        /**
         * Represents addition operation.
         */
        ADDITION,

        /**
         * Represents subtraction operation.
         */
        SUBTRACTION,

        /**
         * Represents multiplication operation.
         */
        MULTIPLICATION,

        /**
         * Represents division operation.
         */
        DIVISION,

        /**
         * Represents exit operation.
         */
        EXIT
    }


    /**
     * The main method of the program, responsible for initiating the program execution.
     * It creates an instance of the Main class, calls the run method to start the program, and catches any exceptions that occur during execution.
     * If an exception occurs, it prints the stack trace to the standard error stream.
     */
    public static void main(String[] args) {
        Main main;
        try {
            main = new Main();
            main.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * The run method controls the main execution flow of the program.
     * It displays a menu to the user and performs operations based on the user's choice until the user chooses to exit.
     * It utilizes various helper methods to perform arithmetic operations on fractions.
     * After the user chooses to exit, it terminates the program.
     */
    private void run() {
        boolean exit = false;
        do {
            int choice = displayMenu();
            switch (choice) {
                case 1 -> addTwoFractions();
                case 2 -> subtractTwoFractions();
                case 3 -> multiplyTwoFractions();
                case 4 -> divideTwoFractions();
                case 5 -> {
                    System.out.println("Thank you for using the program! ");
                    exit = true;
                }
            }
        } while (!exit);

        // End the program
        System.exit(0);
    }


    /**
     * Adds two fractions and displays the result to the user.
     */
    private void addTwoFractions() {
        // Create two fractions
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        // Set up the fractions
        setUpTheTwoFractions(fraction1, fraction2);

        // Perform addition and display the result
        Fraction sum = operate.add(fraction1, fraction2);
        System.out.print("The sum of " + fraction1 + " and " + fraction2 + " is " + sum.toString());

        // If the quotient is not a whole number, then display the quotient to its decimal form
        if (sum.toString().contains("/")) System.out.print(" or " + sum.toDecimal());
        System.out.println("\n");
    }





    /**
     * Subtracts two fractions and displays the result to the user.
     */
    private void subtractTwoFractions() {
        // Create two fractions
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        // Set up the fractions
        setUpTheTwoFractions(fraction1, fraction2);

        // Perform subtraction and display the result
        Fraction difference = operate.subtract(fraction1, fraction2);
        System.out.print("The difference of " + fraction1 + " and " + fraction2 + " is " + difference.toString());

        // If the quotient is not a whole number, then display the quotient to its decimal form
        if (difference.toString().contains("/")) System.out.print(" or " + fraction1.toDecimal());
        System.out.println("\n"); // Formatting purposes
    }


    /**
     * Multiplies two fractions and displays the result to the user.
     */
    private void multiplyTwoFractions() {
        // Create two fractions
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        // Set up the fractions
        setUpTheTwoFractions(fraction1, fraction2);

        // Perform multiplication and display the result
        Fraction product = operate.multiply(fraction1, fraction2);
        System.out.print("The product of " + fraction1 + " and " + fraction2 + " is " + product.toString());

        // If the quotient is not a whole number, then display the quotient to its decimal form
        if (product.toString().contains("/")) System.out.print(" or " + product.toDecimal());
        System.out.println("\n"); // Formatting purposes
    }


    /**
     * Divides two fractions and displays the result to the user.
     */
    private void divideTwoFractions() {
        // Create two fractions
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        // Set up the fractions
        setUpTheTwoFractions(fraction1, fraction2);

        // Perform division and display the result
        Fraction quotient = operate.divide(fraction1, fraction2);
        System.out.print("The quotient of " + fraction1 + " and " + fraction2 + " is " + quotient.toString());

        // If the quotient is not a whole number, then display the quotient to its decimal form
        if (quotient.toString().contains("/")) System.out.print(" or " + quotient.toDecimal());
        System.out.println("\n"); // Formatting purposes
    }




    /**
     * Sets up two fractions by repeatedly prompting the user for input until valid fractions are provided.
     * A helper method is used here. (setUpFraction)
     * Catches an IOException.
     * If the maximum number of attempts is reached while reading input, an error message is displayed.
     *
     * @param fraction1 The first fraction object to set up.
     * @param fraction2 The second fraction object to set up.
     */
    private void setUpTheTwoFractions(Fraction fraction1, Fraction fraction2) {
        do {
            try {
                // Get a valid first fraction
                setUpFraction(fraction1, "Enter the first fraction: ");

                // Get a valid second fraction
                setUpFraction(fraction2, "Enter the second fraction: ");
                return;

            } catch (IOException e) {
                // Handle input/output exception
                System.out.println("An error occurred while reading the input. Please try again. \n");
                attempts++;
                if (attempts >= MAX_ATTEMPTS) {
                    // Maximum attempts reached
                    System.out.println("Max attempts reached. Exiting the loop. \n");
                    break;
                }
            }
        } while (true);
    } // End of the method -> setUpTheTwoFractions


    /**
     * A helper method of the setUpTheTwoFractions.
     * Sets up a fraction object by reading input from the user and parsing it to set the numerator and denominator.
     * The method prompts the user with the specified message and continues to prompt until a valid fraction is provided.
     * If the denominator is zero or an invalid fraction format is entered, the user is informed and prompted to try again.
     *
     * @param fraction1 The fraction object to set up.
     * @param message   The message to display as a prompt for the user.
     * @throws IOException If an I/O error occurs while reading input from the user.
     */
    private void setUpFraction(Fraction fraction1, String message) throws IOException {
        do {
            try {
                System.out.print(message);
                String[] fraction = bufferedReader.readLine().trim().split("/");
                if (fraction.length != 2) {
                    throw new NumberFormatException(); // Invalid fraction format
                }
                if (fraction[1].equals("0") || fraction[1].equals("-0")) {
                    System.out.println("Invalid input. Denominator cannot be zero. Please try again.");
                    continue;
                }
                fraction1.setNumerator(Integer.parseInt(fraction[0]));
                fraction1.setDenominator(Integer.parseInt(fraction[1]));
                return;
            } catch (NumberFormatException e) {
                // Handle invalid input format
                System.out.println("Invalid input. Please enter a valid fraction (e.g., 1/2) without any spaces. Try again.");
            }
        } while (true);
    } // End of the method -> setUpFraction



    /**
     * Displays a menu of arithmetic operations on two fractions and prompts the user to choose an operation.
     * The user input is validated to ensure it corresponds to a valid operation choice.
     * If the maximum number of attempts is reached while reading input, an error message is displayed.
     *
     * @return The integer corresponding to the chosen operation.
     */
    private int displayMenu() {
        int operationChoice = 0;
        do {
            try {
                System.out.println("===== Choose an operation on Two Fractions =====");

                // Get the values of the enum, Operations, and store them in an array
                Operations[] operations = Operations.values();

                // Iterate through the array and display each operation
                for (Operations operation : operations) {
                    System.out.println(operation.ordinal() + 1 + ". " + operation);
                }

                operationChoice = Integer.parseInt(bufferedReader.readLine());

                if (operationChoice > 5 || operationChoice < 1) {
                    System.out.println("Choice not found. Please try again. \n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                // Handle invalid input format
                System.out.println("Invalid input. Please enter an integer. Try again. \n");
            } catch (IOException e) {
                // Handle input/output exception
                System.out.println("An error occurred while reading the input. Please try again. \n");
                attempts++;
                if (attempts >= MAX_ATTEMPTS) {
                    // Maximum attempts reached
                    System.out.println("Max attempts reached. Exiting the loop.\n");
                    break;
                }
            } // End of the catch

        } while (true);

        return operationChoice;
    } // End of the displayMenu method

} // End of the class
