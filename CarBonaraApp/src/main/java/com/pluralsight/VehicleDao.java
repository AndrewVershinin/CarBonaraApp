package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private final DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Vehicle> searchByPriceRange(double min, double max) {
        List<Vehicle> results = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, min);
            stmt.setDouble(2, max);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(mapToVehicle(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    private Vehicle mapToVehicle(ResultSet rs) throws SQLException {
        return new Vehicle(
                rs.getString("VIN"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getDouble("price"),
                rs.getInt("mileage"),
                rs.getBoolean("SOLD"),
                rs.getString("type")
        );
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        List<Vehicle> results = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE make = ? AND model = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, make);
            stmt.setString(2, model);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(mapToVehicle(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        List<Vehicle> results = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE year BETWEEN ? AND ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, minYear);
            stmt.setInt(2, maxYear);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(mapToVehicle(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<Vehicle> searchByColor(String color) {
        List<Vehicle> results = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE color = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, color);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(mapToVehicle(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<Vehicle> searchByMileageRange(int min, int max) {
        List<Vehicle> results = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE mileage BETWEEN ? AND ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, min);
            stmt.setInt(2, max);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(mapToVehicle(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public List<Vehicle> searchByType(String type) {
        List<Vehicle> results = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE type = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(mapToVehicle(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    public void addVehicle(Vehicle vehicle) {
        String sql = """
                    INSERT INTO vehicles (VIN, make, model, year, color, price, mileage, SOLD, type)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vehicle.getVin());
            stmt.setString(2, vehicle.getMake());
            stmt.setString(3, vehicle.getModel());
            stmt.setInt(4, vehicle.getYear());
            stmt.setString(5, vehicle.getColor());
            stmt.setDouble(6, vehicle.getPrice());
            stmt.setInt(7, vehicle.getMileage());
            stmt.setBoolean(8, vehicle.isSold());
            stmt.setString(9, vehicle.getType());

            stmt.executeUpdate();
            System.out.println("Vehicle added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeVehicleByVIN(String vin) {
        String sql = "DELETE FROM vehicles WHERE VIN = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vin);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vehicle removed successfully.");
            } else {
                System.out.println("No vehicle found with VIN: " + vin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}