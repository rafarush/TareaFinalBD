package services;

import dataBase.DataBaseConnection;
import models.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DriverServices {

    public void createDriver(Driver driver) throws Exception {
        if (driver != null) {
            if (isDuplicated(driver.getDriverId())){
                String sql = "INSERT INTO Driver (driverId, firstName, lastName, birthDate, address, phone, email) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (Connection conn = DataBaseConnection.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, driver.getDriverId());
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
            } else {
                throw new Exception("Driver cannot be duplicated");
            }
        } else {
            throw new NullPointerException("Driver cannot be null");
        }

    }

    public Driver obtainDriver(String driverId) {
        Driver driver = null;
        String sql = "SELECT * FROM Driver WHERE driverId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, driverId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    driver = new Driver();
                    driver.setDriverId(rs.getString("driverId"));
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
                driver.setDriverId(rs.getString("driverId"));
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
        if (driver != null) {
            String sql = "UPDATE Driver SET firstName = ?, lastName = ?, birthDate = ?, address = ?, phone = ?, email = ? WHERE driverId = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, driver.getFirstName());
                pstmt.setString(2, driver.getLastName());
                pstmt.setDate(3, driver.getBirthDate());
                pstmt.setString(4, driver.getAddress());
                pstmt.setString(5, driver.getPhone());
                pstmt.setString(6, driver.getEmail());
                pstmt.setString(7, driver.getDriverId());

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new NoSuchElementException("There is not record of a driver with ID: " + driver.getDriverId());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("Driver cannot be null");
        }
    }

    public void deleteDriver(String driverId) {
        String sql = "DELETE FROM Driver WHERE driverId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, driverId);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new NoSuchElementException("There is not record of a driver with ID: " + driverId);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int countDrivers() {
        int count = 0;
        String sql = "SELECT count(*) as quantity FROM driver";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            if (rs.next()) {
                count = rs.getInt("quantity");
            } else {
                throw new NoSuchElementException("There is not record of a driver");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean isDuplicated(String id) {
        boolean isDuplicated = false;
        String sql = "Select * from driver where driverid = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    isDuplicated = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDuplicated;
    }
}
