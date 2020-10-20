package unit.servicelayer.booking;

import datalayer.booking.BookingStorage;
import datalayer.customer.CustomerStorage;
import dto.BookingCreation;
import dto.SmsMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.booking.BookingService;
import servicelayer.booking.BookingServiceException;
import servicelayer.booking.BookingServiceImpl;
import servicelayer.customer.CustomerService;
import servicelayer.customer.CustomerServiceException;
import servicelayer.customer.CustomerServiceImpl;
import servicelayer.notifications.SmsServiceException;

import java.sql.SQLException;
import java.util.Date;

import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("unit")
public class CreateBookingTest {

    // SUT (System Under Test)
    private BookingService bookingService;

    // DOC (Depended-on Component)
    private BookingStorage storageMock;


    @BeforeAll
    public void beforeAll(){
        storageMock = mock(BookingStorage.class);
        bookingService = new BookingServiceImpl(storageMock);
    }

    @Test
    public void mustCallStorageWhenCreatingBooking() throws BookingServiceException, SQLException, SmsServiceException {
        // Arrange
        // Act

        int customerId = 1;
        int employeeId = 1;
        Date date = new Date();
        String start = "20:15";
        String end = "21:15";

        String recipient = "12345678";
        String message = "This is a message";
        bookingService.createBooking(customerId, employeeId, date.toString(), start, end, new SmsMessage(recipient, message));

        // Assert
        // Can be read like: verify that storageMock was called 1 time on the method
        //   'createBooking' with an argument whose 'customerId' == customerId and
        //   whose 'employeeId' == employeeId
        verify(storageMock, times(1))
                .createBooking(
                        argThat(x -> x.getCustomerId() == customerId &&
                                x.getEmployeeId() == employeeId));
    }
}
