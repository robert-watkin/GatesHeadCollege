package weekfour.monday.payroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class ProcessNewPayments {
    int pID;
    Date pDate;
    float hPay;
    float hPerWeek;

    public void createNewPayment(Employee loggedIn) throws ParseException {
        System.out.println("============================");
        SelectEmployee se = new SelectEmployee();
        Employee e = se.selectEmployee();
        if (e.equals(loggedIn)){
            System.out.println("You are unable to process new payments for yourself.");
            return;
        }
        // int paymentID, Date paymentDate, float hourlyPay, float hoursPerWeek
        getPaymentID();
        pDate = getDate();
        hPay = e.getRateOfPay();
        hPerWeek = e.getWorkingHours();
        Payment newPayment = new Payment(pID, pDate, hPay, hPerWeek);
        Initialise.payments.add(newPayment);
        e.addPayment(pID);
    }

    public void createBulkPayment(Employee loggedIn) throws ParseException {
        System.out.println("============================");
        // int paymentID, Date paymentDate, float hourlyPay, float hoursPerWeek
        pDate = getDate();
        for (Employee employees : Initialise.employees) {
            if (employees.getEmployeeID() != loggedIn.getEmployeeID()) {
                getPaymentID();
                hPay = employees.getRateOfPay();
                hPerWeek = employees.getWorkingHours();
                Payment newPayment = new Payment(pID, pDate, hPay, hPerWeek);
                Initialise.payments.add(newPayment);
                employees.addPayment(pID);
            }
        }
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please specify the day (1-31) : ");
        String day = "";
        String month = "";
        String year = "";
        boolean valid = false;
        while (!valid){
            sc = new Scanner(System.in);
            try{
                day = sc.nextLine();
                if (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31){
                    System.out.println("Please enter a number between 01-31");
                }else{
                    if (Integer.parseInt(day) < 10){
                        day = "0" + Integer.parseInt(day);
                        valid = true;
                        break;
                    }
                    else{
                        valid = true;
                        break;
                    }
                }
            }
            catch (Exception e){
                System.out.println("Please enter a number between 01-31");
            }
        }

        System.out.println("Please specify the month (1-12) : ");
        while (true){
            sc = new Scanner(System.in);
            try{
                month = sc.nextLine();
                if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12){
                    System.out.println("Please enter a number between 01-12");
                }else{
                    if (Integer.parseInt(month) < 10){
                        month = "0" + Integer.parseInt(month);
                        valid = true;
                        break;
                    }
                    else{
                        valid = true;
                        break;
                    }
                }
            }
            catch (Exception e){
                System.out.println("Please enter a number between 01-31");
            }
        }

        System.out.println("Please specify the year (2000-9999) : ");
        while (true){
            sc = new Scanner(System.in);
            try{
                year= sc.nextLine();
                if (Integer.parseInt(year) < 2000 || Integer.parseInt(year) > 9999){
                    System.out.println("Please enter a number between 2000-9999");
                }else{
                    valid = true;
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Please enter a number between 01-31");
            }
        }

        Date newDate = sdf.parse(day+"-"+month+"-"+year);
        return newDate;
    }

    private void getPaymentID() {
        if (Initialise.payments.size() == 0){
            pID = 1;
            return;
        }
        Payment lastPayment = Initialise.payments.get(Initialise.payments.size()-1);
        pID = lastPayment.getPaymentID() + 1;
    }
}
