/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges.stock_control_system;

public class Product {
    // Variable Declaration
    private int productID;
    private String name;
    private float price;
    private String description;

    // Constructor

    public Product(int productID, String name, float price, String description) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
