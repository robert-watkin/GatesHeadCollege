package weekthree.thursday.mobilebanking;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    // Variable declaration
    private User user;          // holds logged in user
    private String username;
    private String password;
    private int choice;
    Scanner sc = new Scanner(System.in);    // Scanner object for console input

    // CONSTRUCTOR - Takes user which previously logged in
    public MainMenu(User user) {
        this.user = user;
    }

    // Run function used to call other funcitons within the program
    public void run(){

        if (user.getAccountNumbers().size() > 0){
            displayMenu();      // Outputs the menu to the user
        }
        else {
            newCustomer();
            run();
        }
    }

    // Menu for new customers which don't have accounts
    private void newCustomer() {
        System.out.println("---Mobile Banking for " + user.getForename() + " " + user.getSurname() +"---");   // Displays user name for the menu
        System.out.println("We see you currently do not have an account");
        System.out.println("Would you like to open one now (y/n)");
        String choice = sc.nextLine();
        sc = new Scanner(System.in);
        if(choice.equalsIgnoreCase("y")) {
            openAccount();
        }
    }



    // Displays menu to the user
    private void displayMenu() {
        System.out.println("---Mobile Banking for " + user.getForename() + " " + user.getSurname() +"---");   // Displays user name for the menu
        System.out.println("1 >\tOpen New Account");
        System.out.println("2 >\tView All Accounts");
        System.out.println("3 >\tStatements");
        System.out.println("4 >\tTransfer Funds");
        System.out.println("0 >\tLog Out");
        System.out.println();
        System.out.println("Please enter a number from the menu above : ");
        int choice = UserChoice.getChoice(4);       // Takes the users menu choice + validates choice
        processChoice(choice);
    }


    // Processes the users menu input for what to do next
    private void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Log Out");
                break;
            case 1:
                openAccount();
                displayMenu();
                break;
            case 2:
                viewAccounts();
                displayMenu();
                break;
            case 3:
                ViewAccounts va = new ViewAccounts(user);
                va.showAllTransactions();
                displayMenu();
                break;
            case 4:
                transferFunds();
                displayMenu();
                break;
            default:
                // default case for invalid menu input
                // this should never be applicable as validation should already have occurred
                System.out.println("Error! Invalid menu option");
                break;
        }
    }

    // function to transfer funds
    private void transferFunds() {
        // creates new transfer funds object with the logged in user and performs the tranfer
        TransferFunds tf = new TransferFunds(user);
        tf.performTransfer();
    }

    // function to view accounts
    private void viewAccounts() {
        // creates new view accounts object with the logged in user and then calls view accounts within that object
        ViewAccounts va = new ViewAccounts(user);
        va.viewAccounts();
    }

    // opens new account
    private void openAccount() {
        OpenAccount oa = new OpenAccount(user);
    }
}
