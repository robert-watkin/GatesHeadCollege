package weekfour.monday.payroll;

import com.sun.tools.javac.Main;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class LogIn {

    String username;
    String password;
    Scanner sc;

    public static void main(String[] args) {
        LogIn li = new LogIn();
        li.initialise();
        li.start();
    }

    private void initialise() {
        Initialise init = new Initialise();
        init.seedEmployees();
    }

    private void start() {
        welcomeMessage();
        while(true){
            tryLogIn();
        }
    }

    private void welcomeMessage() {
        System.out.println("╔════════════════════╗");
        System.out.println("║     WELCOME TO     ║");
        System.out.println("║     THE PAYROLL    ║");
        System.out.println("║       SYSTEM       ║");
        System.out.println("======================");
    }

    private void tryLogIn(){
        sc = new Scanner(System.in);
        System.out.println("Please Enter Your Username: ");
        username = sc.nextLine();
        System.out.println("======================");
        System.out.println("Please Enter Your Password: ");
        password = sc.nextLine();
        System.out.println("======================");

        for (Employee e : Initialise.employees) {
            if (e.getUsername().equalsIgnoreCase(this.username)) {
                if (e.getPassword().equals(this.password)) {
                    openMenu(e);
                    break;
                }
            }
            System.out.println("Incorrect Username or Password");
        }
    }

    private void openMenu(Employee e){
        MainMenu mm = new MainMenu(e);
    }
}
