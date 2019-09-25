package weekfour.monday.payroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Initialise {
    static ArrayList<Employee> employees;
    static ArrayList<HolidayRequest> holidayRequests;
    static ArrayList<Payment> payments;

    public void seedEmployees() throws ParseException {
        employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "Robert", "Watkin", "MD", "robby1110", "Password1", (float) 37.5));
        employees.add(new Employee(2, "Kieran", "Ingram", "Entry Level", "kDog", "k123", (float) 37.5));
        employees.add(new Employee(3, "Dave", "Johnson", "Entry Level", "ddog", "d123", (float) 15));
        kieranPaymentSeed();
        daveHolidaySeed();
    }

    private void kieranPaymentSeed() throws ParseException {
        payments = new ArrayList<Payment>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = format.parse("13-07-2016");
        Date d2 = format.parse("01-01-2020");
        payments.add(new Payment(1, d1, employees.get(1).getRateOfPay(), employees.get(1).getWorkingHours()));
        payments.add(new Payment(2, d2, employees.get(1).getRateOfPay(), employees.get(1).getWorkingHours()));
        employees.get(1).addPayment(1);
        employees.get(1).addPayment(2);
    }

    private void daveHolidaySeed() throws ParseException {
        holidayRequests = new ArrayList<HolidayRequest>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date d1start = format.parse("01-10-2019");
        Date d1end = format.parse("10-10-2019");
        Date d2start = format.parse("01-11-2019");
        Date d2end = format.parse("10-11-2019");
        holidayRequests.add(new HolidayRequest(1, d1start, d1end));
        holidayRequests.add(new HolidayRequest(2, d2start, d2end));
        employees.get(2).addHolidayRequest(1);
        employees.get(2).addHolidayRequest(2);
    }
}
