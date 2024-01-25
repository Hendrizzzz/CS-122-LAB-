import java.lang.*;
import java.util.Scanner;


public class SURNAMEWaterBillAnnualSummary {
    public static void main(String[] args) {
        int[] presentReading= new int[12];
        int[] startReading= new int[12];
        Scanner scanner = new Scanner(System.in);
        String consumer=""; // to hold name of consumer
        char cType = 'x'; // to hold type of consumer
        int[] nCMUsed = new int[12]; /* to hold number of cubic meters of water used for 12 months */
        int minCMResidential=12; /*to hold cut-off for minimum Bill for residential consumers */
        double minBillResidential=180.00; // minimum bill for <= 12 Cubic Meters used
        float rateResidential =30.00F; //cost of 1 Cubic Meter above the min. consumption
        int minCMCommercial=30; /* to hold cut-off for minimum Bill for commercial consumers*/
        double minBillCommercial=600.00; // minimum bill for <= 20Cubic Meters used
        float rateCommercial =50.00F; /*cost of 1 Cubic Meter above the min. consumption for commercial consumers*/
        double[] amountDue= new double[12]; // to hold the amount paid for 12 months
        showIntroduction();
        System.out.print("Enter the name of the water consumer: ");
        consumer = scanner.nextLine();
        cType = readTypeOfConsumer(scanner);
        startReading[0] = readStartReading(scanner);


        for (int index=0; index < nCMUsed.length; index++){
            presentReading[index] = readEndOfMonthReading(startReading[index], (index+1), scanner);
            if (index < (nCMUsed.length - 1)) startReading[index + 1] = presentReading[index];

            nCMUsed[index] = presentReading[index] - startReading[index];
            amountDue[index] = computeAmountDue(nCMUsed[index], cType, minCMResidential, minBillResidential, minCMCommercial, minBillCommercial, rateResidential, rateCommercial);
        }
        showSummary(consumer, cType, startReading, presentReading, nCMUsed, amountDue);
        System.exit(0);
    } // end of main method



    /*
    The showIntroduction method provides information to the user about the program.
    It shows that the program is for summarizing and analyzing the water bills
    It also mentions that the program will ask the user to enter values.
     */
    private static void showIntroduction() {
        System.out.println("""
                *******************************************************************************************
                *                             Water Bill Annual Summary Program                           *
                *******************************************************************************************
                
                $ This program will help you to summarize and analyze your water bills for the entire year $
                $ You will be asked to enter Water Meter Readings at year start and the end of each month  $
                $ The program will then calculate the monthly consumption, amount due, and provide summary $
                ____________________________________________________________________________________________
                """);
    }





/*
    ------------------------------Algorithm for readTypeOfConsumer()-------------------------------
    1. Start an infinite loop to continuously prompt the user until a valid input is received.
    2. Prompt the user through a menu
    3. Read the user input and extract the first character.
    5. Check if the entered character is 'r' or 'c'.
       - If it's not a valid option, print an error message and continue to the next iteration.
    6. If a valid option is entered, return the chosen character representing the type of consumer.
    7. End of the loop and the method.
    ------------------------------------------------------------------------------------------------
 */
    private static char readTypeOfConsumer(Scanner scanner) {
        while(true){
            System.out.print("""
                    Type of Consumer:
                    Enter 'c' if Commercial
                    Enter 'r' if Residential
                    """);
            System.out.print("Choose an option: ");
            char cType = scanner.nextLine().charAt(0);
            // Consume the remaining newline character in the input buffer
            scanner.reset();

            if(cType != 'r' && cType != 'c'){
                System.out.println("Invalid input. Please choose a valid answer. Try again. \n");
                continue;
            }
            return cType;
        }
    }


    


/*
    ----------------------------Algorithm for readStartReading()------------------------------
    1. Start an infinite loop to continuously prompt the user until a valid input is received.
    2. Ask user input for Water Readings at the beginning of the year
    3. Check if the parsed integer is less than 0 (negative):
       - If it's negative, print an error message, and continue to the next iteration.
    4. If the input is valid (non-negative), return the parsed integer from the user input.
    5. If a NumberFormatException occurs, catch the exception, print an error message, and
       continue to the next iteration
    6. End the loop and the method.
    ------------------------------------------------------------------------------------------
 */
    private static int readStartReading(Scanner scanner) {
        while(true){
            try{
                System.out.print("Water Meter Reading in cubic meters at the beginning of the year: ");
                int startWaterMeterReading = Integer.parseInt(scanner.nextLine());

                if(startWaterMeterReading < 0) {
                    System.out.println("Invalid input. Water Meter Readings can't be negative. Try again. ");
                    continue;
                }
                return  startWaterMeterReading;
            } catch (NumberFormatException e){
                System.err.println("Invalid input. Please enter an integer. Try again. ");
            }
        }
    }




/*
    --------------------------Algorithm for readEndOfMonthReading()--------------------------------
    1. Start an infinite loop to continuously prompt the user until a valid input is received.
    2. Ask user input for water meter reading at the end of the specified month.
    3. Check if the parsed integer is less than the previous reading:
       - If it's less, print an error message, and continue to the next iteration.
    4. If the input is valid (greater than or equal to the previous reading), return the user input.
    5. If a NumberFormatException occurs, catch the exception, and continue to the next iteration.
    6. End the loop and the method.
    ------------------------------------------------------------------------------------------------
*/
    private static int readEndOfMonthReading(int previousReading, int index, Scanner scanner) {
        while(true){
            try{
                System.out.print("Water Reading at the end of " + monthInWord(index) + ": ");
                int endOfMonthReading = Integer.parseInt(scanner.nextLine());

                if(endOfMonthReading < previousReading) {
                    System.out.println("Invalid input. The current Water Meter Reading cannot be lower than the previous reading. ");
                    continue;
                }
                return endOfMonthReading;
            } catch (NumberFormatException e){
                System.err.println("Invalid input. Please enter an integer. Try again. ");
            }
        }
    }




/*
    --------------------------Algorithm for computeAmountDue()-------------------------------
    1.. Use a switch statement based on the consumer type (cType):
       - Case 'r' or 'R' (Residential):
         a. Check if the number of cubic meters used (nCMUsed) is less than or equal to min1.
            i. If true, set the amount to minB1.
            ii. If false, calculate the amount as minB1 + (nCMUsed - min1) * rate1.
       - Case 'c' or 'C' (Commercial):
         a. Check if the number of cubic meters used (nCMUsed) is less than or equal to min2.
            i. If true, set the amount to minB2.
            ii. If false, calculate the amount as minB2 + (nCMUsed - min2) * rate2.
    2. Return the calculated amount.
    ------------------------------------------------------------------------------------------
*/
    public static double computeAmountDue(int nCMUsed, char cType, int min1, double minB1, int min2, double minB2, float rate1, float rate2){
        double amount = 0;
        switch (cType){
            case 'r':
            case 'R':
                if ( nCMUsed <= min1 ) {
                    amount = minB1;
                }
                else {
                    amount = minB1 + (nCMUsed-min1)*rate1;
                }
                break;
            case 'c':
            case 'C':
                if ( nCMUsed <= min2 ) {
                    amount = minB2;
                }
                else {
                    amount = minB2 + (nCMUsed-min2)*rate2;
                }
        }
        return amount;
    } // End of the class




