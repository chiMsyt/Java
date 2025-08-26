package Java.Uni.Activities;

// =======================================
// 1. Factorial of a given number
// =======================================
public class Factorial {
    // Recursive method to compute factorial
    public static long factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive step: n * factorial(n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " = " + factorial(num));
    }
}
