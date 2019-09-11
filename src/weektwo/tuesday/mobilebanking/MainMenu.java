package weektwo.tuesday.mobilebanking;
import com.sun.tools.javac.Main;
import java.util.Scanner;

public class MainMenu {

    /*
    hold logged in user
     */
    User user;
    String username;
    String password;
    int choice;
    Scanner sc = new Scanner(System.in);

    public MainMenu(User user) {
        this.user = user;
    }

    public void run(){
        displayMenu();
        userChoice(4);
        processChoice();
    }

    // Display Menu
    private void displayMenu() {
        System.out.println("---Mobile Banking---");
        System.out.println("1 >\tOpen New Account");
        System.out.println("2 >\tView All Accounts");
        System.out.println("3 >\tStatements");
        System.out.println("4 >\tTransfer Funds");
        System.out.println("0 >\tLog Out");
        System.out.println();
        System.out.println("Please enter a number from the menu above : ");
    }

    // Take / validate input
    private void userChoice(int x) {
        int choice;
        while (true) {       // loop for validation
            try {
                choice = Integer.parseInt(sc.next());
                if (choice < 0 || choice > x) {
                    System.out.println("Error! Please enter a valid number from the option above");
                } else {
                    this.choice = choice;
                    return;
                }
            } catch (Exception e) {
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
                System.out.println("Error! Invalid menu option");
                break;
        }
    }
}
