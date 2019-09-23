package weekfour.monday.payroll;

import java.util.ArrayList;

public class Employee {
    // Variable Declaration
    private int userID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String position;
    private ArrayList<HolidayRequest> holidayRequests;
    private ArrayList<Payment> Payments;
    private float workingHours;
    private float rateOfPay;
    private boolean isAdmin;
    private float holidayEntitlement;

    // Constructor
    public Employee(int userID, String firstName, String lastName, String position, String username, String password, float workingHours) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.username = username;
        this.password = password;
        this.workingHours = workingHours;
        checkIsAdmin();
        checkRateOfPay();
        checkHolidayEntitlement();
    }

    // Functionality
    private void checkHolidayEntitlement() {
        holidayEntitlement = (workingHours/ (float) 7.5)* (float) 5.6;
    }


    private void checkIsAdmin(){
        switch(position){
            case "payroll":
            case "MD":
            case "HR":
                isAdmin = true;
                break;
        }
    }

    private void checkRateOfPay(){
        switch(position){
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public ArrayList<HolidayRequest> getHolidayRequests() {
        return holidayRequests;
    }

    public void setHolidayRequests(ArrayList<HolidayRequest> holidayRequests) {
        this.holidayRequests = holidayRequests;
    }

    public ArrayList<Payment> getPayments() {
        return Payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        Payments = payments;
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
}
