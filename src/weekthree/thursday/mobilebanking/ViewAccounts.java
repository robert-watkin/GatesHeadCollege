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

    public ViewAccounts(User u) {
        this.u = u;
    }

    public void viewAccounts(){
        if (u.getAccountNumbers().size() == 0){
            System.out.println("You currently don't have any accounts.");
            System.out.println("Do you wish to create an account? (y/n):");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y")){
                OpenAccount oa = new OpenAccount(u);
            }
            return;
        }
        printAccounts();
        selectAccount();
        accountMenu();
    }

    public void showAllTransactions(){
        for (int i : u.getAccountNumbers()){
            selectedAccount = i;
            viewTransactions();
        }
    }

    private void selectAccount() {
        Scanner sc = new Scanner(System.in);

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

    private void closeAccount() {
        Scanner sc = new Scanner(System.in);
        Iterator<Account> i = accounts.iterator();
        while (i.hasNext()) {
            Account a = i.next();
            if (a.getAccountNumber() == selectedAccount){
                if (a.getAccountBalance() > 0){
                    System.out.println("You are unable to close this account,");
                    System.out.println("The account balance must be 0");
                    System.out.println();
                    System.out.println("Do you wish to transfer funds to another account (y/n)");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("y")){
                        TransferFunds tf = new TransferFunds(u);
                        tf.performTransfer();
                        return;
                    }
                    else { return; }
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

    private void viewTransactions(){
        for (Account a : accounts) {
            if (a.getAccountNumber() == selectedAccount){
                if (a.getTransactions().size() == 0){
                    System.out.println("There are no transactions to show!");
                    return;
                }
                for (Transaction t : a.getTransactions()){
                    System.out.println("Transaction Date : " + t.getTransactionDate() + "; Transaction Person : " + t.getTransactionPerson() + "; Transaction Amount : " + t.getTransactionAmount());
                }
            }
        }
    }

    public void printAccounts() {
        for (Account a : accounts) {
            for (int x = 0; x < u.getAccountNumbers().size(); x++) {
                if (a.getAccountNumber() == u.getAccountNumbers().get(x)) {
                    System.out.println("Account Number : " + a.getAccountNumber() + "; Account Balance :" + a.getAccountBalance() + "; Account Type : " + a.getAccountType());
                }
            }
        }
    }
}
