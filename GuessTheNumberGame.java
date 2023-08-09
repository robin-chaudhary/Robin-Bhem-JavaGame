import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int maxAttempts = 10;

        Random random = new Random();
        int targetNumber = random.nextInt(max - min + 1) + min;

        System.out.println("Welcome to Guess the Number game!");
        System.out.println("I'm thinking of a number between " + min + " and " + max + ". Can you guess it?");
        System.out.println("You have " + maxAttempts + " attempts.");

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int guess;

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                int score = calculateScore(maxAttempts, attempts);
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                System.out.println("Your score is: " + score);
                break;
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Game over! You ran out of attempts. The number was: " + targetNumber);
        }

        scanner.close();
    }

    private static int calculateScore(int maxAttempts, int attempts) {
        int maxScore = 100;
        int minScore = 10;
        double scorePerAttempt = (double) (maxScore - minScore) / maxAttempts;
        int score = maxScore - (int) (scorePerAttempt * (attempts - 1));
        return Math.max(score, minScore);
    }
}
