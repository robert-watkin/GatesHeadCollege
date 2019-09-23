package weekfour.monday.payroll;

import java.util.ArrayList;

public class Initialise {
    static ArrayList<Employee> employees;
    static ArrayList<HolidayRequest> holidayRequests;
    static ArrayList<Payment> payments;

    public void seedEmployees(){
        employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "Robert", "Watkin", "MD", "robby1110", "Password1", (float) 37.5));
        employees.add(new Employee(1, "Kieran", "Ingram", "Entry Level", "kDog", "k123", (float) 37.5));
    }
}
