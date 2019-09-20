package weekthree.thursday.mobilebanking;

import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {
    // Variable Declaration
    String username;
    String password;
    ArrayList<User> users;
    Scanner sc = new Scanner(System.in);

    // Main function called at the start of the program
    // Entry point for the program
    public static void main(String[] args) {
        LogIn li = new LogIn();
        li.initialise();
        li.loginUser();
    }

    // initialise function is used to populate data in the program
    private void initialise(){
        Initialise init = new Initialise();     // initialises new instance of Initialise object
        users = init.seedData();                // the seed data function is called to populate the users arraylist
    }


    // method loginUser -->
    private void loginUser() {
        //ask for username
        System.out.println("---------------------");
        System.out.println("Username : ");
        //username input
        this.username = sc.nextLine();
        //ask for password
        System.out.println("Password : ");
        //password input
        this.password = sc.nextLine();

        //counter integer for loop
        int counter = 1;
        // loops for all objects (User) within the user arraylist
        for (User u : users){

            // checks if the inputted username is the same as the current User in the loop
            if (this.username.equalsIgnoreCase(u.getUsername())){

                // checks if the password entered is the same as the current User in the loop
                if (this.password.equals(u.getPassword())){
                    openMenu(u);    // calls open menu and passes through the current user
                    loginUser();
                    break;
                } else{
                    System.out.println("Password Incorrect");   // incorrect password error message
                    loginUser();    // calls the login user function again
                    break;
                }
            } else if(counter == users.size()){     // if the counter is the same as the length of the ArrayList
                System.out.println("Username or Password is incorrect");    // output incorrect information message
                loginUser();    // calls the login function again
                break;
            }
            counter++; // increments the counter at the end of the loop
        }
    }

    // Function is used to run the main method
    private void openMenu(User u){
        MainMenu menu = new MainMenu(u);
        menu.run();
    }
}
