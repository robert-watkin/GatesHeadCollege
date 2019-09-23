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


    public Payment(int paymentID, Date paymentDate, float hourlyRate, float rateOfPay) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.grossPaymentAmount = ((hourlyRate * rateOfPay) * 52) / 12;
        calculateTax();
        calculateNI();
        calculateTakeHomePay();
    }

    private void calculateTax(){        // 20% tax
        tax = grossPaymentAmount * (float) 0.2;
    }

    private void calculateNI(){        // 12% NI
        nationalInsurance = nationalInsurance * (float) 0.12;
    }

    private void calculateTakeHomePay(){
        takeHomePay = grossPaymentAmount - (tax + nationalInsurance);
    }
}
