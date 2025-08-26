import java.util.Scanner;

public class Activity5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int evenCount = 0;
        int oddCount = 0;

        System.out.println("Enter 5 whole numbers:");

        for (int i = 1; i <= 5; i++) {
            System.out.print("Number " + i + ": ");

            // Input validation to accept only integers
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a whole number: ");
                scanner.next(); // Clear invalid input
            }

            int number = scanner.nextInt();

            // Check if even or odd
            if (number % 2 == 0) {
                System.out.println(number + " is even.");
                evenCount++;
            } else {
                System.out.println(number + " is odd.");
                oddCount++;
            }
        }

        // Final output
        System.out.println("\nTotal even numbers: " + evenCount);
        System.out.println("Total odd numbers: " + oddCount);

        scanner.close();
    }
}
