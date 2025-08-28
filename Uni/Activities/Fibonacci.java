package Java.Uni.Activities;

// =======================================
// 3. Fibonacci Sequence
// =======================================

/*
    PROBLEM:
    The Fibonacci sequence starts with 0 and 1.
    Each next number is the sum of the two before it.
    Example: 0, 1, 1, 2, 3, 5, 8, 13...

    IDEA:
    Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
    With base cases:
      Fibonacci(0) = 0
      Fibonacci(1) = 1

    RECURSION:
        - Base case: when n = 0 or n = 1, we return 0 or 1 respectively.
        - Recursive step: we call fibonacci(n-1) and fibonacci(n-2) with smaller numbers.
        - The algorithm keeps reducing the problem size until it reaches the base case.
*/
public class Fibonacci {

    // Recursive method to compute nth Fibonacci number
    public static int fibonacci(int n) {
        // Base cases: define the first two numbers of the sequence
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive case:
        // The nth Fibonacci number is the sum of the two previous ones
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // Example: Print first 10 terms
        System.out.print("Fibonacci sequence up to " + n + " terms: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
