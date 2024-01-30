package CS122Exercises;


/*
    Name: Bag-eo, Jim Hendrix T.
    Class Code: 9322B
    Course Number: CS 122L
    Schedule: 3:00 PM - 4:30 PM TF
    Date: January 30, 2024

    Sample Output:
    Excellent!
 */

public class Grade {
    public static void main(String[] args) {
        double grade = 92.00;
        if (grade >= 90) System.out.println("Excellent! ");
        else if (grade < 90 && grade >= 80) System.out.println("Good job!");
        else if (grade < 80 && grade >= 60) System.out.println("Study harder! ");
        else  System.out.println("Sorry, you failed. ");

    }
}
