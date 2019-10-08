/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges.stock_control_system;

public class Customer {
    // Variable Declaration
    private int customerID;
    private String forename;
    private String surname;
    private int age;
    private String email;
    private int[] orderIDs;

    // Constructor

    public Customer(int customerID, String forename, String surname, int age, String email, int[] orderIDs) {
        this.customerID = customerID;
        this.forename = forename;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.orderIDs = orderIDs;
    }
}
