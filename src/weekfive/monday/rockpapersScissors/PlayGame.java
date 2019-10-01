package weekfive.monday.rockpapersScissors;

import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    private int round;
    private int playerOneChoice;
    private int playerTwoChoice;
    private String pOneChoice;
    private String pTwoChoice;
    private int playerOneScore;
    private int playerTwoScore;
    private boolean playerOneWon;
    private boolean playerTwoWon;

    public PlayGame() {
        this.round = 1;
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
        this.playerOneWon = false;
        this.playerTwoWon = false;
    }

    public void extended(){
        while (!playerOneWon && !playerTwoWon) { // TODO fix loop
            System.out.println("===== ROUND " + round + " =====");
            getPlayerChoiceExtended(1);
            getPlayerChoiceExtended(2);

            System.out.println();

            pOneChoice = setString(this.playerOneChoice);
            pTwoChoice = setString(this.playerTwoChoice);

            System.out.println("Player One Chose " + pOneChoice);
            System.out.println("Player Two Chose " + pTwoChoice);

            compareExtendedChoice();
            System.out.println("Player 1 has " + playerOneScore);
            System.out.println("Player 2 has " + playerTwoScore);
            checkWin();
            System.out.println();
            round++;
        }
    }

    private void compareExtendedChoice() {
        if (playerOneChoice == 1 && playerTwoChoice == 2) {
            playerTwoScore++;
        } else if (playerOneChoice == 2 && playerTwoChoice == 3) {
            playerTwoScore++;
        } else if (playerOneChoice == 3 && playerTwoChoice == 1) {
            playerTwoScore++;
        } else if (playerOneChoice == 3 && playerTwoChoice == 4) {
            playerTwoScore++;
        } else if (playerOneChoice == 4 && playerTwoChoice == 5) {
            playerTwoScore++;
        } else if (playerOneChoice == 5 && playerTwoChoice == 1) {
            playerTwoScore++;
        } else if (playerOneChoice == 2 && playerTwoChoice == 5) {
            playerTwoScore++;
        } else if (playerOneChoice == 5 && playerTwoChoice == 3) {
            playerTwoScore++;
        } else if (playerOneChoice == 4 && playerTwoChoice == 2) {
            playerTwoScore++;
        } else if (playerOneChoice == 1 && playerTwoChoice == 4) {
            playerTwoScore++;
        } else if (playerOneChoice == playerTwoChoice) {
            return;
        } else {
            playerOneScore++;
        }
    }

    private void getPlayerChoiceExtended(int player) {
        System.out.println("Player " + player + ",");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissors");
        System.out.println("4 - Spock");
        System.out.println("5 - Lizard");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            while (true) {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 5) {
                    break;
                }
                System.out.println("Please enter a valid number");
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
        }

        if (player == 1) {
            playerOneChoice = choice;
        } else if (player == 2) {
            playerTwoChoice = choice;
        }
    }

    public void multiPlayer(){
        while (!playerOneWon && !playerTwoWon) { // TODO fix loop
            System.out.println("===== ROUND " + round + " =====");
            getPlayerChoice(1);
            getPlayerChoice(2);

            System.out.println();

            pOneChoice = setString(this.playerOneChoice);
            pTwoChoice = setString(this.playerTwoChoice);

            System.out.println("Player One Chose " + pOneChoice);
            System.out.println("Player Two Chose " + pTwoChoice);

            compareChoice();
            System.out.println("Player 1 has " + playerOneScore);
            System.out.println("Player 2 has " + playerTwoScore);
            checkWin();
            System.out.println();
            round++;
        }
    }

    public void singlePlayer() {
        while (!playerOneWon && !playerTwoWon) { // TODO fix loop
            System.out.println("===== ROUND " + round + " =====");
            getPlayerChoice(1);
            getAIChoice();

            System.out.println();

            pOneChoice = setString(this.playerOneChoice);
            pTwoChoice = setString(this.playerTwoChoice);

            System.out.println("Player One Chose " + pOneChoice);
            System.out.println("Player Two Chose " + pTwoChoice);

            compareChoice();
            System.out.println("Player 1 has " + playerOneScore);
            System.out.println("Player 2 has " + playerTwoScore);
            checkWin();
            System.out.println();
            round++;
        }
    }

    private String setString(int playerChoice) {
        switch (playerChoice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            case 4:
                return "Spock";
            case 5:
                return "Lizard";
            default:
                return "";
        }
    }

    private void checkWin() {
        if (playerOneScore >= (playerTwoScore + 3)){
            System.out.println("Player 1 Has Won!!!");
            playerOneWon = true;
        }
        if (playerTwoScore >= (playerOneScore + 3)){
            System.out.println("Player 2 Has Won!!!");
            playerTwoWon = true;
        }
    }

    private void compareChoice() {
        // rock paper
        if (playerOneChoice == 1 && playerTwoChoice == 2) {
            playerTwoScore++;
        } else if (playerOneChoice == 2 && playerTwoChoice == 3) {
            playerTwoScore++;
        } else if (playerOneChoice == 3 && playerTwoChoice == 1) {
            playerTwoScore++;
        } else if (playerOneChoice == 1 && playerTwoChoice == 3) {
            playerOneScore++;
        } else if (playerOneChoice == 3 && playerTwoChoice == 2) {
            playerOneScore++;
        } else if (playerOneChoice == 2 && playerTwoChoice == 1) {
            playerOneScore++;
        }
    }

    private void getAIChoice() {
        Random rand = new Random();
        playerTwoChoice = rand.nextInt(2) + 1;
    }

    private void getPlayerChoice(int player) {
        System.out.println("Player " + player + ",");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissors");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            while (true) {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 3) {
                    break;
                }
                System.out.println("Please enter a valid number");
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
        }

        if (player == 1) {
            playerOneChoice = choice;
        } else if (player == 2) {
            playerTwoChoice = choice;
        }
    }
}