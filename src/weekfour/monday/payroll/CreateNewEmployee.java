package weekfour.monday.payroll;

import java.util.Scanner;

public class CreateNewEmployee {

    int newID;
    String FN;
    String LN;
    String POS;
    String UN;
    String PW;
    float WH;

    public void createEmployee(){
        // set new ID
        setNewID();
        // set first name
        setFirstName();
        // set last name
        setLastName();
        // set position
        setPosition();
        // set username
        setUsername();
        // set password
        setPassword();
        // set working hours
        setWorkingHours();
        Employee newEmployee = new Employee(newID, FN, LN, POS, UN, PW, WH);
        Initialise.employees.add(newEmployee);
    }

    private void setWorkingHours() {
        System.out.println("Please enter the new employees working hours: ");
        Scanner sc;
        while (true){
            try {
                sc = new Scanner(System.in);
                WH = Float.parseFloat(sc.nextLine());
            }
            catch (Exception e){
                System.out.println("ERROR! Please enter a valid number (can be decimal) :");
            }
        }
    }

    private void setPassword() {
        System.out.println("Please enter the new employees password: ");
        Scanner sc = new Scanner(System.in);
        PW = sc.nextLine();
    }

    private void setUsername() {
        System.out.println("Please enter the new employees username: ");
        Scanner sc = new Scanner(System.in);
        UN = sc.nextLine();
    }

    private void setPosition() {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║1. Entry Level              ║");
        System.out.println("║2. Supervisor               ║");
        System.out.println("║3. Payroll                  ║");
        System.out.println("║4. Manager                  ║");
        System.out.println("║5. HR                       ║");
        System.out.println("║6. MD                       ║");
        System.out.println("║0. Cancel                   ║");
        System.out.println("==============================");
        int menuChoice = UserChoice.getChoice(6);
        switch (menuChoice) {
            case 0:
                return;
            case 1:
                POS = "Entry Level";
                break;
            case 2:
                POS = "Supervisor";
                break;
            case 3:
                POS = "Payroll";
                break;
            case 4:
                POS = "Manager";
                break;
            case 5:
                POS = "HR";
                break;
            case 6:
                POS = "MD";
                break;
            default:
                System.out.println("There was an error processing your request,");
                System.out.println("Please try again!");
        }
    }

    private void setLastName() {
        System.out.println("Please enter the new employees surname: ");
        Scanner sc = new Scanner(System.in);
        LN = sc.nextLine();
    }

    private void setFirstName() {
        System.out.println("Please enter the new employees first name: ");
        Scanner sc = new Scanner(System.in);
        UN = sc.nextLine();
    }

    private void setNewID() {
        Employee lastEmployee = Initialise.employees.get(Initialise.employees.size()-1);
        newID = lastEmployee.getEmployeeID() + 1;
    }
}
