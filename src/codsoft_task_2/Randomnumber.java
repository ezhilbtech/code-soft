package codsoft_task_2;
import java.util.Random;
import java.util.Scanner;
public class Randomnumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int rounds = 0;
        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;
            rounds++;
            System.out.println("Round " + rounds + ": Guess the number between 1 and 100. You have 10 attempts.");
            while (attempts < 10 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += 10 - attempts; // More points for fewer attempts
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + randomNumber + ".");
            }
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
        System.out.println("Game Over. Your total score is " + totalScore + ".");
        scanner.close();
    }
}
