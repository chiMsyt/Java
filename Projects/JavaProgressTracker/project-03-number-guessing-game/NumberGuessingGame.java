// This is a simple number guessing game where the user has to guess a random number between 1 and 100.
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        Scanner scanner = new Scanner(System.in);
        int userGuess = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("Try to guess it!");

        while (userGuess != numberToGuess) {
            userGuess = scanner.nextInt();

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number!");
            }
        }

        scanner.close();
    }
}