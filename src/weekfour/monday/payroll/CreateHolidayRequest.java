package weekfour.monday.payroll;

import java.text.ParseException;
import java.util.Date;

public class CreateHolidayRequest {
    private int hID;
    private Date startDate;
    private Date endDate;

    public void createHolidayRequest(Employee e) throws ParseException {
        getHolidayID();
        System.out.println("===== Start Date =====");
        ProcessNewPayments pnp = new ProcessNewPayments();
        startDate = pnp.getDate();
        System.out.println("===== End Date =====");
        endDate = pnp.getDate();
        HolidayRequest newHol = new HolidayRequest(hID, startDate, endDate);
        Initialise.holidayRequests.add(newHol);
        e.addHolidayRequest(hID);
    }

    private void getHolidayID() {
        if (Initialise.holidayRequests.size() == 0){
            hID = 1;
            return;
        }
        HolidayRequest lastHoliday = Initialise.holidayRequests.get(Initialise.holidayRequests.size()-1);
        hID = lastHoliday.getHolidayRequestID() + 1;
    }
}
