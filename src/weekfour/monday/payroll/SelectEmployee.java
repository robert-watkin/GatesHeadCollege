package weekfour.monday.payroll;

import java.util.Scanner;

public class SelectEmployee {
    public Employee selectEmployee() {
        Scanner sc = new Scanner(System.in);
        Employee e;
        int i;
        while(true) {
            try {
                System.out.println("To select an employee, type in their employee number");
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
