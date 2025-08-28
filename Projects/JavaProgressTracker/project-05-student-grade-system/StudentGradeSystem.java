// This is a simple student grade system that allows users to input grades and calculate the average, highest, and lowest grades.

import java.util.Scanner;

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        double[] grades = new double[numStudents];
        
        // Input grades
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }
        
        // Calculate average, highest, and lowest grades
        double average = calculateAverage(grades);
        double highest = findHighest(grades);
        double lowest = findLowest(grades);
        
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        
        scanner.close();
    }

    public static double calculateAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public static double findHighest(double[] grades) {
        double highest = grades[0];
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static double findLowest(double[] grades) {
        double lowest = grades[0];
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
