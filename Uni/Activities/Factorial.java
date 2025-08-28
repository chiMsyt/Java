package Java.Uni.Activities;

// =======================================
// 1. Factorial of a given number
// =======================================

/*
    PROBLEM:
    Factorial of a number (n!) is the product of all positive integers from 1 up to n.
    Example: 5! = 5 * 4 * 3 * 2 * 1 = 120.

    IDEA:
    Factorial is a classic example of recursion, because n! can be defined as:
        - Base case: 0! = 1 and 1! = 1
        - Recursive case: n! = n * (n-1)!

    RECURSION:
        - Base case: when n = 0 or n = 1, we return 1 because 0! = 1 and 1! = 1 by definition.
        - Recursive step: we call factorial(n-1) with a smaller number.
        - The algorithm keeps reducing the problem size until it reaches the base case.
*/
public class Factorial {

    // Recursive method to compute factorial
    public static long factorial(int n) {
        // Base case: stopping condition of recursion.
        // If n = 0 or n = 1, we return 1 because 0! = 1 and 1! = 1 by definition.
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case:
        // Instead of multiplying directly, we reduce the problem size.
        // n! = n * factorial(n-1).
        // This keeps calling itself until the base case is reached.
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 5; // Example input
        // Call the recursive method and display the result
        System.out.println("Factorial of " + num + " = " + factorial(num));
    }
}
