/*/////////////////////////////////////////
This function handles account deletion
 ////////////////////////////////////////*/

package weekthree.thursday.mobilebanking;

import java.util.Iterator;
import java.util.Scanner;

public class CloseAccount {
    static void closeAccount(User u, int selectedAccount){
        Scanner sc = new Scanner(System.in);    // new instance of scanner

        // created an iterator for account. This allows the original value to be deleted as opposed to a for each loop
        Iterator<Account> i = ViewAccounts.accounts.iterator();

        // while there is a value next in the arrayList
        while (i.hasNext()) {
            // set a to the next value in the arrayList
            Account a = i.next();
            if (a.getAccountNumber() == selectedAccount){
                // checks if the account balance is mor than zero
                if (a.getAccountBalance() > 0){
                    // if the balance is more than 0 then they cant close their account
                    System.out.println("You are unable to close this account,");
                    System.out.println("The account balance must be 0");
                    System.out.println();
                    System.out.println("Do you wish to transfer funds to another account (y/n)");
                    String choice = sc.nextLine();  // user is asked if they want to transfer funds out of their account
                    if (choice.equalsIgnoreCase("y")){
                        // if yes they are taken to the transferfunds class
                        TransferFunds tf = new TransferFunds(u);
                        tf.performTransfer();
                        return; // returns back to the function call
                    }
                    else { return; } // returns back to the function call
                }
                System.out.println("Are you sure you want to close this account? (y/n) : ");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("y")){
                    i.remove();
                    u.getAccountNumbers().remove(Integer.valueOf(selectedAccount));
                }
            }
        }
    }

}
