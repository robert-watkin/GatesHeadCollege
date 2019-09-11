package weektwo.tuesday.mobilebanking;

public class User {
    // variable declaration
    /*
     name
     username
     password
     accounts array
    */
    String name;
    String username;
    String password;
    Account[] accounts;
    // End of variable declaration


    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
