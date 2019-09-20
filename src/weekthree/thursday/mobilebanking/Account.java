package weekthree.thursday.mobilebanking;


import java.util.ArrayList;

public class Account {
    // Variable Declaration
    private int accountNumber;
    private double accountBalance;
    private String accountType;
    private ArrayList<Transaction> transactions;


    // Constructor sets all variables declared above
    public Account(int accountNumber, double accountBalance, String accountType, ArrayList<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.transactions = transactions;
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
    // END OF GETTERS & SETTERS
}
