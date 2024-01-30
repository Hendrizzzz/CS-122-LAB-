package CS122Exercises;

import java.lang.*;


/*

    Name: Bag-eo, Jim Hendrix T.
    Class Code: 9322B
    Course Number: CS 122L
    Schedule: 3:00 PM - 4:30 PM TF
    Date: January 30, 2024


    Sample Output:
    461012seconds
    00461012
     +461012
     461,012
    +461,012

    Value of pi = 3.141593
    3.142
         3.142
    3.142

 */

public class Sample5 {
    public static void main(String[] args) {
        long duration = 461012;
        System.out.printf("%d%s%n", duration, "seconds");
        System.out.printf("%08d%n", duration);
        System.out.printf("%+8d%n", duration);
        System.out.printf("%,8d%n", duration);
        System.out.printf("%+,8d%n%n", duration);
        double pi = Math.PI;
        System.out.printf("%s%f%n", "Value of pi = ", pi);
        System.out.printf("%.3f%n", pi);
        System.out.printf("%10.3f%n", pi);
        System.out.printf("%-10.3f%n", pi);
    } // end of main
} // end of the class
