package CS122Exercises;

/**
 * Name of Student/Programmer: BAG-EO, Jim Hendrix
 * CLASS CODE & Schedule: 9322A 3:00 PM - 4:30 PM TF
 * Date: February 2, 2024
 *
 *Student Records Keeping Using Parallel Arrays
 *
 * An ID number, a name, a course, a year level and others are
 * attributed to a student. Hence, eight arrays are
 * used: An array that stores ID numbers, an array that
 * stores names, an array that stores courses, an array
 * that stores year levels, etc. The eight arrays are treated
 * as parallel arrays such that the first elements of the
 * eight arrays are actual attributes (ID number, name, course,
 * year level, etc. ) of one student, the second elements are
 * actual attributes of another student, and so on.
 **/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BAGEORecordsViaParallelArrays {

    // Declare and Instantiate constant variables
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final String INVALID_GRADE = "Invalid input. Grades should range from 65 - 99 only. Please try again. ";
    private static final String INVALID_YEAR_LEVEL = "Invalid input. Year level should range from 1 to 5. Please try again. ";


    public static void main(String[] args) {
        BAGEORecordsViaParallelArrays myProgram;

        myProgram = new BAGEORecordsViaParallelArrays();
        myProgram.run();

        System.exit(0);
    }



    public void run() {
        String[] id; // Array that will store ID numbers
        String[] names; // Array that will store names
        String[] course;// Array that will store courses

        int[] yearLevel; // array that will store year levels
        int count; // variable that will store the number of students
        byte[] pGrade; // to store prelim grade
        byte[] mGrade; // to store midterm grade
        byte[] tFGrade; // to store tentative Final Grade
        byte[] fGrade; // to store final grade
        /* Read the number of students to be recorded from the keyboard */
        count = readInteger("How many student records will be created? ",1,50);


        /* TO DO: Instantiate the arrays such that each will have a length=size */
        id = new String[count];
        names = new String[count];
        course = new String[count];
        yearLevel = new int[count];
        pGrade = new byte[count];
        mGrade = new byte[count];
        tFGrade = new byte[count];
        fGrade= new byte[count];

        /* TO DO: Invoke the method that will fill the arrays with elements */
        populateArrays(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);


        /* Show the students following the order by which they were entered */
        System.out.println("Original Order Data");

        //TO DO: Invoke the method for displaying the array elements
        showData(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);


        // Show the students in sorted order
        System.out.println("Sorted Data");

        /* TO DO : Invoke the method that will sort the arrays in parallel */
        sortDataBasedOnNames(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);


        // TO DO: Invoke the method for displaying the array elements
        showData(id, names, course, yearLevel, pGrade, mGrade, tFGrade, fGrade);

    } // end of run method





    /**
     * Populates parallel arrays for ID numbers, names, course,
     * year levels, prelim grade, midterm grade, tentative final grade, and
     * final grade with user input and validation.
     *
     * Algorithm:
     * 1. Use a do-while loop for input and validation until successful.
     * 2. Inside the loop, use a for loop to iterate through each student (element of arrays).
     * 3. Prompt and populate the ID array.
     * 4. Prompt and populate the Name array.
     * 5. Prompt and populate the Program array.
     * 6. Use a do-while loop for Year Level input with validation:
     *    - Prompt and populate the Year Level array.
     *    - Validate that the input is between 1 and 5 (inclusive).
     * 7. Use a do-while loop for Prelim Grade input with validation:
     *    - Prompt and populate the Prelim Grade array.
     *    - Validate that the input is between 65 and 99 (inclusive).
     * 8. Use a do-while loop for Midterm Grade input with validation:
     *    - Prompt and populate the Midterm Grade array.
     *    - Validate that the input is between 65 and 99 (inclusive).
     * 9. Use a do-while loop for Tentative Final Grade input with validation:
     *    - Prompt and populate the Tentative Final Grade array.
     *    - Validate that the input is between 65 and 99 (inclusive).
     * 10. Calculate and populate the Final Grade array as the average of Prelim, Midterm, and Tentative Final grades.
     * 11. Break out of the loop when all data is successfully populated.
     * 12. Handle exceptions (IOException, NumberFormatException) with appropriate error messages.
     *
     */
    public void populateArrays(String[] id, String[] n, String[] c, int[] y, byte[] p, byte[] m, byte[] t, byte[] f) {
        do {
            try {
                for (int i = 0; i < n.length; i++) {
                    // Prompting for ID and Populate the ID array
                    System.out.print("ID of student " + (i + 1) + " : ");
                    id[i] = BAGEORecordsViaParallelArrays.bufferedReader.readLine();

                    // Prompting for Name and Populate the Name array
                    System.out.print("Name of student " + (i + 1) + " : ");
                    n[i] = BAGEORecordsViaParallelArrays.bufferedReader.readLine();

                    // Prompting for Program and Populate the Program array
                    System.out.print("Program of student " + (i + 1) + " : ");
                    c[i] = BAGEORecordsViaParallelArrays.bufferedReader.readLine();

                    // Year Level With Validation and Populate
                    int yearLevel;
                    do {
                        System.out.print("Year Level of student " + (i + 1) + " : ");
                        yearLevel = Integer.parseInt(BAGEORecordsViaParallelArrays.bufferedReader.readLine());
                        if (yearLevel < 6 && yearLevel > 0) break;
                        else System.out.println(INVALID_YEAR_LEVEL);
                    } while (true);
                    y[i] = yearLevel;

                    // Prelim Grade with Validation and Populate
                    byte prelimGrade;
                    do {
                        System.out.print("Prelim Grade of student " + (i + 1) + " : ");
                        prelimGrade = Byte.parseByte(BAGEORecordsViaParallelArrays.bufferedReader.readLine());
                        if (prelimGrade < 100 && prelimGrade > 64) break;
                        else System.out.println(INVALID_GRADE);
                    } while (true);
                    p[i] = prelimGrade;


                    // Midterm Grade with Validation and Populate
                    byte midtermGrade;
                    do {
                        System.out.print("Midterm Grade of student " + (i + 1) + " : ");
                        midtermGrade = Byte.parseByte(BAGEORecordsViaParallelArrays.bufferedReader.readLine());
                        if (midtermGrade < 100 && midtermGrade > 64) break;
                        else System.out.println(INVALID_GRADE);
                    } while (true);
                    m[i] = midtermGrade;

                    // Tentative Final Grade with Validation and Populate
                    byte tentativeFinalGrade;
                    do {
                        System.out.print("Prelim Grade of student " + (i + 1) + " : ");
                        tentativeFinalGrade = Byte.parseByte(BAGEORecordsViaParallelArrays.bufferedReader.readLine());
                        if (tentativeFinalGrade < 100 && tentativeFinalGrade > 64) break;
                        else System.out.println(INVALID_GRADE);
                    } while (true);
                    t[i] = tentativeFinalGrade;

                    // Solve for Final Grade and Populate
                    f[i] = (byte) ((p[i] + m[i] + t[i]) / 3);

                    System.out.println(); // For formatting purposes

                } // End of for loop

                break;
            } catch (IOException e) {
                System.out.println("An error occurred while reading the input. Please try again. ");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer. Please try again. ");
            }
        } while (true);

    } // end of populateArrays method





    /*
     * Algorithm: (SELECTION SORT)
     * 1. Iterate through each element of array 'n'.
     * 2. For each iteration, assume the current element 'n[i]' as the lowest.
     * 3. Initialize the index 'lowestIndex' to 'i' and a boolean 'swap' to false.
     * 4. Iterate through the remaining unsorted elements starting from 'i + 1'.
     * 5. Compare names lexicographically, if 'n[j]' is lexicographically smaller than 'lowest':
     *    - Update 'lowestIndex' to 'j'.
     *    - Update 'lowest' to 'n[j]'.
     *    - Set 'swap' to true.
     * 6. If 'swap' is true, swap elements in all arrays at index 'i' and 'lowestIndex':
     * 7. Repeat the process for each element in array 'n'.
     */
    public void sortDataBasedOnNames(String[] id, String[] n, String[] c, int[] yLevel, byte[] p, byte[] m, byte[] t, byte[] f) {
        // SELECTION SORT : find the lowest and swap
        for(int i = 0; i < n.length - 1; i++){ // Ends with the 2nd last element

            // Initialize the lowest element and index
            String lowest = n[i];
            int lowestIndex = i;
            boolean swap = false;

            // Iterate through the remaining unsorted elements
            for(int j = i + 1; j < n.length; j++){ // Starts with 1 position ahead from i and ends with the last element

                // Compare names lexicographically
                if(lowest.compareToIgnoreCase(n[j]) > 0){
                    lowestIndex = j;
                    lowest = n[j];
                    swap = true;
                }
            }

            // If necessary, swap elements in all arrays
            if(swap) {
                // ID swapping
                String temp1 = id[lowestIndex];
                id[lowestIndex] = id[i];
                id[i] = temp1;

                // Name swapping
                String temp2 = n[lowestIndex];
                n[lowestIndex] = n[i];
                n[i] = temp2;

                // Program swapping
                String temp3 = c[lowestIndex];
                c[lowestIndex] = c[i];
                c[i] = temp3;

                // Year Level swapping
                int temp4 = yLevel[lowestIndex];
                yLevel[lowestIndex] = yLevel[i];
                yLevel[i] = temp4;

                // Prelim grade swapping
                byte temp5 = p[lowestIndex];
                p[lowestIndex] = p[i];
                p[i] = temp5;

                // Midterm grade swapping
                byte temp6 = m[lowestIndex];
                m[lowestIndex] = m[i];
                m[i] = temp6;

                // Tentative final grade swapping
                byte temp7 = t[lowestIndex];
                t[lowestIndex] = t[i];
                t[i] = temp7;

                // Final grade swapping
                byte temp8 = f[lowestIndex];
                f[lowestIndex] = f[i];
                f[i] = temp8;
            }
        } // end of the outer for-loop

    } // end of sortBasedOnNames method





    /**
     * Show the elements of the arrays on the screen.
     **/
    public void showData(String[] id, String[] n, String[] c, int[] y, byte[] p,
                         byte[] m, byte[] t, byte[] f) {
//TO DO. Insert appropriate lines of codes
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n", "ID", "Name", "Program", "Year Level", "Prelim Grade", "Midterm Grade", "TFinal Grade", "Final Grade");
        for(int i = 0; i < n.length; i++){
            System.out.printf("%-15s%-15s%-15s%-15d%-15d%-15d%-15d%-15d%n", id[i], n[i], c[i], y[i], p[i], m[i], t[i], f[i]);
        }
        System.out.println(); // For formatting purposes
    } // end of showData method





    /** Returns an integer read from the keyboard. The integer must be
     * in the range lowLimit to upLimit.
     */
    public int readInteger(String promptMessage, int lowLimit, int upLimit){
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        boolean validValueRead = false;
        while( !validValueRead) {
            try { System.out.print(promptMessage + ": ");
                value = Integer.parseInt(scanner.nextLine());
                if (value < lowLimit ){
                    System.out.println("You must enter an integer that is not lower than "+lowLimit+".");
                } else if (value > upLimit) {
                    System.out.println("You must enter an integer that is not greater than "+ upLimit+".");
                } else
                    validValueRead = true;
            } catch (NumberFormatException x){
                System.out.println("You may have entered an invalid integer.");
                System.out.println("Try again. ");
            } // end of catch
        } // end of while
        return value;
    } // end of readInteger
} // end of StudentRecordsViaParallelArrays class



