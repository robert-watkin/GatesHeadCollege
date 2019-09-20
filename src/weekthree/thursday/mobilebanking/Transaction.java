package weekthree.thursday.mobilebanking;

public class Transaction {
    // Variable Declaration
    private String transactionDate;
    private String transactionPerson;
    private double transactionAmount;

    // Constructor for variables declared above
    public Transaction(String transactionDate, String transactionPerson, double transactionAmount) {
        this.transactionDate = transactionDate;
        this.transactionPerson = transactionPerson;
        this.transactionAmount = transactionAmount;
    }

    // Getters and setters for variables within this class
    // Transaction Date
    public String getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Transaction Person
    public String getTransactionPerson() {
        return transactionPerson;
    }
    public void setTransactionPerson(String transactionPerson) {
        this.transactionPerson = transactionPerson;
    }

    // Transaction Amount
    public double getTransactionAmount() {
        return transactionAmount;
    }
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    // END OF GETTERS AND SETTERS
}
