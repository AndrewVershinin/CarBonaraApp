package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var dataSource = DatabaseConnector.getDataSource();
        var vehicleDao = new VehicleDao(dataSource);
        var salesDao = new SalesDao(dataSource);
        var leaseDao = new LeaseDao(dataSource);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Dealership System");
        System.out.print("Are you an admin? (yes/no): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("yes")) {
            AdminUserInterface adminUI = new AdminUserInterface(salesDao, leaseDao);
            adminUI.start();
        } else {
            UserInterface userUI = new UserInterface(vehicleDao);
            userUI.start();
        }
    }
}