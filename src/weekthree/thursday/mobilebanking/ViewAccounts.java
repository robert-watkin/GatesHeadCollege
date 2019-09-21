/*/////////////////////////////////////////
This function handles account viewing
including  the options available for the
accounts once selected
Also holds all created accounts in an arrayList
 ////////////////////////////////////////*/
package weekthree.thursday.mobilebanking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ViewAccounts {
    // hold all accounts
    static ArrayList<Account> accounts = new ArrayList<>();
    // String account type
    private User u;
    private int selectedAccount;

    // Constructor takes the current logged in user
    public ViewAccounts(User u) {
        this.u = u;
    }

    // function to view the accounts held by the user
    public void viewAccounts(){
        // checks if the user has 0 accounts
        if (u.getAccountNumbers().size() == 0){
            // asks the user if they want to create a new account
            System.out.println("You currently don't have any accounts.");
            System.out.println("Do you wish to create an account? (y/n):");
            Scanner sc = new Scanner(System.in);    // creates a new scanner object
            String choice = sc.nextLine();      // takes the user input and stores it in input

            // checks to see if the user wants to create a new account
            if (choice.equalsIgnoreCase("y")){
                OpenAccount oa = new OpenAccount(u); // initialises class to create a new account
            } else {
                return; // if no account is created, the program will return to the menu
            }
        }
        printAccounts();
        selectAccount();
        accountMenu();
    }

    // This function is used to show all transactions for all accounts held by the logged in user
    public void showAllTransactions(){
        System.out.println();
        // for each loop over all accounts
        for (int i : u.getAccountNumbers()){
            System.out.println("For account : " + i); // specifies the current account
            selectedAccount = i;
            viewTransactions(); // calls the function to print transactions
        }
    }

    // this function is used to select an account which the user holds
    private void selectAccount() {
        Scanner sc = new Scanner(System.in);

        // asks for account number
        System.out.println("Select an account by account number : ");
        boolean valid = false;
        while (true) {
            try {
                selectedAccount = Integer.parseInt(sc.nextLine());
                for (Account a : accounts) {
                    if (a.getAccountNumber() == selectedAccount) {
                        valid = true;
                        break;
                    }
                }
                if (valid){break;}
                System.out.println("Please select an account number from the menu above");
            } catch (Exception e) {
                System.out.println("Please enter a valid account number");
            }
        }
    }

    private void accountMenu() {
        while(true) {
            System.out.println();
            System.out.println("Account " + selectedAccount + " selected");
            System.out.println("1 - Close Account");
            System.out.println("2 - View Transactions");
            System.out.println("0 - Return to Main Menu");

            int c = UserChoice.getChoice(2);

            switch (c) {
                case 0:
                    return;
                case 1:
                    closeAccount();
                    return;
                case 2:
                    // view transactions
                    viewTransactions();
                    break;
            }
        }
    }

    // calls the closeaccount class to close the relevant account
    private void closeAccount() {
        CloseAccount.closeAccount(u, selectedAccount);
    }

    // function prints out transactions related to a specific account
    private void viewTransactions(){
        // loops over accounts
        for (Account a : accounts) {
            // if the current account being looped over is equal to the selected account
            if (a.getAccountNumber() == selectedAccount){
                // check if there are 0 transactions to show
                if (a.getTransactions().size() == 0){
                    System.out.println("There are no transactions to show!");   // tell user there are no transactions
                    return; // return to where function was called from
                }
                // loop over all transactions on account
                for (Transaction t : a.getTransactions()){
                    // print out the transaction details
                    System.out.println("Transaction Date : " + t.getTransactionDate() +
                                        "; Transaction Person : " + t.getTransactionPerson() +
                                        "; Transaction Amount : " + t.getTransactionAmount());
                }
            }
        }
    }

    // this function prints out the details of the accounts for the user
    public void printAccounts() {
        // loops over all accounts
        for (Account a : accounts) {
            // for loop for the amount of accounts the logged in user has
            for (int x = 0; x < u.getAccountNumbers().size(); x++) {
                // checks if the account number is the same as any of the users accounts
                if (a.getAccountNumber() == u.getAccountNumbers().get(x)) {
                    // prints out account details
                    System.out.println("Account Number : " + a.getAccountNumber() +
                                        "; Account Balance :" + a.getAccountBalance() +
                                        "; Account Type : " + a.getAccountType());
                }
            }
        }
    }
}
