/*
This class is used throughout the
program to take user input for menu inputs
 */
package weekthree.thursday.mobilebanking;

import java.util.Scanner;

public class UserChoice {
    public static int getChoice(int x){
        int choice;         // Holds users choice
        Scanner scn = new Scanner(System.in);
        while (true) {      // loop for validation

            // Try, catch to prevent input errors
            try {
                choice = Integer.parseInt(scn.next());   // Takes user input and tries to convert to integer

                // Checks if the user choice is out of range
                if (choice < 0 || choice > x) {
                    // error message if value is out of range
                    System.out.println("Error! Please enter a valid number from the option above");
                } else {
                    return choice;
                }
            } catch (Exception e) {
                System.out.println("Error! Please enter a valid number from the option above");
            }
        }
    }
}
