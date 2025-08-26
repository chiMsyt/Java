import java.util.Scanner;

public class NetIncomeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get user input
        System.out.print("Enter your monthly income: ");
        double income = scanner.nextDouble();

        // Step 2: Calculate deductions
        double tax = income * 0.20;
        double sss = income * 0.10;
        double pagIbig = 100.00;

        // Step 3: Compute Net Income
        double netIncome = income - (tax + sss + pagIbig);

        // Step 4: Output result with condition
        if (netIncome > 0) {
            System.out.printf("Your Net Income is: ₱%.2f (Positive)%n", netIncome);
        } else {
            System.out.printf("Your Net Income is: ₱%.2f (Negative)%n", netIncome);
        }

        scanner.close();
    }
}
