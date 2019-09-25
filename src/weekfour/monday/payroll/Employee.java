package weekfour.monday.payroll;

import java.util.ArrayList;

public class Employee {
    // Variable Declaration
    private int employeeID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String position;
    private ArrayList<Integer> holidayRequestIDs;
    private ArrayList<Integer> paymentIDs;
    private float workingHours;
    private float rateOfPay;
    private boolean isAdmin;
    private float holidayEntitlement;
    private int remainingHolidays;

    // Constructor
    public Employee(int employeeID, String firstName, String lastName, String position, String username, String password, float workingHours) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.username = username;
        this.password = password;
        this.workingHours = workingHours;
        checkIsAdmin();
        checkRateOfPay();
        checkHolidayEntitlement();
        this.remainingHolidays = Math.round(this.holidayEntitlement);
        paymentIDs = new ArrayList<Integer>();
        holidayRequestIDs = new ArrayList<Integer>();
    }

    // Functionality
    private void checkHolidayEntitlement() {
        holidayEntitlement = (workingHours / (float) 7.5) * (float) 5.6;
    }

    // checks if the employee is an admin based on their position
    private void checkIsAdmin() {
        switch (position) {
            case "payroll":
            case "MD":
            case "HR":
                isAdmin = true;
                break;
        }
    }

    // sets the rate of pay for the employee based on their position
    private void checkRateOfPay() {
        switch (position) {
            case "Entry Level":
                rateOfPay = (float) 6.15;
                break;
            case "Supervisor":
                rateOfPay = (float) 7.50;
                break;
            case "Payroll":
                rateOfPay = (float) 9.65;
            case "Manager":
            case "HR":
                rateOfPay = (float) 12.20;
                break;
            case "MD":
                rateOfPay = (float) 18.75;
                break;
        }
    }

    // GETTERS & SETTERS
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getHolidayEntitlement() {
        return holidayEntitlement;
    }

    public void setHolidayEntitlement(float holidayEntitlement) {
        this.holidayEntitlement = holidayEntitlement;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<Integer> getHolidayRequestIDs() {
        return holidayRequestIDs;
    }

    public void setHolidayRequestIDs(ArrayList<Integer> holidayRequestIDs) {
        this.holidayRequestIDs = holidayRequestIDs;
    }

    public ArrayList<Integer> getPaymentIDs() {
        return paymentIDs;
    }

    public void setPaymentIDs(ArrayList<Integer> paymentIDs) {
        this.paymentIDs = paymentIDs;
    }

    public float getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(float workingHours) {
        this.workingHours = workingHours;
    }

    public float getRateOfPay() {
        return rateOfPay;
    }

    public void setRateOfPay(float rateOfPay) {
        this.rateOfPay = rateOfPay;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getRemainingHolidays() {
        return remainingHolidays;
    }

    public void setRemainingHolidays(int remainingHolidays) {
        this.remainingHolidays = remainingHolidays;
    }

    // add payment
    public void addPayment(int newPaymentID) {
        this.paymentIDs.add(newPaymentID);
    }

    public void addHolidayRequest(int newHolidayID) {
        this.holidayRequestIDs.add(newHolidayID);
    }

    public void removeHolidayDays(int days){
        remainingHolidays = remainingHolidays - days;
    }

    public void addHolidayDays(int days){
        remainingHolidays = remainingHolidays + days;
    }
}
