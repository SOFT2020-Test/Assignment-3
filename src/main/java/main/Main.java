package main;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import datalayer.booking.BookingStorageImpl;
import datalayer.customer.CustomerStorageImpl;
import datalayer.employee.EmployeeStorageImpl;
import dto.*;
import servicelayer.booking.BookingServiceException;
import servicelayer.booking.BookingServiceImpl;
import servicelayer.customer.CustomerServiceException;
import servicelayer.customer.CustomerServiceImpl;
import servicelayer.notifications.SmsServiceException;
import servicelayer.notifications.SmsServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    private static final String conStr = "jdbc:mysql://localhost:3307/BookingSystem";
    private static final String user = "root";
    private static final String pass = "password";

    public static void main(String[] args) throws SQLException, CustomerServiceException, SmsServiceException, BookingServiceException {
        CustomerStorageImpl storage = new CustomerStorageImpl(conStr, user, pass);
        EmployeeStorageImpl eStorage = new EmployeeStorageImpl(conStr, user, pass);
        BookingStorageImpl bStorage = new BookingStorageImpl(conStr, user, pass);
        SmsServiceImpl smsService = new SmsServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl(storage);
        BookingServiceImpl bookingService = new BookingServiceImpl(bStorage);

        var x = customerService.getCustomerById(10);
        System.out.println(x);

        /*BookingCreation t = new BookingCreation(3,3, "2020-10-10","20:15","21:15");
        bStorage.createBooking(t);*/

    }

    public void CreateFakeEmployees(int amount) throws SQLException {
        EmployeeStorageImpl eStorage = new EmployeeStorageImpl(conStr, user, pass);
        Faker faker = new Faker();
        for (int i = 0; i < amount; i++) {
            EmployeeCreation c = new EmployeeCreation(faker.name().firstName(), faker.name().lastName());
            eStorage.createEmployee(c);
        }
    }

    public void createFakeCostumer(int amount) throws SQLException, ParseException {
        CustomerStorageImpl cStorage = new CustomerStorageImpl(conStr, user, pass);
        Faker faker = new Faker();
        for (int i = 0; i < amount; i++) {
             CustomerCreation c = new CustomerCreation(faker.name().firstName(), faker.name().lastName(), faker.phoneNumber().toString(), faker.date().birthday());
            cStorage.createCustomer(c);
        }
    }
}
