package CS122Exercises.OperationsOnFractions.Version1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static final FractionOperations operate = new FractionOperations();
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    // both of these are for buffered reader problem purposes
    private static int attempts = 0;
    private static final int MAX_ATTEMPTS = 3;

    enum Operations{
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, EXIT
    }

    public static void main(String[] args) {
        Main main = new Main();
        try{
            main.run();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private void run() {
        boolean exit = false;
        do{
            int choice = displayMenu();
            switch(choice){
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
     * Creates two objects of 'Fraction' for the 2 fractions to operate on
     * Calls the 'setUpTwoFractions' to populate the numerator and denominator of the fractions
     * Then calls the add method of the 'FractionOperation' class through the instance / object of it, 'operate' which was created at the top of the class
     * Then it is place on the third object of 'Fraction' and result message is displayed
     */
    private void addTwoFractions() {
        // I used the default constructor here because I'd like to
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        setUpTheTwoFractions(fraction1, fraction2);

        Fraction sum = operate.add(fraction1, fraction2);
        System.out.print("The sum of " + fraction1 + " and " + fraction2 + " is " + sum.toString());
        if(sum.toString().contains("/")) System.out.print(" or " + sum.toDecimal());
        System.out.println("\n"); // Formatting purposes
    }



    private void subtractTwoFractions() {
        // I used the default constructor here because I'd like to
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        setUpTheTwoFractions(fraction1, fraction2);

        Fraction difference = operate.subtract(fraction1, fraction2);
        System.out.print("The difference of " + fraction1 + " and " + fraction2 + " is " + difference.toString());
        if(difference.toString().contains("/")) System.out.print(" or " + fraction1.toDecimal());
        System.out.println("\n"); // Formatting purposes
    }

    private void multiplyTwoFractions() {
        // I used the default constructor here because I'd like to
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        setUpTheTwoFractions(fraction1, fraction2);

        Fraction product = operate.multiply(fraction1, fraction2);
        System.out.print("The product of " + fraction1 + " and " + fraction2 + " is " + product.toString());
        if(product.toString().contains("/")) System.out.print(" or " + product.toDecimal());
        System.out.println("\n");// Formatting purposes
    }

    private void divideTwoFractions() {
        // I used the default constructor here because I'd like to
        Fraction fraction1 = new Fraction();
        Fraction fraction2 = new Fraction();

        setUpTheTwoFractions(fraction1, fraction2);

        Fraction quotient = operate.divide(fraction1, fraction2);
        System.out.print("The quotient of " + fraction1 + " and " + fraction2 + " is " + quotient.toString());
        if(quotient.toString().contains("/")) System.out.print(" or " + quotient.toDecimal());
        System.out.println("\n"); // Formatting purposes
    }


    private int getNumerator(String fractionPosition){
        int numerator = 0;
        do{
            System.out.print("Enter the Numerator of the " + fractionPosition + " fraction: ");

            try{
                numerator = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter an integer. Try again. \n");
                continue;
            } catch (IOException e) {
                System.out.println("An error occurred while reading the input. Please try again. \n");
                attempts++;
                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("Max attempts reached. Exiting the loop. \n");
                    break;
                }
            } // End of catch

            break;
        } while (true);

        return numerator;
    } // End of the getNumerator Method




    private int getDenominator(String fractionPosition){
        boolean validDenominator = false;
        int numerator = 0;

        do{
            System.out.print("Enter the Denominator of the " + fractionPosition + " fraction: ");

            try{
                numerator = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter an integer. Try again. \n");
                continue;
            } catch (IOException e){
                System.out.println("An error occurred while reading the input. Please try again. \n");
                attempts++;
                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("Max attempts reached. Exiting the loop.\n");
                    break;
                }
            }

            // If denominator is 0, then ask again
            if(numerator == 0){
                System.out.println("Denominator cannot be 0. Please try again. \n");
                continue;
            }

            validDenominator = true;

        } while (!validDenominator);
        return numerator;
    } // End of the getDenominator Method



    private void setUpTheTwoFractions(Fraction fraction1, Fraction fraction2) {
        fraction1.setNumerator(getNumerator("first"));
        fraction1.setDenominator(getDenominator("first"));
        fraction2.setNumerator(getNumerator("second"));
        fraction2.setDenominator(getDenominator("second"));
    } // End of the method



    private int displayMenu() {
        int operationChoice = 0;
        do{
            try{
                System.out.println("===== Choose an operation on Two Fractions =====");

                // Get the values of the enum, Operations and store it in an array
                Operations[] operations = Operations.values();

                // Iterate through the array and display each operation
                for(Operations operation : operations){
                    System.out.println(operation.ordinal() + 1 + ". " + operation);
                }

                operationChoice = Integer.parseInt(bufferedReader.readLine());

                if ( operationChoice > 5 || operationChoice < 1){
                    System.out.println("Choice not found. Please try again. \n");
                    continue;
                }
                break;
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter an integer. Try again. \n");
            } catch (IOException e){
                System.out.println("An error occurred while reading the input. Please try again. \n");
                attempts++;
                if (attempts >= MAX_ATTEMPTS) {
                    System.out.println("Max attempts reached. Exiting the loop.\n");
                    break;
                }
            } // End of the catch

        } while(true);

        return operationChoice;
    } // End of the displayMenu method
}
