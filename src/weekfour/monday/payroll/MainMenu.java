package weekfour.monday.payroll;

import javax.swing.text.View;
import java.text.ParseException;
import java.util.Scanner;

public class MainMenu {
    private Employee e;


    public MainMenu(Employee e) throws ParseException {
        this.e = e;
        menu();
    }

    private void menu() throws ParseException {
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

    private void getMainChoice() throws ParseException {
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

    private void holidayMenu() throws ParseException {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║          HOLIDAYS          ║");
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

    private void getHolidayChoice() throws ParseException {
        int choice = 0;
        if (e.isAdmin()) {
            choice = UserChoice.getChoice(5);
        }
        else{
            choice = UserChoice.getChoice(4);
        }
        switch(choice){
            case 1:
                System.out.println("Holiday Entitlement - " + e.getHolidayEntitlement());
                System.out.println("Remaining Holidays - " + e.getRemainingHolidays());
                System.out.println();
                holidayMenu();
                break;
            case 2:
                ViewHolidayRequests vhr = new ViewHolidayRequests();
                vhr.viewFutureHolidays(e);
                holidayMenu();
                break;
            case 3:
                ViewHolidayRequests vph = new ViewHolidayRequests();
                vph.viewPastHolidays(e);
                holidayMenu();
                break;
            case 4:
                CreateHolidayRequest chr = new CreateHolidayRequest();
                chr.createHolidayRequest(e);
                holidayMenu();
                break;
            case 5:
                // TODO Authorise Holiday Request
                AuthoriseHolidays ah = new AuthoriseHolidays();
                ah.authoriseHolidays(e);
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

    private void paymentsMenu() throws ParseException {
        // TODO payment menu
        System.out.println("╔════════════════════════════╗");
        System.out.println("║          PAYMENTS          ║");
        System.out.println("║                            ║");
        System.out.println("║1. View Past Payments       ║");
        System.out.println("║2. View Pending Payments    ║");
        if(e.isAdmin()) {
            System.out.println("║       ADMIN FEATURES       ║");
            System.out.println("║3. Process New Payment      ║");
            System.out.println("║4. Edit Pending Payment     ║");
            System.out.println("║5. View Payment Report      ║");
        }
        System.out.println("║0. Return                   ║");
        System.out.println("==============================");
        getPaymentChoice();
    }

    private void getPaymentChoice() throws ParseException {
        int choice = 0;
        if (e.isAdmin()) {
            choice = UserChoice.getChoice(5);
        }
        else{
            choice = UserChoice.getChoice(2);
        }
        switch(choice){
            case 1:
                ViewPayments vp = new ViewPayments();
                vp.viewPastPayments(e);
                paymentsMenu();
                break;
            case 2:
                ViewPayments vpPending = new ViewPayments();
                vpPending.viewPendingPayments(e);
                paymentsMenu();
                break;
            case 3:
                ProcessNewPayments pnp = new ProcessNewPayments();
                System.out.println("Would you like to process a payment for ALL employees (y/n)");
                Scanner sc = new Scanner(System.in);

                if (sc.nextLine().equalsIgnoreCase("y")) {
                    pnp.createBulkPayment(e);
                }
                else{
                    pnp.createNewPayment(e);
                }
                paymentsMenu();
                break;
            case 4:
                // TODO edit pending payments
                EditPendingPayment epp = new EditPendingPayment();
                epp.editPayments();
                paymentsMenu();
                break;
            case 5:
                ViewPayments vpr = new ViewPayments();
                vpr.viewPaymentReport();
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
