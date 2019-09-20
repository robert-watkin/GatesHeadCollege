package weekthree.thursday.mobilebanking;

import java.util.ArrayList;
import java.util.Scanner;

public class LogIn {

    String username;
    String password;
    ArrayList<User> users;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LogIn li = new LogIn();
        li.initialise();
        li.loginUser();
    }

    private void initialise(){
        Initialise init = new Initialise(users);
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

        //for all users
        int counter = 1;
        for (User u : users){
            if (this.username.equalsIgnoreCase(u.getUsername())){
                if (this.password.equals(u.getPassword())){
                    openMenu(u);
                } else{
                    System.out.println("Password Incorrect");
                    loginUser();
                }
            } else if(counter == users.size()){
                System.out.println("Username or Password is incorrect");
                loginUser();
            }
            counter++;
        }
    }

    private void openMenu(User u){
        MainMenu menu = new MainMenu(u);
        menu.run();
    }
}
