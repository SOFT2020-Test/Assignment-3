package main;

import java.util.Date;

public class SQLConverter {
    public static java.sql.Date ConvertToSQLDate(Date d) {
        return new java.sql.Date(d.getTime());
    }
}
