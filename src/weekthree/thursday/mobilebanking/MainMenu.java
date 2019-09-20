package weekthree.thursday.mobilebanking;

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
        displayMenu(user);      // Outputs the menu to the user
        userChoice();           // Takes the users menu choice + validates choice
        processChoice();        // Processes the choice and decides what to do next
    }

    // Displays menu to the user
    private void displayMenu(User user) {
        System.out.println("---Mobile Banking for " + user.getForename() + " " + user.getSurname() +"---");   // Displays user name for the menu
        System.out.println("1 >\tOpen New Account");
        System.out.println("2 >\tView All Accounts");
        System.out.println("3 >\tStatements");
        System.out.println("4 >\tTransfer Funds");
        System.out.println("0 >\tLog Out");
        System.out.println();
        System.out.println("Please enter a number from the menu above : ");
    }

    // Take / validate input
    private void userChoice() {
        int choice;         // Holds users choice
        while (true) {      // loop for validation

            // Try, catch to prevent input errors
            try {
                choice = Integer.parseInt(sc.next());   // Takes user input and tries to convert to integer

                // Checks if the user choice is out of range
                if (choice < 0 || choice > 4) {
                    // error message if value is out of range
                    System.out.println("Error! Please enter a valid number from the option above");
                } else {
                    // if user choice is in in range then the choice is returned
                    this.choice = choice;
                    return;
                }
            } catch (Exception e) {
                //
                System.out.println("Error! Please enter a valid number from the option above");
            }
        }
    }

    // Processes the users menu input for what to do next
    private void processChoice() {
        switch (this.choice) {
            case 0:
                System.out.println("Log Out");
                break;
            case 1:
                System.out.println("Open New Account");
                break;
            case 2:
                System.out.println("View All Accounts");
                break;
            case 3:
                System.out.println("View Transactions");
                break;
            case 4:
                System.out.println("Transfer Funds");
                break;
            default:
                // default case for invalid menu input
                // this should never be applicable as validation should already have occurred
                System.out.println("Error! Invalid menu option");
                break;
        }
    }
}
