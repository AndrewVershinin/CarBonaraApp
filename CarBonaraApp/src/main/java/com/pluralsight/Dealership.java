package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehiclesByPrice(Double min, Double max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= min && v.getYear() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color)) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMileage() >= min && v.getMileage() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getType().equalsIgnoreCase(vehicleType)) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public void printInventory() {
        for (Vehicle v : inventory) {
            System.out.println(v.getVin() + "|" + v.getYear() + "|"
                    + v.getMake() + "|" + v.getModel()
                    + "|" + v.getType() + "|" + v.getColor()
                    + "|" + v.getMileage() + "|" + v.getPrice());
        }
    }
}
