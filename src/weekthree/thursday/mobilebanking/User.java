package weekthree.thursday.mobilebanking;

import java.util.ArrayList;

public class User {
    // variable declaration
    /*
     name
     username
     password
     accounts array
    */
    private String username;
    private String password;
    private String forename;
    private String surname;
    ArrayList<Account> accounts;
    // End of variable declaration


    public User(String username, String password, String username1, String password1, ArrayList<Account> accounts) {
        this.username = username;
        this.password = password;
        this.username = username1;
        this.password = password1;
        this.accounts = accounts;
    }

    public String getUsername(){ return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
