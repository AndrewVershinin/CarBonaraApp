package com.pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesDao {
    private final DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveSale(SalesContract contract) {
        String sql = """
                    INSERT INTO sales_contracts (VIN, customer_name, customer_phone, sale_date, sale_price)
                    VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contract.getVin());
            stmt.setString(2, contract.getCustomerName());
            stmt.setString(3, contract.getCustomerPhone());
            stmt.setDate(4, Date.valueOf(contract.getSaleDate())); // converts LocalDate to SQL date
            stmt.setDouble(5, contract.getSalePrice());

            stmt.executeUpdate();
            System.out.println("Sales contract saved!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SalesContract> getAllSales() {
        List<SalesContract> contracts = new ArrayList<>();
        String sql = "SELECT * FROM sales_contracts";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                contracts.add(new SalesContract(
                        rs.getString("VIN"),
                        rs.getString("customer_name"),
                        rs.getString("customer_phone"),
                        rs.getDate("sale_date").toLocalDate(),
                        rs.getDouble("sale_price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contracts;
    }
}