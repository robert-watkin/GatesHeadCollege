package weekthree.thursday.mobilebanking;

import java.util.Scanner;

public class TransferFunds {
    private User u;
    private int fromAccount;
    private int toAccount;
    private double transactionAmount;

    public TransferFunds(User u) {
        this.u = u;
    }

    public void performTransfer(){
        ViewAccounts va = new ViewAccounts(u);
        va.printAccounts();
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

        inputTranferAmount();

        for (Account a : ViewAccounts.accounts) {

            if (a.getAccountNumber() == fromAccount) {
                a.sendMoney(toAccount, transactionAmount);
            }

        }
    }

    private void inputTranferAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much do you wish to transfer? : ");
        while (true){
            try{
                transactionAmount = Double.parseDouble(sc.nextLine());
                if (transactionAmount < 0){
                    System.out.println("Please enter a positive value");
                }
                else{
                    break;
                }
            }catch (Exception e){
                System.out.println("Please enter a valid value");
            }
        }
    }

    private int selectAccount(){
        Scanner sc = new Scanner(System.in);
        int selectedAccount;
        while (true) {
            try {
                selectedAccount = Integer.parseInt(sc.nextLine());
                for (Account a : ViewAccounts.accounts) {

                    if (a.getAccountNumber() == selectedAccount) {
                        return selectedAccount;
                    }

                }
                System.out.println("That account is not in the database");
            } catch (Exception e) {
                System.out.println("Please enter a valid account number");
            }
        }
    }

    private int selectUserAccount(){
        Scanner sc = new Scanner(System.in);
        int selectedAccount;
        while (true) {
            try {
                selectedAccount = Integer.parseInt(sc.nextLine());
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
