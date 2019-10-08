/*
Written By : Robert Watkin
Date Created : 08/10/2019
*/
package weeksix.tuesday.challenges;

import java.util.Scanner;

public class MultiplicationTables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startPoint = 0;
        int endPoint = 0;
        int mult = 0;
        while (true) {
            try {
                System.out.println("Start point : ");
                startPoint = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Please enter a valid number");
            }
        }

        while (true) {
            try {
                System.out.println("End point : ");
                endPoint = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Please enter a valid number");
            }
        }

        while (true) {
            try {
                System.out.println("multiplication : ");
                mult = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Please enter a valid number");
            }
        }

        System.out.println();

        for (int x = startPoint; x < endPoint; x++){
            System.out.println(x + " x " + mult + " = " + (x*mult));
        }
    }
}
