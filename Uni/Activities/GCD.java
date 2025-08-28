package Java.Uni.Activities;

// =======================================
// 6. Greatest Common Divisor (GCD)
// =======================================

/*
    PROBLEM:
    GCD is the largest positive integer that divides both numbers.
    Example: GCD(56, 98) = 14.

    IDEA:
    We use the Euclidean algorithm:
        - gcd(a, b) = gcd(b, a % b)
        - Stops when b = 0, then gcd = a.
        - This works because the remainder is always smaller than the divisor.
        - The algorithm keeps reducing the problem size until it reaches the base case.
        - The Euclidean algorithm is a fast, efficient method for finding the greatest common divisor (GCD) of two integers by repeatedly applying the division algorithm until a zero remainder is achieved

    RECURSION:
    - Base case: when b = 0, we return a.
    - Recursive step: we call gcd(b, a % b) with smaller numbers.
    - The algorithm keeps reducing the problem size until it reaches the base case.
*/
public class GCD {

    // Recursive GCD method
    public static int gcd(int a, int b) {
        if (b == 0) return a;   // Base case: if remainder is 0, we found the gcd
        return gcd(b, a % b);   // Recursive step
    }

    public static void main(String[] args) {
        int a = 56, b = 98;
        System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));
    }
}
