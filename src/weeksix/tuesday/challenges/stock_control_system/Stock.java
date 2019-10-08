/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges.stock_control_system;

public class Stock {
    // Variable Declaration
    private int stockID;
    private int productID;
    private int quantityInStock;
    private int quantityPurchased;
    private int quantityOnOrder;

    // Constructor

    public Stock(int stockID, int productID, int quantityInStock, int quantityPurchased, int quantityOnOrder) {
        this.stockID = stockID;
        this.productID = productID;
        this.quantityInStock = quantityInStock;
        this.quantityPurchased = quantityPurchased;
        this.quantityOnOrder = quantityOnOrder;
    }
}
