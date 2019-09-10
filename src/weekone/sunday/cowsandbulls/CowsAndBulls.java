package weekone.sunday.cowsandbulls;
import java.util.Random;
import java.util.Scanner;


public class CowsAndBulls {
    // Variable Declaration
    byte cows;
    byte bulls;
    byte difficulty;
    boolean isCorrect;
    boolean hasQuit;
    String wordToGuess;
    String currentGuess;


    String[] threeLetterWords;
    String[] fourLetterWords;
    String[] fiveLetterWords;
    // End of Variable Declaration

    Scanner sc = new Scanner(System.in);

    // main function called at the start of the program
    public static void main(String[] args) {
        CowsAndBulls game = new CowsAndBulls();
        while(!game.hasQuit) {
            game.mainMenu();
        }
    }

    // ----------------------------------
    //          CONSTRUCTOR
    // ----------------------------------
    public CowsAndBulls() {
        this.cows = 0;
        this.bulls = 0;
        this.difficulty = 1;
        this.hasQuit = false;

        threeLetterWords = new String[]{"ant", "pin", "nap", "rib", "leg", "die", "gun", "eat", "set"};
        fourLetterWords = new String[]{"duck", "base", "sell", "rise", "warn","fade","term","herb","user","desk"};
        fiveLetterWords = new String[]{"pluck", "blast","field","first","drill","flock","spare","flour","ditch","pound"};
    }
    public CowsAndBulls(byte difficulty) {
        this.cows = 0;
        this.bulls = 0;
        this.difficulty = difficulty;
        this.hasQuit = false;

        threeLetterWords = new String[]{"ant", "pin", "nap", "rib", "leg", "die", "gun", "eat", "set"};
        fourLetterWords = new String[]{"duck", "base", "sell", "rise", "warn","fade","term","herb","user","desk"};
        fiveLetterWords = new String[]{"pluck", "blast","field","first","drill","flock","spare","flour","ditch","pound"};
    }
    // -----------------------------
    //      END OF CONSTRUCTOR
    // -----------------------------

    // Main menu for the game
    private void mainMenu() {
        // MENU TEXT
        System.out.println("--------------------");
        System.out.println("Welcome to the bulls and cows game!");
        System.out.println("The ultimate word guessing game!");
        System.out.println("1 > Play");
        System.out.println("2 > Set Difficulty");
        System.out.println("3 > Instructions");
        System.out.println();
        System.out.println("0 > Quit");

        // takes the users input for their menu choice
        int choice = menuSelection(3); // calls a function that validates the number input
        switch (choice){
            case 0:
                // quit
                this.hasQuit = true;
                break;
            case 1:
                play();
                break;
            case 2:
                selectDifficulty();
                break;
            case 3:
                // instruction menu
                instructionMenu();
                break;
        }
    }

    private void instructionMenu() {
        System.out.println("In bulls and cows your aim is");
        System.out.println("to guess the randomly generated");
        System.out.println("word. If you guess a correct letter");
        System.out.println("(but it is not in the correct place)");
        System.out.println("then you will gain a cow. If you");
        System.out.println("guess the correct letter in the ");
        System.out.println("correct place then you will be given");
        System.out.println("a bull. Use this to try and get all bulls");
        System.out.println("which means you have guessed the word correctly.");
        System.out.println("GOOD LUCK! enter any key to continue");
        sc.next();
    }

    // used to take an integer input from the user which is then validated
    private int menuSelection(int num){
        System.out.println("Enter a number between 0 and " + num);
        while (true) {
            try {
                int choice = Integer.parseInt(sc.next());
                if (choice >= 0 && choice <= num){
                    return choice;
                } else {
                    System.out.println("Error! Please enter a valid number between 0 and " + num);
                }
            } catch (Exception e) {
                System.out.println("Error! Please enter a valid number between 0 and " + num);
            }
        }
    }
    // used to change the difficulty of the game
    // the difficulty setting will determine the length of the random word
    private void selectDifficulty(){
        System.out.println("--------------------");
        System.out.println("Select Difficulty :");
        System.out.println("1 > Easy");
        System.out.println("2 > Medium");
        System.out.println("3 > Hard");
        System.out.println();
        System.out.println("0 > Return");
        int choice = menuSelection(3);
        switch (choice){
            case 0:
                return;
            case 1:
                this.difficulty = 0;
                System.out.println("difficulty set to 'easy'");
                break;
            case 2:
                this.difficulty = 1;
                System.out.println("difficulty set to 'medium'");
                break;
            case 3:
                this.difficulty = 2;
                System.out.println("difficulty set to 'hard'");
                break;
        }
    }

    // will call other functions to guess the word and validate against the random word
    private void play(){
        // select the random word based on difficulty
        this.isCorrect = false;
        selectRandomWord();

        // user will have 15 guesses to get the word
        for (int x = 0; x < 15; x++){
            if (x == 14){
                System.out.println("Guess " + (x+1) + " (final guess): ");
            }else{
                System.out.println("Guess " + (x+1) + ": ");
            }


            guessWord();                                // calls function to take the user guess
            checkGuess();                               // calls the function to check the guess against the random word
            System.out.println("Cows >>\t" + cows);     // displays cow number
            System.out.println("Bulls >>\t" + bulls);   // displays bull number

            // checks for win and if so, the game will end
            hasWon();
            if (isCorrect){
                break;
            }

            // checks if the current attempt is the last attempt
            // if so, then the wordtoguess is displayed to the user
            if (!isCorrect && (x == 14)){
                System.out.println("You have lost!");
                System.out.println("The word was - " + wordToGuess);
                System.out.println("enter any key to continue");
                sc.next();
            }
        }
    }

    private void selectRandomWord (){
        Random rand = new Random(System.currentTimeMillis());
        switch(this.difficulty){
            case 0:
                wordToGuess = threeLetterWords[rand.nextInt(9)];
                break;
            case 1:
                wordToGuess = fourLetterWords[rand.nextInt(9)];
                break;
            case 2:
                wordToGuess = fiveLetterWords[rand.nextInt(9)];
                break;
        }
    }

    private void guessWord(){
        System.out.println("please enter a " + (difficulty+3) + " letter long word:");
        while(true) {
            String guess = sc.next();
            if (guess.length() != (difficulty + 3)) {
                System.out.println("Error! Please enter a " + (difficulty + 3) + "letter long word");
            } else {
                this.currentGuess = guess;
                break;
            }
        }
    }

    private void checkGuess(){
        // TODO loop guess against random word
        // loop guess
        bulls = 0;
        cows = 0;
        for (int x = 0; x < wordToGuess.length(); x++){
            for (int y = 0; y < currentGuess.length(); y++){
                if(x == y && (wordToGuess.charAt(x) == currentGuess.charAt(y))){
                    bulls++;
                }
                else if(wordToGuess.charAt(x) == currentGuess.charAt(y)){
                    cows++;
                }
            }
        }
    }

    // function below checks if the bull number is equivalent
    // to the word length and then
    private void hasWon(){
        if (bulls == (difficulty+3)){
            this.isCorrect = true;
            System.out.println();
            System.out.println("---------------");
            System.out.println("CONGRATULATIONS");
            System.out.println("YOU SUCCESSFULLY");
            System.out.println("GUESSED THE");
            System.out.println("RANDOM WORD");
            System.out.println("---------------");
            System.out.println("enter any key to continue");
            sc.next();
        }
    }
}
