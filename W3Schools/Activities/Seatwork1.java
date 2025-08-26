import java.util.Scanner;

public class Seatwork1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 1: Check divisibility by 5
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number % 5 == 0) {
            System.out.println(number + " is divisible by 5.");
        } else {
            System.out.println(number + " is not divisible by 5.");
        }

        // Part 2: Calculate average of 5 grades and determine pass/fail
        double total = 0;
        int numGrades = 5;

        System.out.println("\nEnter 5 grades:");
        for (int i = 1; i <= numGrades; i++) {
            System.out.print("Grade " + i + ": ");
            total += scanner.nextDouble();
        }

        double average = total / numGrades;
        System.out.printf("Average grade: %.2f\n", average);

        if (average >= 75) {
            System.out.println("Status: Passed");
        } else {
            System.out.println("Status: Failed");
        }

        scanner.close();
    }
}
