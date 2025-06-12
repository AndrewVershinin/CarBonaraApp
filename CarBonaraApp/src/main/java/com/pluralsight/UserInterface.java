package com.pluralsight;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final VehicleDao dao;
    private final Scanner scanner = new Scanner(System.in);

    public UserInterface(VehicleDao dao) {
        this.dao = dao;
    }

    public void start() {
        while (true) {
            printMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> searchByPrice();
                case "2" -> searchByMakeModel();
                case "3" -> addVehicle();
                case "4" -> removeVehicle();
                case "5" -> sellVehicle();
                case "6" -> leaseVehicle();
                case "0" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n===== Dealership Menu =====");
        System.out.println("1. Search vehicles by price");
        System.out.println("2. Search vehicles by make and model");
        System.out.println("3. Add a new vehicle");
        System.out.println("4. Remove vehicle by VIN");
        System.out.println("5. Sell a vehicle");
        System.out.println("6. Lease a vehicle");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void searchByPrice() {
        System.out.print("Min price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Max price: ");
        double max = Double.parseDouble(scanner.nextLine());

        List<Vehicle> results = dao.searchByPriceRange(min, max);
        results.forEach(System.out::println);
    }

    private void searchByMakeModel() {
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        List<Vehicle> results = dao.searchByMakeModel(make, model);
        results.forEach(System.out::println);
    }

    private void addVehicle() {
        System.out.print("VIN: ");
        String vin = scanner.nextLine();
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Mileage: ");
        int mileage = Integer.parseInt(scanner.nextLine());
        System.out.print("Is it sold? (true/false): ");
        boolean sold = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Type (e.g. SUV, Sedan): ");
        String type = scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, make, model, year, color, price, mileage, sold, type);
        dao.addVehicle(vehicle);
    }

    private void removeVehicle() {
        System.out.print("Enter VIN to remove: ");
        String vin = scanner.nextLine();
        dao.removeVehicleByVIN(vin);
    }
    private void sellVehicle() {
        System.out.print("Enter VIN to sell: ");
        String vin = scanner.nextLine();
        System.out.print("Customer name: ");
        String name = scanner.nextLine();
        System.out.print("Customer phone: ");
        String phone = scanner.nextLine();
        System.out.print("Sale price: ");
        double price = Double.parseDouble(scanner.nextLine());

        SalesContract contract = new SalesContract(vin, name, phone, LocalDate.now(), price);
        new SalesDao(DatabaseConnector.getDataSource()).saveSale(contract);

        // Optional: mark vehicle as sold
        System.out.println("Sale recorded successfully.");
    }
    private void leaseVehicle() {
        System.out.print("Enter VIN to lease: ");
        String vin = scanner.nextLine();
        System.out.print("Customer name: ");
        String name = scanner.nextLine();
        System.out.print("Lease term in months: ");
        int months = Integer.parseInt(scanner.nextLine());
        System.out.print("Monthly payment: ");
        double monthly = Double.parseDouble(scanner.nextLine());

        LeaseContract contract = new LeaseContract(vin, name, months, monthly);
        new LeaseDao(DatabaseConnector.getDataSource()).saveLease(contract);

        System.out.println("Lease recorded successfully.");
    }
}