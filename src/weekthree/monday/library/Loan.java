package weekthree.monday.library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Loan {
    public int bookID;
    public int memberID;
    public String dueDate;
    public String loanDate;
    public String dayOfTheWeek;

    public Loan(int bookID, int memberID, int day, int month, int year) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        String dateInString = "31-08-1982 10:20:56";
         // Adding 5 days

        this.bookID = bookID;
        this.memberID = memberID;
        this.loanDate = day + "/" + month + "/" + year;

        c.set(year, month - 1, day, 0, 0); // Now use today date.
        c.add(Calendar.DATE, 5);

        this.dueDate = c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH) + "/" + c.get(Calendar.YEAR);
        int dotw = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(dotw);
        switch (dotw){
            case 1:
                dayOfTheWeek = "Monday";
                break;
            case 2:
                dayOfTheWeek = "Tuesday";
                break;
            case 3:
                dayOfTheWeek = "Wednesday";
                break;
            case 4:
                dayOfTheWeek = "Thursday";
                break;
            case 5:
                dayOfTheWeek = "Friday";
                break;
            case 6:
                dayOfTheWeek = "Saturday";
                break;
            case 7:
                dayOfTheWeek = "Sunday";
                break;
            default:
                System.out.println("Invalid");
        }
    }
}
