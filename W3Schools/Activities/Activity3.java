import java.util.Scanner;

public class Activity3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("1st num: ");
        int num1 = scanner.nextInt();

        System.out.print("2nd num: ");
        int num2 = scanner.nextInt();

        // Menu
        System.out.println("\n1 sum");
        System.out.println("2 difference");
        System.out.println("3 product");
        System.out.println("4 quotient");

        System.out.print("\nchoice: ");
        int choice = scanner.nextInt();

        // Choose method
        System.out.println("\nChoose solution method:");
        System.out.println("1 - if-else");
        System.out.println("2 - switch");
        System.out.print("Your choice: ");
        int method = scanner.nextInt();

        System.out.println(); // Line break for output clarity

        if (method == 1) {
            // Solution using if-else
            if (choice == 1) {
                System.out.println("The sum of 2 whole numbers is: " + (num1 + num2));
            } else if (choice == 2) {
                System.out.println("The difference of 2 whole numbers is: " + (num1 - num2));
            } else if (choice == 3) {
                System.out.println("The product of 2 whole numbers is: " + (num1 * num2));
            } else if (choice == 4) {
                if (num2 != 0) {
                    System.out.println("The quotient of 2 whole numbers is: " + (num1 / num2));
                } else {
                    System.out.println("Cannot divide by zero.");
                }
            } else {
                System.out.println("Invalid operation choice.");
            }

        } else if (method == 2) {
            // Solution using switch
            switch (choice) {
                case 1:
                    System.out.println("The sum of 2 whole numbers is: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("The difference of 2 whole numbers is: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("The product of 2 whole numbers is: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 != 0) {
                        System.out.println("The quotient of 2 whole numbers is: " + (num1 / num2));
                    } else {
                        System.out.println("Cannot divide by zero.");
                    }
                    break;
                default:
                    System.out.println("Invalid operation choice.");
            }

        } else {
            System.out.println("Invalid method selection.");
        }

        scanner.close();
    }
}
