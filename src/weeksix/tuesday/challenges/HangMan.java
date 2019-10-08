/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
    int manDrawn;
    ArrayList<Character> guessedLetters;
    String wordToGuess;
    boolean won;

    public static void main(String[] args) {
        HangMan hm = new HangMan();
        System.out.println("Welcome to Hangman");
        hm.start();

    }
    
    private void start(){
        guessedLetters = new ArrayList<>();
        won = false;
        manDrawn = 0;
        generateWord();
        System.out.println("A new random word has been generated");
        drawMan();
        while (!won && manDrawn < 6){
            outputWord();
            if (won) {
                System.out.println("Congratulations! You have won!");
                break;
            } else {
                System.out.println("You have lost! IDIOT!!");
            }
            guess();
            System.out.println("------------------");
            drawMan();
            usedLetters();
        }

    }

    private void usedLetters() {
        System.out.print("Used Letters - " );
        for (int x = 0; x < guessedLetters.size(); x++){
            System.out.print(guessedLetters.get(x) + " ");
        }
        System.out.println();
    }

    private void drawMan() {
        switch (manDrawn){
            case 0:
                System.out.println("           _______");
                System.out.println("          |/      |");
                System.out.println("          |     ");
                System.out.println("          |     ");
                System.out.println("          |     ");
                System.out.println("          |     ");
                System.out.println("          |");
                System.out.println("         _|___");
                break;
            case 1:
                System.out.println("           _______");
                System.out.println("          |/      |");
                System.out.println("          |      (_)");
                System.out.println("          |     ");
                System.out.println("          |     ");
                System.out.println("          |     ");
                System.out.println("          |");
                System.out.println("         _|___");
                break;
            case 2:
                System.out.println("           _______");
                System.out.println("          |/      |");
                System.out.println("          |      (_)");
                System.out.println("          |       |");
                System.out.println("          |       |");
                System.out.println("          |      ");
                System.out.println("          |");
                System.out.println("         _|___");
                break;
            case 3:
                System.out.println("           _______");
                System.out.println("          |/      |");
                System.out.println("          |      (_)");
                System.out.println("          |       |");
                System.out.println("          |       |");
                System.out.println("          |      / ");
                System.out.println("          |");
                System.out.println("         _|___");
                break;
            case 4:
                System.out.println("           _______");
                System.out.println("          |/      |");
                System.out.println("          |      (_)");
                System.out.println("          |       |");
                System.out.println("          |       |");
                System.out.println("          |      / \\");
                System.out.println("          |");
                System.out.println("         _|___");
                break;
            case 5:
                System.out.println("           _______");
                System.out.println("          |/      |");
                System.out.println("          |      (_)");
                System.out.println("          |      \\|");
                System.out.println("          |       |");
                System.out.println("          |      / \\");
                System.out.println("          |");
                System.out.println("         _|___");
                break;
            case 6:
                System.out.println("           _______");
                System.out.println("          |/      |");
                System.out.println("          |      (_)");
                System.out.println("          |      \\|/");
                System.out.println("          |       |");
                System.out.println("          |      / \\");
                System.out.println("          |");
                System.out.println("         _|___");
                break;
        }
    }

    private void outputWord() {
        int correctLetters = 0;
        for (int x = 0; x < wordToGuess.length(); x++){
            if (guessedLetters.contains(wordToGuess.charAt(x))){
                System.out.print(wordToGuess.charAt(x));
                correctLetters++;
            }else{
                System.out.print("_ ");
            }
        }
        System.out.println( " (" + wordToGuess.length() + " letters)");
        if (correctLetters == wordToGuess.length()) {
            won = true;
        }
    }

    private void guess() {
        Scanner sc;
        char guess;
        while (true) {
            sc = new Scanner(System.in);
            try {
                String input = sc.nextLine();
                guess = input.charAt(0);
                if (guessedLetters.contains(guess)) {
                    System.out.println("You cannot guess the same letter twice");
                } else if (input.length() == 1){
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
        }
        guessedLetters.add(guess);
        boolean guessInWord = false;
        for (int x = 0; x < wordToGuess.length(); x++){
            if (wordToGuess.charAt(x) == guess){
                guessInWord = true;
            }
        }

        if (!guessInWord){
            manDrawn++;
        }
    }

    private void generateWord() {
        try {
            Random rand = new Random();
            File file = new File("src\\weeksix\\tuesday\\challenges\\1000words");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            int y = rand.nextInt(1000);
            for (int x = 0; x < y; x++){
                wordToGuess = br.readLine();
            }
            br.close();
            fr.close();
            System.out.println(wordToGuess);
        }catch (Exception e){
            System.out.println("FILE NOT FOUND EXCEPTION");
        }
    }
}
