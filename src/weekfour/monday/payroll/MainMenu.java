package weekfour.monday.payroll;

public class MainMenu {
    private Employee e;


    public MainMenu(Employee e) {
        this.e = e;
        menu();
    }

    private void menu(){
        System.out.println("╔════════════════════════════╗");
        if (e.isAdmin()) {
            System.out.println("║            ADMIN           ║");
        } else {
            System.out.println("║        STANDARD MENU       ║");
        }
        System.out.println("║                            ║");
        System.out.println("║1. Payments                 ║");
        System.out.println("║2. Holidays                 ║");
        if(e.isAdmin()) {
            System.out.println("║       ADMIN FEATURES       ║");
            System.out.println("║3. Employees                ║");
        }
        System.out.println("║0. Log Out                  ║");
        System.out.println("==============================");
        getMainChoice();
    }

    private void getMainChoice() {
        int choice = 0;
        if (e.isAdmin()) {
            choice = UserChoice.getChoice(3);
        } else {
            choice = UserChoice.getChoice(2);
        }
        switch(choice){
            case 1:
                paymentsMenu();
                menu();
                break;
            case 2:
                holidayMenu();
                menu();
                break;
            case 3:
                employeeMenu();
                menu();
                break;
            case 0:
                System.out.println("=================");
                System.out.println("---LOGGING OUT---");
                System.out.println("=================");
                break;
            default:
                System.out.println("ERROR! Invalid Option.");
                break;
        }
    }

    private void employeeMenu() {
        // TODO employee menu
        System.out.println("╔════════════════════════════╗");
        System.out.println("║         EMPLOYEES          ║");
        System.out.println("║                            ║");
        System.out.println("║1. View Employees           ║");
        System.out.println("║2. Edit Employee Details    ║");
        System.out.println("║3. Create New Employee      ║");
        System.out.println("║0. Return                   ║");
        System.out.println("==============================");
        getEmployeeChoice();
    }

    private void getEmployeeChoice() {
        int choice = 0;
        choice = UserChoice.getChoice(3);
        switch(choice){
            case 1:
                viewEmployees();
                employeeMenu();
                break;
            case 2:
                EditEmployeeDetails eed = new EditEmployeeDetails(e);
                eed.editEmployeeDetails();
                employeeMenu();
                break;
            case 3:
                CreateNewEmployee cne = new CreateNewEmployee();
                cne.createEmployee();
                break;
            case 0:
                System.out.println("==================");
                System.out.println("--RETURN TO MENU--");
                System.out.println("==================");
                break;
            default:
                System.out.println("ERROR! Invalid Option.");
                break;
        }
    }

    private void viewEmployees() {
        ViewEmployees ve = new ViewEmployees();
        ve.printAllEmployees();
    }

    private void holidayMenu() {
        // TODO holiday menu
        System.out.println("╔════════════════════════════╗");
        System.out.println("║          PAYMENTS          ║");
        System.out.println("║                            ║");
        System.out.println("║1. Check Holiday Balance    ║");
        System.out.println("║2. View Holiday Requests    ║");
        System.out.println("║3. View Previous Holidays   ║");
        System.out.println("║4. Create Holiday Request   ║");

        if(e.isAdmin()) {
            System.out.println("║       ADMIN FEATURES       ║");
            System.out.println("║5. Authorise Requests       ║");
        }
        System.out.println("║0. Return                   ║");
        System.out.println("==============================");
        getHolidayChoice();
    }

    private void getHolidayChoice() {
        int choice = 0;
        if (e.isAdmin()) {
            choice = UserChoice.getChoice(5);
        }
        else{
            choice = UserChoice.getChoice(4);
        }
        switch(choice){
            case 1:
                // TODO Check Holiday Balance
                holidayMenu();
                break;
            case 2:
                // TODO View Holiday Requests
                holidayMenu();
                break;
            case 3:
                // TODO View Previous Holidays
                holidayMenu();
                break;
            case 4:
                // TODO Create holiday request
                holidayMenu();
                break;
            case 5:
                // TODO Authorise Holiday Request
                holidayMenu();
                break;
            case 0:
                System.out.println("==================");
                System.out.println("--RETURN TO MENU--");
                System.out.println("==================");
                break;
            default:
                System.out.println("ERROR! Invalid Option.");
                break;
        }
    }

    private void paymentsMenu() {
        // TODO payment menu
        System.out.println("╔════════════════════════════╗");
        System.out.println("║          PAYMENTS          ║");
        System.out.println("║                            ║");
        System.out.println("║1. View Past Payments       ║");
        System.out.println("║2. View Pending Payments     ║");
        if(e.isAdmin()) {
            System.out.println("║       ADMIN FEATURES       ║");
            System.out.println("║3. Process New Payment      ║");
            System.out.println("║4. Edit Pending Payment     ║");
        }
        System.out.println("║0. Return                   ║");
        System.out.println("==============================");
        getPaymentChoice();
    }

    private void getPaymentChoice() {
        int choice = 0;
        if (e.isAdmin()) {
            choice = UserChoice.getChoice(4);
        }
        else{
            choice = UserChoice.getChoice(2);
        }
        switch(choice){
            case 1:
                // TODO view past payments
                paymentsMenu();
                break;
            case 2:
                // TODO view pending payments
                paymentsMenu();
                break;
            case 3:
                // TODO process new payments
                paymentsMenu();
                break;
            case 4:
                // TODO edit pending payments
                paymentsMenu();
                break;
            case 0:
                System.out.println("==================");
                System.out.println("--RETURN TO MENU--");
                System.out.println("==================");
                break;
            default:
                System.out.println("ERROR! Invalid Option.");
                break;
        }
    }
}
