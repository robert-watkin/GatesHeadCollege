/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    int randomNumber;
    int lives;
    boolean won;

    public static void main(String[] args) {
        NumberGuessingGame ngg = new NumberGuessingGame();
        ngg.start();
    }

    private void start() {
        won = false;
        lives = 5;
        Random rand = new Random();
        randomNumber = rand.nextInt(20);
        System.out.println("A new random number has been generated");

        while (!won && lives > 0) {
            guessNumber();
        }
        if (lives == 0){
            System.out.println("You have ran out of lives! Suckaa!!!");
        }
    }

    private void guessNumber() {
        Scanner sc = new Scanner(System.in);
        int guess;
        while (true) {
            try {
                System.out.println("--------Guess " + (6-lives) + "--------");
                System.out.println("Lives : " + lives);
                System.out.println("Enter your guess");
                guess = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Please enter a valid number");
            }
        }

        if (guess == randomNumber){
            System.out.println("Congrats! You were correct.");
            won = true;
        } else {
            System.out.println("Incorrect: You have lost a life");
            lives--;
        }
    }
}
