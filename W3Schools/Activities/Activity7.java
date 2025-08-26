import java.util.Scanner;

public class Activity7 {

    // Arithmetic methods
    public static int getSum(int a, int b) {
        return a + b;
    }

    public static int getDifference(int a, int b) {
        return a - b;
    }

    public static int getProduct(int a, int b) {
        return a * b;
    }

    public static int getQuotient(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
    }

    public static void displayNumbers1To100() {
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("\nNumbers from 1 to 100:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println(); // newline
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char tryAgain;

        do {
            // Input
            System.out.print("\n1st number: ");
            int num1 = scanner.nextInt();

            System.out.print("2nd number: ");
            int num2 = scanner.nextInt();

            // Output using method calls
            System.out.println("\nThe sum is: " + getSum(num1, num2));
            System.out.println("The difference is: " + getDifference(num1, num2));
            System.out.println("The product is: " + getProduct(num1, num2));
            System.out.println("The quotient is: " + getQuotient(num1, num2));

            // Display 1–100 using array
            displayNumbers1To100();

            // Ask to repeat
            System.out.print("\nTry again? Y/N: ");
            tryAgain = scanner.next().toUpperCase().charAt(0);

        } while (tryAgain == 'Y');

        System.out.println("\nProgram terminated.");
        scanner.close();
    }
}
