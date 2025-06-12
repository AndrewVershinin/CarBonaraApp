package com.pluralsight;

import java.time.LocalDate;

public class SalesContract {
    private String vin;
    private String customerName;
    private String customerPhone;
    private LocalDate saleDate;
    private double salePrice;

    public SalesContract(String vin, String customerName, String customerPhone, LocalDate saleDate, double salePrice) {
        this.vin = vin;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
    }

    public String getVin() {
        return vin;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public double getSalePrice() {
        return salePrice;
    }
}