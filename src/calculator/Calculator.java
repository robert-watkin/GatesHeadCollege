package calculator;
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
        // new calculator object is created
        Calculator calc = new Calculator();

        // number input is taken by the user from the numberInput function
        calc.num1 = calc.numberInput("first");
        calc.num2 = calc.numberInput("second");

        // operation input is taken by the user from the operatorInput function
        calc.operator = calc.operatorInput();

        // calculation is performed on the previous values inputted
        calc.performCalculation();
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
        System.out.println("what function would you like to carry out? (*,/,+,-) : ");
        String operator;

        // while loop for operation validation
        while(true) {
            operator = sc.next();
            if (operator.equals("*") ||
                operator.equals("/") ||
                operator.equals("+") ||
                operator.equals("-")){
                break;
            }else{
                System.out.println("please enter a valid operation (*,/,+,-)");
            }
        }
        return operator;
    }
    // TODO perform operation

    // this function performs the calculation using the numbers and operations provided
    private void performCalculation(){

        // converts given integers into floating point numbers
        float n1 = this.num1;
        float n2 = this.num2;

        // if statement determines the operation required and carrys it out on the numbers
        if (this.operator.equals("*")){
            System.out.println(n1 + " * " + n2 + " = " + (n1*n2));
        }
        else if (this.operator.equals("/")){
            System.out.println(n1 + " / " + n2 + " = " + (n1/n2));
        }
        else if (this.operator.equals("+")){
            System.out.println(n1 + " + " + n2 + " = " + (n1+n2));
        }
        else if (this.operator.equals("-")){
            System.out.println(n1 + " - " + n2 + " = " + (n1-n2));
        }
    }
}
