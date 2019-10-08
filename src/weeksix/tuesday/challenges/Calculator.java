/*
Written By : Robert Watkin
Date Created : 08/10/2019
 I HAD ALREADY MADE MOST OF THE CALCULATOR, I HAVE ADDED THE EXTENSION CRITERIA WHICH WAS NOT ORIGINALLY INCLUDED
*/
package weeksix.tuesday.challenges;

import java.util.Scanner;

public class Calculator {

    // variable declaration
    private int num1;
    private int num2;
    private String operator;

    // scanner object created
    Scanner sc = new Scanner(System.in);

    // main function - called when the program is run
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.start();
    }

    private void start(){
        // new calculator object is created


        // number input is taken by the user from the numberInput function
        num1 = numberInput("First Number");


        // operation input is taken by the user from the operatorInput function
        operator = operatorInput();

        // number input is taken by the user from the numberInput function
        if (!operator.equalsIgnoreCase("root")) {
            num2 = numberInput("Second Number");
        }else{
            num2 = 0;
        }

        // calculation is performed on the previous values inputted
        performCalculation();
    }
    // This function takes the number input from the user and validates that input
    private int numberInput(String numDisplay){

        System.out.println("please enter the " + numDisplay + " number : ");
        int num;
        while (true){
            try {
                num = Integer.parseInt(sc.next());
                return num;
            } catch (Exception e) {
                System.out.println("please enter a valid number");
                num = 0;
            }
        }
    }

    // This function takes the operator input from the user and validates that input
    private String operatorInput(){
        System.out.println("what function would you like to carry out? (*,/,+,-,^,root) : ");
        String operator;

        // while loop for operation validation
        label:
        while(true) {
            operator = sc.next();
            switch (operator) {
                case "*":
                case "/":
                case "+":
                case "-":
                case "^":
                case "root":
                    break label;
                default:
                    System.out.println("please enter a valid operation (*,/,+,-,^,root)");
                    break;
            }
        }
        return operator;
    }
    // TODO perform operation

    // this function performs the calculation using the numbers and operations provided
    private void performCalculation(){

        // converts given integers into floating point numbers
        float n1 = num1;
        float n2 = num2;

        // switch statement determines the operation required and carries it out on the numbers

        switch (this.operator) {
            case "*":
                System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
                break;
            case "/":
                System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
                break;
            case "+":
                System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
                break;
            case "-":
                System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
                break;
            case "^":
                System.out.println(n1 + "^" + n2 + " = " + (Math.pow(n1,n2)));
                break;
            case "root":
                System.out.println("root of " + n1 + " = " + (Math.sqrt(n1)));

        }
    }
}
