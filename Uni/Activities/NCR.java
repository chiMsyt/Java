package Java.Uni.Activities;

// =======================================
// 4. Calculate nCr (Combination)
// Formula: nCr = n! / (r! * (n-r)!)
// =======================================
public class NCR {
    // Recursive factorial method (used here again)
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1; // Base case
        return n * factorial(n - 1);    // Recursive step
    }

    public static long nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        int n = 5, r = 2;
        System.out.println("nCr of (" + n + ", " + r + ") = " + nCr(n, r));
    }
}
