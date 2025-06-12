package com.pluralsight;

public class LeaseContract {
    private String vin;
    private String customerName;
    private int leaseTermMonths;
    private double monthlyPayment;

    public LeaseContract(String vin, String customerName, int leaseTermMonths, double monthlyPayment) {
        this.vin = vin;
        this.customerName = customerName;
        this.leaseTermMonths = leaseTermMonths;
        this.monthlyPayment = monthlyPayment;
    }

    public String getVin() { return vin; }
    public String getCustomerName() { return customerName; }
    public int getLeaseTermMonths() { return leaseTermMonths; }
    public double getMonthlyPayment() { return monthlyPayment; }
}