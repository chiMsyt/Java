import java.util.Scanner;

public class GradeAverage {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int total = 0;

            System.out.println("Enter 5 grades:");
            for (int i = 1; i <= 5; i++) {
                System.out.print("Grade " + i + ": ");
                int grade = input.nextInt();
                total += grade;
            }

            double average = total / 5.0;
            System.out.println("Average: " + average);

            if (average >= 75) {
                System.out.println("Status: Passed");
            } else {
                System.out.println("Status: Failed");
            }
        }

        System.exit(0);
    }
}