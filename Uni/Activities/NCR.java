package Java.Uni.Activities;

// =======================================
// 4. Calculate nCr (Combination)
// Formula: nCr = n! / (r! * (n-r)!)
// =======================================

/*
    PROBLEM:
    nCr is the number of ways to choose r elements from n items (order doesn’t matter).
    Formula: nCr = n! / (r! * (n-r)!)

    IDEA:
    We use the factorial function recursively and apply the formula.

    RECURSION:
        - Base case: when n = 0 or n = 1, we return 1 because 0! = 1 and 1! = 1 by definition.
        - Recursive step: we call factorial(n-1) with a smaller number.
        - The algorithm keeps reducing the problem size until it reaches the base case.
*/
public class NCR {

    // Recursive factorial method
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1; // Base case
        return n * factorial(n - 1);    // Recursive case
    }

    // nCr calculation using factorial
    public static long nCr(int n, int r) {
        // Apply the formula: n! / (r! * (n-r)!)
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        int n = 5, r = 2; // Example
        System.out.println("nCr of (" + n + ", " + r + ") = " + nCr(n, r));
    }
}
