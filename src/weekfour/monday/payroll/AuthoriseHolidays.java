package weekfour.monday.payroll;

import java.util.Scanner;


public class AuthoriseHolidays {

    int holidayID;

    public void authoriseHolidays(Employee e){
        ViewHolidayRequests vhr = new ViewHolidayRequests();
        vhr.viewAllFutureHolidays();
        takeID();

        String tf = "";
        // loop holiday
        for (HolidayRequest h : Initialise.holidayRequests) {
            // check if holiday is the same as requested
            if (h.getHolidayRequestID() == holidayID){
                // validation loop
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Set authorised to true or false? (t/f) :");
                    tf = sc.nextLine();
                    if (tf.equalsIgnoreCase("t")){
                        if(h.isApproved()) {
                            System.out.println("This holiday is already approved");
                            break;
                        }else {
                            h.setApproved(true);
                            for (Employee actualEmployee : Initialise.employees){
                                for (int hIDs : actualEmployee.getHolidayRequestIDs()) {
                                    if (hIDs == h.getHolidayRequestID()) {
                                        actualEmployee.removeHolidayDays(Math.round(h.getHolidayLength()));
                                    }
                                }
                            }
                            break;
                        }
                    }
                    else if(tf.equalsIgnoreCase("f")){
                        if(!h.isApproved()) {
                            System.out.println("This holiday is already declined");
                        }else {
                            h.setApproved(false);
                            for (Employee actualEmployee : Initialise.employees){
                                for (int hIDs : actualEmployee.getHolidayRequestIDs()) {
                                    if (hIDs == h.getHolidayRequestID()) {
                                        actualEmployee.addHolidayDays(Math.round(h.getHolidayLength()));
                                    }
                                }
                            }
                            break;
                        }
                    }
                    else {
                        System.out.println("Please enter either 't' or 'f'");
                    }
                }

            }
        }
    }

    private void takeID() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("Enter the holiday ID you wish to authorise");
        while (true) {
            try {
                holidayID = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid ID from the menu");
            }
        }
    }


}
