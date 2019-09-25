package weekfour.monday.payroll;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class EditPendingPayment {

    private boolean isPending;
    private int paymentID;
    private Payment updatedPayment;

    public void editPayments() throws ParseException {
        // take id
        if (Initialise.payments.size() > 0) {
            printAllPendingPayments();
            takeID();
            setPaymentToEdit();
        } else {
            System.out.println("There are no pending payments");
        }
        //

    }

    private void setPaymentToEdit() throws ParseException {
        Date today = new Date();
        // check there are payments
        for (Payment p : Initialise.payments) {
            if (p.getPaymentID() == paymentID){
                updatedPayment = p;
                edit();
                p = updatedPayment;
            }
        }
    }

    private void edit() throws ParseException {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║        EDIT PAYMENT        ║");
        System.out.println("║                            ║");
        System.out.println("║1. Change Payment Date      ║");
        System.out.println("║2. Change Gross Amount      ║");
        System.out.println("║0. Return                   ║");
        System.out.println("==============================");
        int choice = UserChoice.getChoice(2);
        switch(choice) {
            case 0:
                return;
            case 1:
                ProcessNewPayments pnp = new ProcessNewPayments();
                Date newDate = pnp.getDate();
                updatedPayment.setPaymentDate(newDate);
                break;
            case 2:
                Scanner sc = new Scanner(System.in);
                System.out.println("Please type the new gross pay");
                while (true){
                    try{
                        float newGrossPayment = Float.parseFloat(sc.nextLine());
                        updatedPayment.setGrossPaymentAmount(newGrossPayment);
                        updatedPayment.updateTakeHomePay();
                        break;
                    } catch(Exception e){
                        System.out.println("ERROR! Please enter a valid payment value.");
                    }
                }
                break;
            default:
                System.out.println("Error! Invalid menu choice");
        }
    }

    private void printAllPendingPayments() {
        Date today = new Date();
        // check there are payments
        if (Initialise.payments.size() > 0) {
            System.out.println("============ALL Pending Payments============");
            // loop through all payments
            for (Payment p : Initialise.payments) {
                NumberFormat formatter = new DecimalFormat("#0.00");
                // check payment is a past payment
                if (p.getPaymentDate().after(today)) {
                    // loop employees
                    for (Employee e : Initialise.employees) {
                        // loop IDs
                        if (e.getPaymentIDs().size() > 0) {
                            for (int i : e.getPaymentIDs()) {
                                // if ID is the same, print
                                if (i == p.getPaymentID()) {
                                    System.out.println("Employee Name\t\t>> " + e.getFirstName() + " " + e.getLastName());
                                    System.out.println("Payment ID\t\t\t>> " + p.getPaymentID());
                                    System.out.println("Payment Date\t\t>> " + p.getPaymentDate());
                                    System.out.println("Gross Amount\t\t>> £" + formatter.format(p.getGrossPaymentAmount()));
                                    System.out.println("Tax\t\t\t\t\t>> £" + formatter.format(p.getTax()));
                                    System.out.println("National Insurance\t>> £" + formatter.format(p.getNationalInsurance()));
                                    System.out.println("Take Home\t\t\t>> £" + formatter.format(p.getTakeHomePay()));
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("There are no past payments to show");
        }
    }

    private void takeID() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======================");
        System.out.println("Enter the payment ID you wish to edit");
        while (true) {
            try {
                paymentID = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid ID from the menu");
            }
        }
    }
}
