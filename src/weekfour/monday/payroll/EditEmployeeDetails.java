package weekfour.monday.payroll;

import java.util.Scanner;

public class EditEmployeeDetails {
    private Employee e;
    private Employee loggedIn;

    public EditEmployeeDetails(Employee loggedIn){
        this.loggedIn = loggedIn;
    }

    // selectEmployee
    public void editEmployeeDetails(){
        SelectEmployee se = new SelectEmployee();
        e = se.selectEmployee();
        if (e.equals(loggedIn)){
            System.out.println("You cannot change your own details!");
            return;
        }

        menuAndChoice();
    }

    private void menuAndChoice() {
        editEmployeeMenu();
        int choice = UserChoice.getChoice(6);
        switch (choice){
            case 0:
                break;
            case 1:
                editValue("fn");
                menuAndChoice();
                break;
            case 2:
                editValue("sn");
                menuAndChoice();
                break;
            case 3:
                editValue("pos");
                menuAndChoice();
                break;
            case 4:
                editValue("un");
                menuAndChoice();
                break;
            case 5:
                editValue("pw");
                menuAndChoice();
                break;
            case 6:
                menuAndChoice();
                break;
        }
    }

    private void editValue(String valueToChange) {
        Scanner sc = new Scanner(System.in);
        String change = "0";
        if (valueToChange != "pos") {
            change = sc.nextLine();
        }
        try {
            switch (valueToChange) {
                case "0":
                    return;
                case "fn":
                    e.setFirstName(change);
                    break;
                case "sn":
                    e.setLastName(change);
                    break;
                case "pos":
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
                    switch (menuChoice){
                        case 0:
                            return;
                        case 1:
                            e.setPosition("Entry Level");
                            break;
                        case 2:
                            e.setPosition("Supervisor");
                            break;
                        case 3:
                            e.setPosition("Payroll");
                            break;
                        case 4:
                            e.setPosition("Manager");
                            break;
                        case 5:
                            e.setPosition("HR");
                            break;
                        case 6:
                            e.setPosition("MD");
                            break;
                        default:
                            System.out.println("There was an error processing your request,");
                            System.out.println("Please try again!");
                    }

                    break;
                case "un":
                    e.setUsername(change);
                    break;
                case "pw":
                    e.setPassword(change);
                    break;
                case "wh":
                    e.setWorkingHours(Float.parseFloat(change));
                    break;
                default:
                    System.out.println("There was an error processing your request,");
                    System.out.println("Please try again!");
            }
        } catch (Exception exception){
            System.out.println("There was an error processing your request,");
            System.out.println("Please try again!");
        }
    }

    private void editEmployeeMenu() {
        int sideValue = 28 - e.getFirstName().length();
        String gap = "";
        if (sideValue > 1){
            for (int i = 0; i < (sideValue/2); i++){
                gap += " ";
            }
        }
        System.out.println("╔════════════════════════════╗");
        System.out.println("║" + gap + e.getFirstName() + gap + "║"); // 28
        System.out.println("║                            ║");
        System.out.println("║1. Edit Forename            ║");
        System.out.println("║2. Edit Surname             ║");
        System.out.println("║3. Edit Position            ║");
        System.out.println("║4. Edit Username            ║");
        System.out.println("║5. Edit Password            ║");
        System.out.println("║6. Edit Working Hours       ║");
        System.out.println("║0. Return                   ║");
        System.out.println("==============================");
    }
}
