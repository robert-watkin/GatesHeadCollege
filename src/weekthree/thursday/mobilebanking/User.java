package weekthree.thursday.mobilebanking;

import java.util.ArrayList;

public class User {
    // Variable Declaration
    private String username;
    private String password;
    private String forename;
    private String surname;
    private ArrayList<Integer> accountNumbers;


    // Constructor for variables declared above


    public User(String username, String password, String forename, String surname, ArrayList<Integer> accountNumbers) {
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.accountNumbers = accountNumbers;
    }

    // Getters and setters for variables within this class
    // username
    public String getUsername(){ return username; }
    public void setUsername(String username) {
        this.username = username;
    }

    // password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // forename
    public String getForename() {
        return forename;
    }
    public void setForename(String forename) {
        this.forename = forename;
    }

    // surname
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // AccountNumbers
    public ArrayList<Integer> getAccountNumbers() {
        return accountNumbers;
    }
    public void setAccountNumbers(ArrayList<Integer> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }


    // END OF GETTERS AND SETTERS
}
