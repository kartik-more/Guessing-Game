package Bank_Managment;

import java.util.Random;
import java.util.Scanner;

public class Task2 {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        boolean playAgain = true;

        System.out.println("===== Welcome to Number Guessing Game =====");

        while (playAgain) {

            int maxRange = chooseDifficulty();
            playGame(maxRange);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");
        sc.close();
    }

   
    public static int chooseDifficulty() {

        System.out.println("\nChoose Difficulty Level");
        System.out.println("1. Easy (1 - 50)");
        System.out.println("2. Medium (1 - 100)");
        System.out.println("3. Hard (1 - 200)");

        int level;

        while (true) {
            System.out.print("Enter choice: ");

            if (sc.hasNextInt()) {
                level = sc.nextInt();
                break;
            } else {
                System.out.println("Alphabets are not allowed!");
                sc.next(); 
            }
        }

        switch (level) {
            case 1:
                return 50;
            case 2:
                return 100;
            case 3:
                return 200;
            default:
                System.out.println("Invalid choice. Default Medium selected.");
                return 100;
        }
    }

    // Game Logic
    public static void playGame(int maxRange) {

        int number = rand.nextInt(maxRange) + 1;
        int guess;
        int attempts = 0;

        System.out.println("\nGuess the number between 1 and " + maxRange);

        while (true) {

            System.out.print("Enter your guess: ");

            if (sc.hasNextInt()) {
                guess = sc.nextInt();
                attempts++;
            } else {
                System.out.println("Alphabets are not allowed!");
                sc.next();
                continue;
            }

            if (guess == number) {
                System.out.println(" Correct! You guessed the number!");
                System.out.println("Attempts taken: " + attempts);
                break;
            }
            else if (guess > number) {
                System.out.println("Too High!");
            }
            else {
                System.out.println("Too Low!");
            }
        }
    }
}