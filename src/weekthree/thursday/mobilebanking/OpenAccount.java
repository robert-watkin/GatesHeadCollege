package weekthree.thursday.mobilebanking;

import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Scanner;

public class OpenAccount {

    private String accountType;
    private double depositAmount;
    Scanner sc = new Scanner(System.in);


    public OpenAccount(User u){
        createAccount();
        Integer newAccountNum = 1;
        if (ViewAccounts.accounts.size() > 0) {
            newAccountNum = ViewAccounts.accounts.get(ViewAccounts.accounts.size() - 1).getAccountNumber() + 1;
        }
        Account account = new Account(newAccountNum, depositAmount, accountType, u.getForename() + " " + u.getSurname());
        ViewAccounts.accounts.add(account);
        ArrayList<Integer> updatedAccounts = new ArrayList<>(u.getAccountNumbers());
        updatedAccounts.add(newAccountNum);
        u.setAccountNumbers(updatedAccounts);
    }

    private void createAccount(){
        System.out.println("------------------------------------------");
        System.out.println("What type of account do you wish to open?");
        System.out.println("1 Current Account");
        System.out.println("2 Credit Account");
        System.out.println("3 Cash ISA");
        System.out.println("0 Cancel");
        System.out.println();
        System.out.println("Please enter a number from the menu above :");
        int c = UserChoice.getChoice(3);

        accountType = "";
        switch (c){
            case 0:
                // cancel
                System.out.println("Account creation canceled");
                return;
            case 1:
                accountType = "Current Account";
                break;
            case 2:
                accountType = "Credit Account";
                break;
            case 3:
                accountType = "Cash ISA";
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
        System.out.println("You have selected - " + accountType);
        sc = new Scanner(System.in);
        System.out.println();
        depositAmount = 0.0;
        while (true) {
            try {
                System.out.println("How much would you like to deposit into the account? :");
                System.out.println("Type '0' to leave the account empty");
                depositAmount = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Invalid amount, please try again!");
            }
        }
    }
}