    /*
        ----------------------------Algorithm for showSummary()----------------------------
        1. Print the title and introductory information for the annual water bill summary.
        2. Print the name of the consumer (n) and determine the type of consumer (t).
        3. Print the initial meter reading at the beginning of the year (previous[0]).
        4. Print a table header with columns: "Month", "End Reading", "Consumption", and "Amount Paid".
        5. Iterate through each month using a loop:
           a. Print the month name, end reading, consumption, and amount paid for each month.
           b. Utilize the monthInWord() method to get the month name based on the month index.
        6. Print the average monthly reading and average monthly payment using the computeAverage() method.
        7. Print the month with the lowest water consumption and the month with the highest water consumption
           using the findLowest() and findHighest() methods, respectively.
        8. End of the method.
        -------------------------------------------------------------------------------------
    */
    public static void showSummary(String n, char t, int[] previous, int[] present, int[] c, double[] amount){
        System.out.println();
        System.out.println("Annual Water Bill Summary");
        System.out.println("Name of Consumer: " + n);
        System.out.print("Type of consumer: ");
        if (Character.toLowerCase(t) == 'r') System.out.println("Residential");
        if (Character.toLowerCase(t) == 'c') System.out.println("Commercial");
        System.out.println("Meter reading at the beginning of year = " + previous[0] + " cubic meters");
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        System.out.printf("%15s%15s%15s%20s%n", "Month", "End Reading", "Consumption", "Amount Paid");
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        for (int index=0; index < previous.length; index++){
            System.out.printf("%15s%15d%15d%20.2f%n", monthInWord(index+1), present[index],c[index] , amount[index]);
        }
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        System.out.println("Average Monthly Reading = "+ computeAverage(c));
        System.out.println("Average Monthly Payment = "+ computeAverage(amount));
        System.out.println("Month with Lowest Water Consumption = "+ monthInWord((findLowest(c)+ 1)));
        System.out.println("Month with Highest Water Consumption = "+monthInWord((findHighest(c) + 1)));
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        return;
    }




    /**
     *Computes and returns the average of the elements an array of floating point numbers*/
    public static double computeAverage(double[] values){
        double total=0; // to hold the total of all elements
        double average=0; // to hold the average
        for (double element : values) // add the elements
            total = total + element;
        //compute the average
        average = total/values.length ; // total divided by number of elements
        return average;
    }
    /**
     *Computes and returns the average of the elements an array of integers
     */
    public static double computeAverage(int[] values){
        double total=0; // to hold the total of all elements
        double average=0; // to hold the average
        for (int element : values) // add the elements
            total = total + element;
        //compute the average
        average = (double) total/values.length ; //total divided by number of elements
        return average;
    }




    /**
     * The following method finds and returns the index of the element with the lowest value
     * from an array of positive integers.
     * The Linear Search algorithm is applied.
     */
    public static int findLowest(int[] values) {
        int lowestIndex = 0; // let lowest index be the first element

        for (int i = 1; i < values.length; i++) {
            if (values[i] < values[lowestIndex]) {
                lowestIndex = i; // update the lowest index to the index of the lower element
            }
        }
        return lowestIndex;
    }




    /**
     * Finds and returns the index of the element with the highest value from an array of integers.
     */
    public static int findHighest(int[] values) {
        int highestIndex = 0; // let highest index be the first element

        for (int i = 1; i < values.length; i++) {
            if (values[i] > values[highestIndex]) {
                highestIndex = i; // update the highest index to the index of the higher element
            }
        }
        return highestIndex;
    }



/*
    ------------------Algorithm for monthInWord()-------------------
    1. Initialize an empty string variable r to hold the month name.
    2. Use a switch statement based on the input integer m:
    3. Return the string r containing the month name.
    ------------------------------------------------------------------
*/
    public static String monthInWord(int m){
        String r = switch (m) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
        return r;
    } // end of monthInWord method
}// End of the class
