package CS122Exercises;

import java.lang.*;
import java.util.Scanner;


/*

    Name: Bag-eo, Jim Hendrix T.
    Class Code: 9322B
    Course Number: CS 122L
    Schedule: 3:00 PM - 4:30 PM TF
    Date: January 30, 2024


    Sample Output:
    Please enter your age: 18
    Please enter your name: Jim Hendrix
    Hello Jim Hendrix! Being 18 years old is fun.

 */



public class Sample2 {
    public static void main(String[] args) {
        // Declaration and Instantiation of Scanner Object
        Scanner scanner = new Scanner(System.in);

        // Declaration of variables (age and name)
        int age;
        String name;

        // Ask user-input for age
        System.out.print("Please enter your age: ");
        age = Integer.parseInt(scanner.nextLine());

        // Ask user-input for name
        System.out.print("Please enter your name: ");
        name = scanner.nextLine();

        // Greet user
        System.out.println("Hello " + name + "! Being " + age + " years old is fun. ");
        System.exit(0);
    }
}
