package weekfour.monday.payroll;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

public class ViewHolidayRequests {
    public void viewAllHolidays(Employee e) {
        viewPastHolidays(e);
        viewFutureHolidays(e);
    }

    public void viewPastHolidays(Employee e) {
        Date today = new Date();
        if (Initialise.holidayRequests.size() > 0 && e.getHolidayRequestIDs().size() > 0) {
            System.out.println("============Previous Holidays============");
            for (HolidayRequest h : Initialise.holidayRequests) {
                for (int i : e.getHolidayRequestIDs()) {
                    if (h.getStartDate().before(today) && i == h.getHolidayRequestID()) {
                        System.out.println("Holiday ID\t\t\t>> " + h.getHolidayRequestID());
                        System.out.println("Start Date\t\t\t>> " + h.getStartDate());
                        System.out.println("End Date \t\t\t>> " + h.getEndDate());
                        System.out.println("Holiday Length\t\t>> " + h.getHolidayLength());
                        System.out.println("Is Approved\t\t\t>> Holiday Has Occurred ");
                        System.out.println();
                    }
                }
            }
        } else {
            System.out.println("There are no past payments to show");
        }
    }

    public void viewAllFutureHolidays() {
        Date today = new Date();
        if (Initialise.holidayRequests.size() > 0) {
            System.out.println("============ALL Pending Holidays============");
            for (HolidayRequest h : Initialise.holidayRequests) {
                if (h.getStartDate().after(today)) {
                    System.out.println("Holiday ID\t\t\t>> " + h.getHolidayRequestID());
                    System.out.println("Start Date\t\t\t>> " + h.getStartDate());
                    System.out.println("End Date \t\t\t>> " + h.getEndDate());
                    System.out.println("Holiday Length\t\t>> " + h.getHolidayLength());
                    System.out.println("Is Approved\t\t\t>> " + h.isApproved());
                    System.out.println();
                }
            }
        } else {
            System.out.println("There are no holidays to show");
        }
    }

    public void viewFutureHolidays(Employee e) {
        Date today = new Date();
        if (Initialise.holidayRequests.size() > 0 && e.getHolidayRequestIDs().size() > 0) {
            if (Initialise.holidayRequests.size() > 0 && e.getHolidayRequestIDs().size() > 0) {
                System.out.println("============Pending Holidays============");
                for (HolidayRequest h : Initialise.holidayRequests) {
                    for (int i : e.getHolidayRequestIDs()) {
                        if (h.getStartDate().after(today) && i == h.getHolidayRequestID()) {
                            System.out.println("Holiday ID\t\t\t>> " + h.getHolidayRequestID());
                            System.out.println("Start Date\t\t\t>> " + h.getStartDate());
                            System.out.println("End Date \t\t\t>> " + h.getEndDate());
                            System.out.println("Holiday Length\t\t>> " + h.getHolidayLength());
                            System.out.println("Is Approved\t\t\t>> " + h.isApproved());
                            System.out.println();
                        }
                    }
                }
            } else {
                System.out.println("There are no holidays to show");
            }
        } else {
            System.out.println("There are no holidays to show");
        }
    }
}
