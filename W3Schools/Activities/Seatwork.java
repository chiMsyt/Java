import java.util.Scanner;

public class Seatwork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            // Part 1: Arithmetic operations
            System.out.print("1st number: ");
            int num1 = scanner.nextInt();

            System.out.print("2nd number: ");
            int num2 = scanner.nextInt();

            int sum = num1 + num2;
            int diff = num1 - num2;
            int prod = num1 * num2;
            int quotient = num1 / num2;

            System.out.println("\nThe sum is: " + sum);
            System.out.println("The difference is: " + diff);
            System.out.println("The product is: " + prod);
            System.out.println("The quotient is: " + quotient);

            // Ask to try again
            System.out.print("\nTry again? Y/N: ");
            choice = scanner.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');

        // Part 2: Array of numbers 1 to 100
        System.out.println("\nNumbers from 1 to 100:");
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
            System.out.print(numbers[i] + " ");
        }

        scanner.close();
    }
}
