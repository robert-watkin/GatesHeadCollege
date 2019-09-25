package weekfour.monday.payroll;

import java.util.Date;

public class Payment {
    // variable declaration
    private int paymentID;
    private Date paymentDate;
    private float grossPaymentAmount;
    private float tax;
    private float nationalInsurance;
    private float takeHomePay;

    // Constructor


    public Payment(int paymentID, Date paymentDate, float hourlyPay, float hoursPerWeek) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.grossPaymentAmount = ((hourlyPay * hoursPerWeek) * 52) / 12;
        calculateTax();
        calculateNI();
        calculateTakeHomePay();
    }

    public void updateTakeHomePay(){
        calculateNI();
        calculateTax();
        calculateTakeHomePay();
    }

    private void calculateTax(){        // 20% tax
        tax = grossPaymentAmount * (float) 0.2;
    }

    private void calculateNI(){        // 12% NI
        nationalInsurance = grossPaymentAmount * (float) 0.12;
    }

    private void calculateTakeHomePay(){
        takeHomePay = grossPaymentAmount - (tax + nationalInsurance);
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public float getGrossPaymentAmount() {
        return grossPaymentAmount;
    }

    public void setGrossPaymentAmount(float grossPaymentAmount) {
        this.grossPaymentAmount = grossPaymentAmount;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getNationalInsurance() {
        return nationalInsurance;
    }

    public void setNationalInsurance(float nationalInsurance) {
        this.nationalInsurance = nationalInsurance;
    }

    public float getTakeHomePay() {
        return takeHomePay;
    }

    public void setTakeHomePay(float takeHomePay) {
        this.takeHomePay = takeHomePay;
    }
}
