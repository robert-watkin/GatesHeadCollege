package weekfive.monday.rockpapersScissors;

import javafx.scene.media.MediaPlayer;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Menu m = new Menu();
        while (true){
            m.mainMenu();
        }
    }

    private void mainMenu(){
        System.out.println("===== Welcome to Rock, Paper, Scissors =====");
        System.out.println("1 . Single Player");
        System.out.println("2 . Two Player");
        System.out.println("3 . Extended");
        System.out.println("0 . quit");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        try {
            while (true) {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 0 && choice <= 3){
                    break;
                }
                System.out.println("Please enter a valid number");
            }
        }
        catch (Exception e){
            System.out.println("Please enter a valid number");
        }

        switch (choice){
            case 0:
                System.exit(0);
                break;
            case 1:
                // Single player
                PlayGame sp = new PlayGame();
                sp.singlePlayer();
                break;
            case 2:
                // multiplayer
                PlayGame mp = new PlayGame();
                mp.multiPlayer();
                break;
            case 3:
                // extended
                PlayGame ext = new PlayGame();
                ext.extended();
                break;
            default:
                System.out.println("Invalid menu choice");
        }
    }
}
