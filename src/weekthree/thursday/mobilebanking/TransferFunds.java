package weekthree.thursday.mobilebanking;

import java.util.Scanner;

public class TransferFunds {
    // Variable declaration
    private User u;
    private int fromAccount;
    private int toAccount;
    private double transactionAmount;
    Scanner sc = new Scanner(System.in);

    // Constructor
    public TransferFunds(User u) {
        this.u = u;
    }

    // first function ran to transfer funds
    public void performTransfer(){

        ViewAccounts va = new ViewAccounts(u); // creates a new viewaccount function
        va.printAccounts(); // prints all accounts to the user

        // while loop for validation of the selected accounts
        while(true) {
            System.out.println("Which account do you wish to transfer funds from? (Account number): ");
            fromAccount = selectUserAccount();
            System.out.println("Which account do you wish to transfer funds to? (Account number): ");
            toAccount = selectAccount();
            if (fromAccount == toAccount){
                System.out.println("You can't have the same account for sender and recipient.");
                System.out.println("Please try again");
            }else{
                break;
            }
        }

        // calls function to take the transfer amount
        inputTranferAmount();

        // loops over all accounts in the database
        for (Account a : ViewAccounts.accounts) {

            // checks if the account in the loop is the same as the from account
            if (a.getAccountNumber() == fromAccount) {
                a.sendMoney(toAccount, transactionAmount);
            }

        }
    }

    // function to take the user transfer amount
    private void inputTranferAmount() {

        System.out.println("How much do you wish to transfer? : ");
        // while loop for validation
        while (true){
            sc = new Scanner(System.in); // re-initialise scanner
            try{
                transactionAmount = Double.parseDouble(sc.nextLine()); // attempts to parse user input to double

                // checks if the entered value is less than 0
                if (transactionAmount < 0){
                    System.out.println("Please enter a positive value");
                }
                else{
                    break;  // if the input is more than 0 then we break out of the while loop
                }
            }catch (Exception e){
                // exception handles incorrect input
                System.out.println("Please enter a valid value");
            }
        }
    }

    // function to select any accounts in the database
    private int selectAccount(){
        int selectedAccount;

        // while loop for validation
        while (true) {
            sc = new Scanner(System.in); // re-initialises scanner
            try {
                selectedAccount = Integer.parseInt(sc.nextLine()); // attempts to parse user input as Integer
                // for each account in the database
                for (Account a : ViewAccounts.accounts) {
                    // checks if the account in loop is the same as the selected account
                    if (a.getAccountNumber() == selectedAccount) {
                        return selectedAccount; // returns the selected account
                    }

                }
                // if the loop exits then that account does not exists
                System.out.println("That account is not in the database");
            } catch (Exception e) {
                // exception handles incorrect input
                System.out.println("Please enter a valid account number");
            }
        }
    }

    // function to select an account held only by that specific user
    private int selectUserAccount(){
        int selectedAccount;

        // while loop for validation
        while (true) {
            sc = new Scanner(System.in);    // re-initialise scanner
            try {
                selectedAccount = Integer.parseInt(sc.nextLine());
                // for each account held by the user
                for (Integer i : u.getAccountNumbers()) {
                    if (selectedAccount == i) {
                        return selectedAccount;
                    }
                    System.out.println("Please select an account number from the menu above");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid account number");
            }
        }
    }
}
