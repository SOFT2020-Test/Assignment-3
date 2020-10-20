package datalayer.booking;

import dto.Booking;
import dto.BookingCreation;
import dto.Customer;
import dto.CustomerCreation;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface BookingStorage {

    public int createBooking(BookingCreation bookingCreation)throws SQLException;
    public Collection<Booking> getBookingsForCustomer(int customerId) throws SQLException;
    public Collection<Booking> getBookingsForEmployee(int employeeId)throws SQLException;
    public Booking getBookingById(int bookingId) throws SQLException;

}
