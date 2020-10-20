package main;

import com.github.javafaker.Faker;
import com.google.protobuf.Message;
import datalayer.booking.BookingStorageImpl;
import datalayer.employee.EmployeeStorageImpl;
import dto.*;
import dto.Booking;
import datalayer.customer.CustomerStorageImpl;
import servicelayer.booking.BookingService;
import servicelayer.booking.BookingServiceException;
import servicelayer.booking.BookingServiceImpl;
import servicelayer.customer.CustomerServiceException;
import servicelayer.customer.CustomerServiceImpl;
import servicelayer.notifications.SmsService;
import servicelayer.notifications.SmsServiceException;
import servicelayer.notifications.SmsServiceImpl;

import java.sql.Date;
import java.sql.SQLException;

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


        /*
        for (int i = 0; i < 100; i++) {
            EmployeeCreation c = new EmployeeCreation(faker.name().firstName(), faker.name().lastName());
            eStorage.createEmployee(c);
        }

        BookingCreation t = new BookingCreation(3,3, "2020-10-10","20:15","21:15");
        bStorage.createBooking(t);



        System.out.println("Got customers: ");
        for (Customer c : storage.getCustomers()) {
            System.out.println(toString(c));
        }
        System.out.println("The end.");

        System.out.println("Got booking from customer: ");
        for (Booking b : bStorage.getBookingsForCustomer(3)) {
            System.out.println(b);
        }
        System.out.println("The end.");

        System.out.println("Get Employee from id: ");
        for (Employee e: eStorage.getEmployeeWithId(2)) {
            System.out.println((e.getId()));
            System.out.println((e.getFirstname()));
            System.out.println((e.getLastname()));
        }
        System.out.println("The end.");

        System.out.println("Got booking from employee: ");
        for (Booking e : bStorage.getBookingsForEmployee(3)) {
            System.out.println(e);
        }
        System.out.println("The end.");*/

    }

    public static String toString(Customer c) {
        return "{" + c.getId() + ", " + c.getFirstname() + ", " + c.getLastname() + "}";
    }


}
