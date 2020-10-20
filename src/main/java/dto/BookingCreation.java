package dto;

import java.sql.Date;
import java.sql.Time;

public class BookingCreation {

    private final String date;
    private final String start;
    private final String end;
    private final int customerId, employeeId;


    public BookingCreation(int customerId, int employeeId, String date, String start, String end) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.date = date;
        this.start = start;
        this.end = end;

    }

    public String getDate() {
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
