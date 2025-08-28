package Java.Uni.Activities;

// =======================================
// 5. Least Common Multiple (LCM)
// =======================================

/*
    PROBLEM:
    LCM is the smallest positive number divisible by both a and b.
    Formula: LCM(a, b) = (a * b) / GCD(a, b)

    IDEA:
    We don’t directly recurse for LCM.
    Instead, we compute GCD using recursion and then apply the formula.

    RECURSION:
        - Base case: when b = 0, we return a.
        - Recursive step: we call gcd(b, a % b) with smaller numbers.
        - The algorithm keeps reducing the problem size until it reaches the base case.
*/
public class LCM {

    // Recursive GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0) return a;        // Base case
        return gcd(b, a % b);        // Recursive step
    }

    // LCM uses the result of GCD
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 12, b = 18;
        System.out.println("LCM of " + a + " and " + b + " = " + lcm(a, b));
    }
}