/*
        SAMPLE OUTPUT
How many student records will be created? : 5

ID of student 1 : 3
Name of student 1 : Student3
Program of student 1 : BSCS
Year Level of student 1 : 2
Prelim Grade of student 1 : 90
Midterm Grade of student 1 : 95
Prelim Grade of student 1 : 85

ID of student 2 : 5
Name of student 2 : Student5
Program of student 2 : MMA
Year Level of student 2 : 4
Prelim Grade of student 2 : 91
Midterm Grade of student 2 : 93
Prelim Grade of student 2 : 95

ID of student 3 : 1
Name of student 3 : Student1
Program of student 3 : BSIT
Year Level of student 3 : 2
Prelim Grade of student 3 : 98
Midterm Grade of student 3 : 96
Prelim Grade of student 3 : 94

ID of student 4 : 4
Name of student 4 : Student4
Program of student 4 : Accountancy
Year Level of student 4 : 3
Prelim Grade of student 4 : 98
Midterm Grade of student 4 : 97
Prelim Grade of student 4 : 96

ID of student 5 : 2
Name of student 5 : Student2
Program of student 5 : BSMA
Year Level of student 5 : 2
Prelim Grade of student 5 : 95
Midterm Grade of student 5 : 91
Prelim Grade of student 5 : 99

Original Order Data
ID             Name           Program        Year Level     Prelim Grade   Midterm Grade  TFinal Grade   Final Grade
3              Student3       BSCS           2              90             95             85             90
5              Student5       MMA            4              91             93             95             93
1              Student1       BSIT           2              98             96             94             96
4              Student4       Accountancy    3              98             97             96             97
2              Student2       BSMA           2              95             91             99             95

Sorted Data
ID             Name           Program        Year Level     Prelim Grade   Midterm Grade  TFinal Grade   Final Grade
1              Student1       BSIT           2              98             96             94             96
2              Student2       BSMA           2              95             91             99             95
3              Student3       BSCS           2              90             95             85             90
4              Student4       Accountancy    3              98             97             96             97
5              Student5       MMA            4              91             93             95             93
 */
