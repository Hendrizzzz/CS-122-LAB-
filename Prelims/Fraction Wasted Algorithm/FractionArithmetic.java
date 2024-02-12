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
        boolean exit = false;
        while(!exit){
            int choice = getUserChoice();
            switch (choice) {
                case 1 -> addFractions();
                case 2 -> subtractFractions();
                case 3 -> multiplyFractions();
                case 4 -> divideFractions();
                case 5 -> reduceFraction();
                case 6 -> {
                    System.out.println("Thank you for using the program! ");
                    exit = true;
                }
            }
        }
    }



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
        System.out.println("""
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




    private void addFractions() throws IOException {
        // First Fraction
        Fraction firstFraction = setUpFirstFraction();

        // Second Fraction
        Fraction secondFraction = setUpSecondFraction();

        // Add the two fractions
        Fraction sum = firstFraction.add(secondFraction);

        // Display the result
        displayResult(firstFraction, secondFraction, sum);
    }



    private void subtractFractions() throws IOException {
        // First Fraction
        Fraction firstFraction = setUpFirstFraction();

        // Second Fraction
        Fraction secondFraction = setUpSecondFraction()

        // Add the two fractions
        Fraction difference = firstFraction.subtract(secondFraction);

        // Display the result
        displayResult(firstFraction, secondFraction, difference);
    }

    private void multiplyFractions() throws IOException {
        // First Fraction
        Fraction firstFraction = setUpFirstFraction();

        // Second Fraction
        Fraction secondFraction = setUpSecondFraction();

        // Add the two fractions
        Fraction product = firstFraction.multiplyBy(secondFraction);

        // Display the result
        displayResult(firstFraction, secondFraction, product);
    }

    private void divideFractions() throws IOException {
        // First Fraction
        Fraction firstFraction = setUpFirstFraction();

        // Second Fraction
        Fraction secondFraction = setUpSecondFraction();

        // Add the two fractions
        Fraction quotient = firstFraction.add(secondFraction);

        // Display the result
        displayResult(firstFraction, secondFraction, quotient);
    }




    private Fraction setUpFirstFraction() throws IOException {
        Fraction firstFraction = new Fraction();
        setUpNumerator("Enter Numerator of First Fraction: ", firstFraction);
        setUpDenominator("Enter Denominator of First Fraction: ", firstFraction);
        return firstFraction;
    }


    private Fraction setUpSecondFraction() throws IOException {
        Fraction secondFraction = new Fraction();
        setUpNumerator("Enter Numerator of Second Fraction: ", secondFraction);
        setUpDenominator("Enter Denominator of Second Fraction: ", secondFraction);
        return secondFraction;
    }


    private void setUpNumerator(String message, Fraction fraction) throws IOException {
        int numerator = readInteger(message);
        fraction.setNumerator(numerator);
    }

    private void setUpDenominator(String prompt, Fraction fraction) throws IOException {
        int denominator = readInteger(prompt);
        fraction.setDenominator(denominator);
    }


    private void displayResult(Fraction firstFraction, Fraction secondFraction, Fraction sum) {
        // Display the result
        System.out.println("Result of adding fractions:");
        System.out.println("╔═════════╗");
        System.out.println("║ " + firstFraction.toString() + " ║");
        System.out.println("║    +    ║");
        System.out.println("║ " + secondFraction.toString() + " ║");
        System.out.println("║    =    ║");
        System.out.println("║ " + sum.toString() + " ║");
        System.out.println("╚═════════╝");
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


    private void reduceFraction() {

    }
}
