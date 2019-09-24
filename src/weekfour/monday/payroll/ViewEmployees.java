package weekfour.monday.payroll;

import java.util.Scanner;

public class ViewEmployees {
    // Prints all employees in the system with minimal info
    public void printAllEmployees(){
        System.out.println("=============================");
        for (Employee e : Initialise.employees){
            System.out.println("Employee " + e.getEmployeeID() + "; Name: " + e.getFirstName() + " " + e.getLastName());
        }
        printEmployeeDetails();
    }

    public void printEmployeeDetails(){
        System.out.println("=============================");
        SelectEmployee se = new SelectEmployee();
        Employee e = se.selectEmployee();
        if (e == null){
            return;
        }
        System.out.println("-------Employee " + e.getEmployeeID() + "-------");
        System.out.println("Name \t\t\t\t\t>> " + e.getFirstName() + " " + e.getLastName());
        System.out.println("Username \t\t\t\t>> " + e.getUsername());
        System.out.println("Holiday Entitlement \t>> " + Math.round(e.getHolidayEntitlement()));
        System.out.println("Position\t\t\t\t>> " + e.getPosition());
        System.out.println("Contracted Hours \t\t>> " + e.getWorkingHours());

        System.out.println("===========================");
        System.out.println("Enter anything to continue");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

    }
}
