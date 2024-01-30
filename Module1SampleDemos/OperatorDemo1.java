package CS122Exercises;

/*

    Name: Bag-eo, Jim Hendrix T.
    Class Code: 9322B
    Course Number: CS 122L
    Schedule: 3:00 PM - 4:30 PM TF
    Date: January 30, 2024


    Sample Output:
    Initial Count = 5
    Adjust count = 12
    New Value of Count = 6

 */

public class OperatorDemo1 {
    public static void main(String[] args) {
        int count = 5;
        int adjustmentAmount = 0;
        System.out.println("Initial Count = " + count);

        adjustmentAmount = ++count * 2;

        System.out.println("Adjust count = " + adjustmentAmount);
        System.out.println("New Value of Count = " + count);
    } // end of main method
} // end of the class
