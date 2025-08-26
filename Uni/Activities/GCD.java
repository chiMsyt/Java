package Java.Uni.Activities;

// =======================================
// 6. Greatest Common Divisor (GCD)
// Euclidean algorithm (recursive)
// =======================================
public class GCD {
    // Recursive GCD method
    public static int gcd(int a, int b) {
        if (b == 0) return a;   // Base case
        return gcd(b, a % b);   // Recursive step
    }

    public static void main(String[] args) {
        int a = 56, b = 98;
        System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));
    }
}
