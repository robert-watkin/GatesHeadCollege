package weektwo.tuesday.mobilebanking;
import java.util.Scanner;

public class LogIn {

    String username;
    String password;
    User[] users = new User[4];
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LogIn li = new LogIn();
        li.initialise();
        li.loginUser();
    }

    private void initialise(){
        users[0] = new User("Robert Watkin", "robby1110", "Password1");
        users[1] = new User("Amanda Rae", "amxnda", "Jessica1");
        users[2] = new User("Robert Watkin", "potatoman", "shoeLace");
        users[3] = new User("Robert Watkin", "afganDan", "radge");
    }

    // method loginUser -->
    private void loginUser() {
        //ask for username
        System.out.println("Username : ");
        //username input
        this.username = sc.nextLine();
        //ask for password
        System.out.println("Password : ");
        //password input
        this.password = sc.nextLine();

        /*
        if (username = "robby1110") {
            if (password = "yaNan") {
                MainMenu menu = new MainMenu();
                menu.run();
            }
        }

         */

        //for all users

        for (int x = 0; x < users.length; x++){
            if (this.username.equalsIgnoreCase(users[x].username)){
                if (this.password.equals(users[x].password)){
                    MainMenu menu = new MainMenu(users[x]);
                    menu.run();
                } else{
                    System.out.println("Username or Password Incorrect");
                    loginUser();
                }
            } else {
                System.out.println("Username or Password is incorrect");
            }
        }

    }
}
