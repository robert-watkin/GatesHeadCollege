/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges.stock_control_system;

import java.util.ArrayList;

public class Initialise {
    // Variable Declaration - acting as databases
    static ArrayList<Customer> customers;
    static ArrayList<Order> orders;
    static ArrayList<Stock> stock;
    static ArrayList<Product> products;

    public Initialise(){
        Product p1 = new Product(1, "Chair", (float)24.99, "A thing you sit on");
        Product p2 = new Product(2, "Table", (float) 49.99, "A thing you put stuff");
    }
}
