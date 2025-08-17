import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 7;   // attempts per round
    private static final int RANGE = 100;        // number range 1–100

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRounds = 0;
        int roundsWon = 0;

        System.out.println("=================================");
        System.out.println(" 🎯 Welcome to the Number Guessing Game!");
        System.out.println("=================================");

        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(RANGE) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds + " begins!");
            System.out.println("I’ve chosen a number between 1 and " + RANGE + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts. Good luck!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Congratulations! You guessed the number in " + attempts + " attempts!");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Sorry! You’ve used all attempts. The correct number was: " + numberToGuess);
            }

            // Ask for replay
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            playAgain = choice.equals("yes");
        }

        System.out.println("\n=================================");
        System.out.println(" 🏆 Game Over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Rounds won: " + roundsWon);
        System.out.println("=================================");

        scanner.close();
    }
}
