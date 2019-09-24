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
        Employee e = takeEmployeeID();
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

    private Employee takeEmployeeID() {
        Scanner sc = new Scanner(System.in);
        Employee e;
        int i;
        while(true) {
            try {
                System.out.println("To view an employees details, type in their employee number");
                System.out.println("Enter 0 to return to Employee Menu");
                i = Integer.parseInt(sc.nextLine());
                break;
            }
            catch (Exception exception){
                System.out.println("Please enter a valid number");
            }
        }

        int counter = 1;
        for (Employee emp : Initialise.employees){
            if (emp.getEmployeeID() == i){
                e = emp;
                return e;
            }
            else if(counter == Initialise.employees.size()){
                System.out.println("This employee could not be found in the database!");
                return null;
            }
        }
        return null;
    }
}
