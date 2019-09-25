package weekfour.monday.payroll;

import com.sun.tools.javac.Main;
import org.w3c.dom.ls.LSOutput;

import java.text.ParseException;
import java.util.Scanner;

public class LogIn {

    String username;
    String password;
    Scanner sc;

    public static void main(String[] args) throws ParseException {
        LogIn li = new LogIn();
        li.initialise();
        li.start();
    }

    private void initialise() throws ParseException {
        Initialise init = new Initialise();
        init.seedEmployees();
    }

    private void start() throws ParseException {
        welcomeMessage();
        while(true){
            tryLogIn();
        }
    }

    // welcome message for when the application is first opened
    private void welcomeMessage() {
        System.out.println("╔════════════════════╗");
        System.out.println("║     WELCOME TO     ║");
        System.out.println("║     THE PAYROLL    ║");
        System.out.println("║       SYSTEM       ║");
        System.out.println("======================");
    }

    // function called when the user wishes to log in
    private void tryLogIn() throws ParseException {
        sc = new Scanner(System.in);
        System.out.println("Please Enter Your Username: ");
        username = sc.nextLine();
        System.out.println("======================");
        System.out.println("Please Enter Your Password: ");
        password = sc.nextLine();
        System.out.println("======================");

        int counter = 1;
        for (Employee e : Initialise.employees) {
            if (e.getUsername().equalsIgnoreCase(this.username)) {
                if (e.getPassword().equals(this.password)) {
                    openMenu(e);
                    break;
                }
            }
            else if(counter == Initialise.employees.size()) {
                System.out.println("Incorrect Username or Password");
            }
            counter++;
        }
    }

    private void openMenu(Employee e) throws ParseException {
        MainMenu mm = new MainMenu(e);
    }
}
