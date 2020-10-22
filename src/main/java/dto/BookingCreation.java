package dto;

import java.util.Date;

public class BookingCreation {

    private final Date date;
    private final String start;
    private final String end;
    private final int customerId, employeeId;


    public BookingCreation(int customerId, int employeeId, Date date, String start, String end) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.date = date;
        this.start = start;
        this.end = end;

    }

    public Date getDate() {
        return date;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }
}
