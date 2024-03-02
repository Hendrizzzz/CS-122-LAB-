package prog2.prelim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FractionArithmetic {
    private static final BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    private static final String INVALID_INPUT = "Invalid input. Please enter an integer. Try again. ";


    public static void main(String[] args) {
        FractionArithmetic fractionArithmetic;
        try{
            fractionArithmetic = new FractionArithmetic();
            fractionArithmetic.run();
        } catch (IOException e){
            System.out.println("An error occurred while reading the input: " + e.getMessage());
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
                System.out.println("Thank you for using the program! ");
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
        Fraction firstFraction = setUpFirstFraction();
        // Set up the second fraction
        Fraction secondFraction = setUpSecondFraction();

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
        while (true){
            try{
                // Display the menu
                displayMenu();

                // Ask and read the input
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(read.readLine());

                // Check if the choice is in the menu, if not, display error message and loop again
                if(choice > 6 || choice < 1){
                    System.out.println("Choice not found. Try again. ");
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
        System.out.print("""
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
                        """);
    } // end of method -> displayMenu



    // Set up a fraction by prompting the user for numerator and denominator
    private Fraction setUpFraction(String fractionName) throws IOException {
        Fraction fraction = new Fraction();
        System.out.println("--------------------------------");
        System.out.println("Setting up " + fractionName + " Fraction...");
        setUpNumerator("Enter Numerator of " + fractionName + " Fraction: ", fraction);
        setUpDenominator("Enter Denominator of " + fractionName + " Fraction: ", fraction);
        return fraction;
    }

    // Set up the first fraction
    private Fraction setUpFirstFraction() throws IOException {
        return setUpFraction("First");
    }

    // Set up the second fraction
    private Fraction setUpSecondFraction() throws IOException {
        return setUpFraction("Second");
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
            System.out.println("Denominator cannot be zero. Try again. ");
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
        System.out.println("Result of " + term + " fractions:");
        System.out.println("╔═════════════════════════╗");
        System.out.printf("%-6s%9s%12s%n","║", firstFraction.toString(), "║");
        System.out.println("║          " + operation + "              ║");
        System.out.printf("%-6s%9s%12s%n","║", secondFraction.toString(), "║");
        System.out.println("║═════════════════════════║");
        if(result.toString().contains("/")) {
            System.out.printf("%2s%9s%4s%.4f%n", " =", result, " or ", result.toDouble());
        } else {
            System.out.printf("%3s%12s%n", "= ", result);
        }
        System.out.println("╚═════════════════════════╝\n\n");
    }

    // Display result for reducing fraction operation
    private void displayResult(Fraction fraction, Fraction resultingFraction) {
        System.out.println("The simplest form of " + fraction.toString() + " is " + resultingFraction.toString());
    }

} // end of the class
