import java.util.Scanner;

public class Activity6 {

    // Method to compute sum
    public static int getSum(int a, int b) {
        return a + b;
    }

    // Method to compute difference
    public static int getDifference(int a, int b) {
        return a - b;
    }

    // Method to compute product
    public static int getProduct(int a, int b) {
        return a * b;
    }

    // Method to compute quotient
    public static int getQuotient(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Cannot divide by zero.");
            return 0; // or throw an error
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("1st number: ");
        int num1 = scanner.nextInt();

        System.out.print("2nd number: ");
        int num2 = scanner.nextInt();

        // Call methods and print results
        System.out.println("\nThe sum is: " + getSum(num1, num2));
        System.out.println("The difference is: " + getDifference(num1, num2));
        System.out.println("The product is: " + getProduct(num1, num2));
        System.out.println("The quotient is: " + getQuotient(num1, num2));

        scanner.close();
    }
}
