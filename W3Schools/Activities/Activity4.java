import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 1: Display numbers 1 to 100
        System.out.println("Numbers from 1 to 100:");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n\nNow enter 5 whole numbers:");

        // Part 2: Accept exactly 5 numbers using a loop
        int count = 0;
        while (count < 5) {
            System.out.print("Enter number #" + (count + 1) + ": ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                count++;
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // clear invalid input
            }
        }

        System.out.println("\nThank you! You've entered 5 valid numbers.");
        scanner.close();
    }
}
