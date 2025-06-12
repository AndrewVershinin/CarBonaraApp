package com.pluralsight;

public class Vehicle {
    private String vin;
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private int mileage;
    private boolean sold;
    private String type;

    public Vehicle(String vin, String make, String model, int year, String color,
                   double price, int mileage, boolean sold, String type) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.mileage = mileage;
        this.sold = sold;
        this.type = type;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public boolean isSold() {
        return sold;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return vin + " | " + make + " " + model + " | Year: " + year + " | $" + price +
                " | Color: " + color + " | Miles: " + mileage + " | Type: " + type + " | Sold: " + sold;
    }
}
