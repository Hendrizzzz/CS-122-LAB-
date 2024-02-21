package CS122Exercises.OperationsOnFractions.Version3;

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
    }


    private void run() throws IOException {
        while(true){
            int choice = getUserChoice();

            // if the user chose 'quit' :<
            if (choice == 6) {
                System.out.println("Thank you for using the program! ");
                break;
            }

            // else, operate
            operate(choice);
        }
    }


    /**
     * Performs arithmetic operations on fractions based on user choice.
     *
     * @param choice The operation to perform: 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division, 5 for a single fraction operation.
     * @throws IOException If an I/O error occurs.
     */
    private void operate(int choice) throws IOException {
        // Perform a single fraction operation -> Reduce Fraction
        if (choice == 5) {
            Fraction fraction = new Fraction();
            setUpNumerator("Enter Numerator: ", fraction);
            setUpDenominator("Enter Denominator: ", fraction);
            Fraction reducedFraction = new Fraction (fraction);
            reducedFraction.reduce();
            displayResult(fraction, reducedFraction);
            return;
        }

        // Set up the first fraction
        Fraction firstFraction = setUpFirstFraction();
        // Set up the second fraction
        Fraction secondFraction = setUpSecondFraction();

        // Perform the arithmetic operation based on the user's choice
        switch (choice){
            case 1 -> displayResult(firstFraction, secondFraction, firstFraction.add(secondFraction), "+", "adding");
            case 2 -> displayResult(firstFraction, secondFraction, firstFraction.subtract(secondFraction), "-", "subtracting");
            case 3 -> displayResult(firstFraction, secondFraction, firstFraction.multiplyBy(secondFraction), "x", "multiplying");
            case 4 -> displayResult(firstFraction, secondFraction, firstFraction.divideBy(secondFraction), "÷", "dividing");
        }
    }


    // prompt user for choice until valid
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


    // helper method of getUserChoice() method
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




    private Fraction setUpFirstFraction() throws IOException {
        Fraction firstFraction = new Fraction();
        System.out.println("--------------------------------");
        System.out.println("Setting up First Fraction...");
        setUpNumerator("Enter Numerator of First Fraction: ", firstFraction);
        setUpDenominator("Enter Denominator of First Fraction: ", firstFraction);
        return firstFraction;
    }


    private Fraction setUpSecondFraction() throws IOException {
        Fraction secondFraction = new Fraction();
        System.out.println("--------------------------------");
        System.out.println("Setting up Second Fraction...");
        setUpNumerator("Enter Numerator of Second Fraction: ", secondFraction);
        setUpDenominator("Enter Denominator of Second Fraction: ", secondFraction);
        return secondFraction;
    }


    private void setUpNumerator(String message, Fraction fraction) throws IOException {
        int numerator = readInteger(message);
        fraction.setNumerator(numerator);
    }

    private void setUpDenominator(String prompt, Fraction fraction) throws IOException {
        do {
            int denominator = readInteger(prompt);
            if (fraction.setDenominator(denominator)) return;
            System.out.println("Denominator cannot be zero. Try again. ");
        } while (true);
    }


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


    // display result with format
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

    // display result for reducing fraction operation
    private void displayResult(Fraction fraction, Fraction resultingFraction) {
        System.out.println("The simplest form of " + fraction.toString() + " is " + resultingFraction.toString());
    }

} // end of the class
