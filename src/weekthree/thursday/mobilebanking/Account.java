/*/////////////////////////////////////////
This function handles account data
 ////////////////////////////////////////*/
package weekthree.thursday.mobilebanking;
import java.util.Date;

import java.util.ArrayList;

public class Account {
    // Variable Declaration
    private String accountName;
    private int accountNumber;
    private double accountBalance;
    private String accountType;
    private ArrayList<Transaction> transactions;


    // Constructor sets all variables declared above
    public Account(int accountNumber, double accountBalance, String accountType, String accountName) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.accountName = accountName;
        transactions = new ArrayList<>();
    }

    // Getters and setters for variables within this class
    // Account Number
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Account Balance
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Account Type
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // Transactions
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    // Account Name
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    // END OF GETTERS & SETTERS

    public void sendMoney(int recipient, double amount){
        if (amount > this.accountBalance){
            System.out.println("Balance to low for specified transfer amount.");
        }
        else{
            this.accountBalance -= amount;
            for (Account a : ViewAccounts.accounts) {
                if (a.getAccountNumber() == recipient) {
                    a.recieveMoney(amount, this.accountNumber);
                    addTransaction(-amount, a.accountNumber);
                }
            }
        }
    }

    public void recieveMoney(double amount, int otherAccount){
        this.accountBalance += amount;
        addTransaction(amount, otherAccount);
    }

    private void addTransaction(double amount, int otherAccount){
        Date today = new Date();
        String date = today.toString();
        String accountName = "";
        for (Account a : ViewAccounts.accounts){
            if (a.accountNumber == otherAccount){
                accountName = a.accountName;
            }
        }
        Transaction t = new Transaction(date, accountName , amount);
        transactions.add(t);
    }
}
