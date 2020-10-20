package unit.servicelayer.notification;


import datalayer.employee.EmployeeStorage;
import dto.SmsMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.employee.EmployeeService;
import servicelayer.employee.EmployeeServiceException;
import servicelayer.employee.EmployeeServiceImpl;
import servicelayer.notifications.SmsService;
import servicelayer.notifications.SmsServiceException;
import servicelayer.notifications.SmsServiceImpl;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("unit")
public class NotificationTest {

    // SUT (System Under Test)
    private SmsService smsService;
    private Object SmsServiceException;

    @BeforeAll
    public void beforeAll(){
        smsService = new SmsServiceImpl();
    }

    @Test
    public void sendMessage() throws SmsServiceException {
        // Arrange
        // Act
        var recipient = "123123";
        var message = "This is a message!";
        var sms = smsService.sendSms(new SmsMessage(recipient, message));

        assertEquals(sms, true); //We expect the sms to be TRUE
    }

    @Test
    public void sendMessageExpectSmsServiceExceptionNoRecipient() throws SmsServiceException {
        // Arrange
        // Act
        var recipient = "";
        var message = "This is a message!";
        Throwable exception = assertThrows(SmsServiceException.class, () -> smsService.sendSms(new SmsMessage(recipient, message)));
        assertEquals("SMS ERROR: message must have a recipient...", exception.getMessage());
    }

    @Test
    public void sendMessageExpectSmsServiceExceptionNoMessage() throws SmsServiceException {
        // Arrange
        // Act
        var recipient = "123123";
        var message = "";
        Throwable exception = assertThrows(SmsServiceException.class, () -> smsService.sendSms(new SmsMessage(recipient, message)));
        assertEquals("SMS ERROR: message is empty...", exception.getMessage());
    }
}
