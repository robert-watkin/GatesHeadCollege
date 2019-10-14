/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges.stock_control_system;

import weekfour.monday.payroll.Employee;
import weekfour.monday.payroll.Initialise;
import weekfour.monday.payroll.MainMenu;

import java.text.ParseException;
import java.util.Scanner;

public class LogIn {
    Scanner sc;
    public static void main(String[] args) throws ParseException {
        LogIn li = new LogIn();
        li.initialise();
        li.start();
    }

    private void initialise() throws ParseException {
        Initialise init = new Initialise();
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
        System.out.println("║   WELCOME TO THE   ║");
        System.out.println("║  STOCK MANAGEMENT  ║");
        System.out.println("║       SYSTEM       ║");
        System.out.println("======================");
    }

    // function called when the user wishes to log in
    private void tryLogIn() {
        sc = new Scanner(System.in);
        /*
            USERNAME : ADMIN
            PASSWORD : Password12
         */

        System.out.println("Please Enter Your Username: ");
        String username = sc.nextLine();
        System.out.println("======================");
        System.out.println("Please Enter Your Password: ");
        String password = sc.nextLine();
        System.out.println("======================");

        if (username.equalsIgnoreCase("admin") && password.equals("Password12")){
            openMenu();
        }
    }

    private void openMenu(){
        MainMenu mm = new MainMenu();
    }
}
