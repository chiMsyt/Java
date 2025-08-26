package Java.Uni.Activities;

// =======================================
// 2. Towers of Hanoi
// =======================================
public class TowersOfHanoi {
    // Recursive method to solve Towers of Hanoi
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {  // Base case: one disk
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }
        // Recursive step: move n-1 disks to auxiliary rod
        solveHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        // Recursive step: move n-1 disks to target rod
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int n = 3;
        solveHanoi(n, 'A', 'C', 'B');
    }
}
