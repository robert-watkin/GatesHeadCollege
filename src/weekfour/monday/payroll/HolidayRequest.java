package weekfour.monday.payroll;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HolidayRequest {
    private int holidayRequestID;
    private Date startDate;
    private Date endDate;
    private long holidayLength;
    private boolean isApproved;

    // Constructor to set values for the object
    public HolidayRequest(int holidayRequestID, Date startDate, Date endDate) {
        this.holidayRequestID = holidayRequestID;
        this.startDate = startDate;
        this.endDate = endDate;
        try {
            long diff = endDate.getTime() - startDate.getTime();
            this.holidayLength = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isApproved = false;
    }

    // GETTERS & SETTERS


    public int getHolidayRequestID() {
        return holidayRequestID;
    }

    public void setHolidayRequestID(int holidayRequestID) {
        this.holidayRequestID = holidayRequestID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getHolidayLength() {
        return holidayLength;
    }

    public void setHolidayLength(long holidayLength) {
        this.holidayLength = holidayLength;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
