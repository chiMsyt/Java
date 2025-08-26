package Java.Uni.Activities;

// =======================================
// 3. Fibonacci Sequence
// =======================================
public class Fibonacci {
    // Recursive method to compute nth Fibonacci number
    public static int fibonacci(int n) {
        if (n == 0) return 0; // Base case
        if (n == 1) return 1; // Base case
        // Recursive step
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.print("Fibonacci sequence up to " + n + " terms: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
