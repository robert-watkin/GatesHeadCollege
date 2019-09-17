package weekthree.tuesday.constructor;

public class User {

    // MEMBER VARIABLES
    private String username;    // *
    private String password;    // *
    private byte age;
    private String forename;
    private String surname;
    private long phoneNumber;   // *
    private boolean gender;        // *
    // MEMBER VARIABLES

    // required constructor
    public User(String username, String password, long phoneNumber, boolean gender) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }


}
