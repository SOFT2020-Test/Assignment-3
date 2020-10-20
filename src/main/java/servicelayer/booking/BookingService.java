package servicelayer.booking;

import dto.*;
import servicelayer.customer.CustomerServiceException;
import servicelayer.notifications.SmsServiceException;

import java.util.Collection;
import java.util.Date;


public interface BookingService {

     int createBooking(int customerId, int employeeId, String date, String start, String end, SmsMessage message) throws BookingServiceException, SmsServiceException;
     Collection<Booking> getBookingsForCustomer(int customerId)throws BookingServiceException;
     Collection<Booking> getBookingsForEmployee(int employeeId)throws BookingServiceException;
}
