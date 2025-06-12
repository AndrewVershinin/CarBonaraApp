package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class AdminUserInterface {
    private final SalesDao salesDao;
    private final LeaseDao leaseDao;
    private final Scanner scanner = new Scanner(System.in);

    public AdminUserInterface(SalesDao salesDao, LeaseDao leaseDao) {
        this.salesDao = salesDao;
        this.leaseDao = leaseDao;
    }

    public void start() {
        while (true) {
            printMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> viewAllSales();
                case "2" -> viewAllLeases();
                case "0" -> {
                    System.out.println("Exiting Admin Panel...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n===== Admin Panel =====");
        System.out.println("1. View all sales contracts");
        System.out.println("2. View all lease contracts");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void viewAllSales() {
        List<SalesContract> contracts = salesDao.getAllSales();
        if (contracts.isEmpty()) {
            System.out.println("No sales contracts found.");
        } else {
            System.out.println("\n--- Sales Contracts ---");
            for (SalesContract c : contracts) {
                System.out.printf("VIN: %s | Customer: %s | Phone: %s | Date: %s | Price: $%.2f%n",
                        c.getVin(), c.getCustomerName(), c.getCustomerPhone(),
                        c.getSaleDate(), c.getSalePrice());
            }
        }
    }

    private void viewAllLeases() {
        List<LeaseContract> contracts = leaseDao.getAllLeases();
        if (contracts.isEmpty()) {
            System.out.println("No lease contracts found.");
        } else {
            System.out.println("\n--- Lease Contracts ---");
            for (LeaseContract c : contracts) {
                System.out.printf("VIN: %s | Customer: %s | Term: %d months | Monthly: $%.2f%n",
                        c.getVin(), c.getCustomerName(),
                        c.getLeaseTermMonths(), c.getMonthlyPayment());
            }
        }
    }
}