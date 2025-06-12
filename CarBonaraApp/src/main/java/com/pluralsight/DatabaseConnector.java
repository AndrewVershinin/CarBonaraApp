package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DatabaseConnector {
    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/car_dealership");
        dataSource.setUsername("root"); // your DB username
        dataSource.setPassword("yearup"); // your DB password
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
