package Java.Uni.Activities;

// =======================================
// 2. Towers of Hanoi
// =======================================

/*
    PROBLEM:
    The Towers of Hanoi is a puzzle with 3 rods and n disks of different sizes.
    Rules:
      1. Only one disk can be moved at a time.
      2. A larger disk cannot be placed on top of a smaller one.
      3. All disks start on one rod, and the goal is to move them all to another rod.

    IDEA:
    To move n disks:
      - Move n-1 disks from source to auxiliary.
      - Move the largest disk to the destination.
      - Move n-1 disks from auxiliary to destination.

    RECURSION:
        - Base case: when n = 1, we move the disk directly.
        - Recursive step 1: we move n-1 disks from source to auxiliary.
        - Recursive step 2: we move the largest disk from source to destination.
        - Recursive step 3: we move n-1 disks from auxiliary to destination.
        - The algorithm keeps reducing the problem size until it reaches the base case.
*/
public class TowersOfHanoi {

    // Recursive method to solve Towers of Hanoi
    public static void solveHanoi(int n, char fromRod, char toRod, char auxRod) {
        // Base case: If there is only 1 disk, move it directly.
        if (n == 1) {
            System.out.println("Move disk 1 from " + fromRod + " to " + toRod);
            return;
        }

        // Recursive step 1: Move top n-1 disks to the auxiliary rod
        solveHanoi(n - 1, fromRod, auxRod, toRod);

        // Move the largest disk (nth) from source to destination
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);

        // Recursive step 2: Move n-1 disks from auxiliary to destination
        solveHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        int n = 3; // Example: 3 disks
        solveHanoi(n, 'A', 'C', 'B'); // Source=A, Destination=C, Auxiliary=B
    }
}
