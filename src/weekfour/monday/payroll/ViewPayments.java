package weekfour.monday.payroll;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;

public class ViewPayments {
    public void viewPastPayments(Employee e) {
        Date today = new Date();
        if (Initialise.payments.size() > 0 && e.getPaymentIDs().size() > 0) {
            System.out.println("============Previous Payments============");
            for (Payment p : Initialise.payments) {
                for (int i : e.getPaymentIDs()) {
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    if (p.getPaymentDate().before(today) && i == p.getPaymentID()) {
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
        } else {
            System.out.println("There are no past payments to show");
        }
    }

    public void viewPendingPayments(Employee e) {
        Date today = new Date();
        if (Initialise.payments.size() > 0 && e.getPaymentIDs().size() > 0) {
            System.out.println("============Pending Payments============");
            for (Payment p : Initialise.payments) {
                for (int i : e.getPaymentIDs()) {
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    if (p.getPaymentDate().after(today) && i == p.getPaymentID()) {
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
        } else {
            System.out.println("There are no past payments to show");
        }
    }

    public void viewPaymentReport() throws ParseException {
        System.out.println("===== Start Date =====");
        ProcessNewPayments pnp = new ProcessNewPayments();
        Date startDate = pnp.getDate();
        System.out.println("===== End Date =====");
        Date endDate = pnp.getDate();

        float totalPaid = 0;

        if (Initialise.payments.size() > 0) {
            System.out.println("============Pending Payments============");
            for (Payment p : Initialise.payments) {
                NumberFormat formatter = new DecimalFormat("#0.00");
                if (p.getPaymentDate().after(startDate) && p.getPaymentDate().before(endDate)) {
                    System.out.println("Payment ID\t\t\t>> " + p.getPaymentID());
                    System.out.println("Payment Date\t\t>> " + p.getPaymentDate());
                    System.out.println("Gross Amount\t\t>> £" + formatter.format(p.getGrossPaymentAmount()));
                    System.out.println("Tax\t\t\t\t\t>> £" + formatter.format(p.getTax()));
                    System.out.println("National Insurance\t>> £" + formatter.format(p.getNationalInsurance()));
                    System.out.println("Take Home\t\t\t>> £" + formatter.format(p.getTakeHomePay()));
                    System.out.println();

                    totalPaid += p.getGrossPaymentAmount();
                }

            }
        } else {
            System.out.println("There are no past payments to show");
        }

        System.out.println("TOTAL PAID - " + totalPaid);
    }
}
