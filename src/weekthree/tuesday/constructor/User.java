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

    public User(String username, String password, byte age, String forename, String surname, long phoneNumber, boolean gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.forename = forename;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    private void printValues(){
        System.out.println("Full Name : " + this.forename + this.surname);
        System.out.println("Username : " + this.username);
        System.out.println("Password : " + this.password);
        System.out.println("Age : " + this.age);
        System.out.println("Phone number " + this.phoneNumber);
        System.out.println("Gender : " + this.gender);
    }
}
