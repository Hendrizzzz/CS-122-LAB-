package CS122Exercises;


/*

    Name: Bag-eo, Jim Hendrix T.
    Class Code: 9322B
    Course Number: CS 122L
    Schedule: 3:00 PM - 4:30 PM TF
    Date: January 30, 2024


    Sample Output:
    /*

    Name: Bag-eo, Jim Hendrix T.
    Class Code: 9322B
    Course Number: CS 122L
    Schedule: 3:00 PM - 4:30 PM TF
    Date: January 30, 2024


    Sample Output:
    Grade = C

 */

public class IfElseDemo {
    public static void main(String[] args) {
        int testScore = 76;
        char grade;

        if(testScore >= 90) grade = 'A';
        else if (testScore >= 80) grade = 'B';
        else if (testScore >= 70) grade = 'C';
        else if (testScore >= 60) grade = 'D';
        else grade = 'F';

        System.out.println("Grade = " + grade);
    }
}
