package Java.Uni.Activities;

// =======================================
// 5. Least Common Multiple (LCM)
// Uses recursion via GCD
// Formula: LCM(a,b) = (a * b) / GCD(a,b)
// =======================================
public class LCM {
    // Recursive GCD
    public static int gcd(int a, int b) {
        if (b == 0) return a;       // Base case
        return gcd(b, a % b);       // Recursive step
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 12, b = 18;
        System.out.println("LCM of " + a + " and " + b + " = " + lcm(a, b));
    }
}
