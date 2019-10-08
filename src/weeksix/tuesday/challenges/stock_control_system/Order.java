/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges.stock_control_system;

import java.util.Date;

public class Order {
    // Variable Declaration
    private int orderID;
    private int customerID;
    private int quantity;
    private Date orderDate;

    // Constructor

    public Order(int orderID, int customerID, int quantity, Date orderDate) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }
}
