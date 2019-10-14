/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges.stock_control_system;

import java.util.Scanner;

public class MainMenu {
    public MainMenu() {
        upperMenu();
    }

    private void upperMenu(){
        System.out.println("================");
        System.out.println("1 - Stock");
        System.out.println("2 - Product");
        System.out.println("3 - Order");
        System.out.println("4 - Customer");
        System.out.println("0 - LogOut");
        System.out.println("Enter a number from the menu above");
        int choice = takeChoice(4);
        switch (choice){
            case 0:
                break;
            case 1:
                stockMenu();
                upperMenu();
                break;
            case 2:
                productMenu();
                upperMenu();
                break;
            case 3:
                orderMenu();
                upperMenu();
                break;
            case 4:
                customerMenu();
                upperMenu();
                break;
            default:
                System.out.println("invalid menu choice");
        }
    }

    private void customerMenu() {
        System.out.println("================");
        System.out.println("1 - OrderStock");
        System.out.println("2 - View All Stock");
        System.out.println("3 - View Individual Item Stock");
        System.out.println("0 - return");
        System.out.println("Enter a number from the menu above");
        int choice = takeChoice(3);
        switch (choice){
            case 0:
                break;
            case 1:
                // TODO order stock - OrderStock
                break;
            case 2:
                // TODO view all stock - ViewStock
                break;
            case 3:
                // TODO view individual items stock - ViewStock
                break;
            default:
                System.out.println("invalid menu choice");
        }
    }

    private void productMenu() {
        System.out.println("================");
        System.out.println("1 - Add New Product");
        System.out.println("2 - Remove Product");
        System.out.println("3 - Edit Product");
        System.out.println("0 - return");
        System.out.println("Enter a number from the menu above");
        int choice = takeChoice(3);
        switch (choice){
            case 0:
                break;
            case 1:
                // TODO add new product - AddNewProduct
                break;
            case 2:
                // TODO remove product - RemoveProduct
                break;
            case 3:
                // TODO Edit existing product - EditProduct
                break;
            default:
                System.out.println("invalid menu choice");
        }
    }

    private void orderMenu() {
        System.out.println("================");
        System.out.println("1 - Create New Order");
        System.out.println("2 - Remove Product");
        System.out.println("3 - Edit Product");
        System.out.println("0 - return");
        System.out.println("Enter a number from the menu above");
        int choice = takeChoice(3);
        switch (choice){
            case 0:
                break;
            case 1:
                // TODO add new product - AddNewProduct
                break;
            case 2:
                // TODO remove product - RemoveProduct
                break;
            case 3:
                // TODO Edit existing product - EditProduct
                break;
            default:
                System.out.println("invalid menu choice");
        }
    }

    private void stockMenu() {
    }

    private int takeChoice(int x){
        Scanner sc;
        while (true){
            sc = new Scanner(System.in);
            try{
                int i = Integer.parseInt(sc.nextLine());
                if (i <= x && x >= 0){
                    break;
                }
                System.out.println("Please enter a valid number between 0 and " + x);
            } catch (Exception e){
                System.out.println("Please enter a valid number between 0 and " + x);
            }
        }
    }
}
