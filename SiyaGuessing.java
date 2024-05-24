/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package siyaguessing;

import java.util.Scanner;
import java.util.Random;

public class SiyaGuessing {

	public static void main(String[] args) {
            try ( // TODO Auto-generated method stub
                    Scanner scanner = new Scanner(System.in)) {
                Random random = new Random();
                boolean playAgain = true;
                int totalAttempts = 0;
                int totalGames = 0;
                
                while (playAgain) {
                    System.out.println("\n=== New Game ===");
                    int attempts = playGame(scanner, random);
                    totalAttempts += attempts;
                    totalGames++;
                    
                    // Ask if the user wants to play again
                    System.out.print("Do you want to play again? (yes/no): ");
                    String playAgainInput = scanner.next().toLowerCase();
                    if (!playAgainInput.equals("yes")) {
                        playAgain = false;
                    }
                }
                
                // Display the user's score
                if (totalGames > 0) {
                    double averageAttempts = (double) totalAttempts / totalGames;
                    System.out.printf("Your average number of attempts per game: %.2f%n", averageAttempts);
                } else {
                    System.out.println("No games were played.");
                }   }
	}
	
	public static int playGame(Scanner scanner, Random random) {
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10; // You can adjust this value as needed

        while (attempts < maxAttempts) {
            System.out.print("Guess the number (between 1 and 100): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.printf("Congratulations! You guessed the number correctly in %d attempts.%n", attempts);
                return attempts;
            } else if (guess < secretNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }
        }

        System.out.printf("Sorry, you've run out of attempts. The correct number was %d.%n", secretNumber);
        return -1;
    }

}
