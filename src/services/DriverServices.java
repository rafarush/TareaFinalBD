package services;

import dataBase.DataBaseConnection;
import models.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverServices {

    public void createDriver(Driver driver) {
        String sql = "INSERT INTO Driver (driverId, firstName, lastName, birthDate, address, phone, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, driver.getDriverId());
            pstmt.setString(2, driver.getFirstName());
            pstmt.setString(3, driver.getLastName());
            pstmt.setDate(4, driver.getBirthDate());
            pstmt.setString(5, driver.getAddress());
            pstmt.setString(6, driver.getPhone());
            pstmt.setString(7, driver.getEmail());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Driver obtainDriver(int driverId) {
        Driver driver = null;
        String sql = "SELECT * FROM Driver WHERE driverId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, driverId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    driver = new Driver();
                    driver.setDriverId(rs.getInt("driverId"));
                    driver.setFirstName(rs.getString("firstName"));
                    driver.setLastName(rs.getString("lastName"));
                    driver.setBirthDate(rs.getDate("birthDate"));
                    driver.setAddress(rs.getString("address"));
                    driver.setPhone(rs.getString("phone"));
                    driver.setEmail(rs.getString("email"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public List<Driver> getAllDrivers() {
        List<Driver> list = new ArrayList<>();
        String sql = "SELECT * FROM Driver";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Driver driver = new Driver();
                driver.setDriverId(rs.getInt("driverId"));
                driver.setFirstName(rs.getString("firstName"));
                driver.setLastName(rs.getString("lastName"));
                driver.setBirthDate(rs.getDate("birthDate"));
                driver.setAddress(rs.getString("address"));
                driver.setPhone(rs.getString("phone"));
                driver.setEmail(rs.getString("email"));
                list.add(driver);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateDriver(Driver driver) {
        String sql = "UPDATE Driver SET firstName = ?, lastName = ?, birthDate = ?, address = ?, phone = ?, email = ? WHERE driverId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, driver.getFirstName());
            pstmt.setString(2, driver.getLastName());
            pstmt.setDate(3, driver.getBirthDate());
            pstmt.setString(4, driver.getAddress());
            pstmt.setString(5, driver.getPhone());
            pstmt.setString(6, driver.getEmail());
            pstmt.setInt(7, driver.getDriverId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDriver(int driverId) {
        String sql = "DELETE FROM Driver WHERE driverId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, driverId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
