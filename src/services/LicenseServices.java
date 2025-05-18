package services;

import dataBase.DataBaseConnection;
import models.License;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LicenseServices {

    public void createLicense(License license) {
        String sql = "INSERT INTO License (licenseId, driverId, licenseType, issueDate, expirationDate, restrictions, renewed, licenseStatus) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, license.getLicenseId());
            pstmt.setInt(2, license.getDriverId());
            pstmt.setString(3, license.getLicenseType());
            pstmt.setDate(4, license.getIssueDate());
            pstmt.setDate(5, license.getExpirationDate());
            pstmt.setString(6, license.getRestrictions());
            pstmt.setBoolean(7, license.isRenewed());
            pstmt.setString(8, license.getLicenseStatus());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public License obtainLicense(int licenseId) {
        License license = null;
        String sql = "SELECT * FROM License WHERE licenseId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, licenseId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    license = new License();
                    license.setLicenseId(rs.getInt("licenseId"));
                    license.setDriverId(rs.getInt("driverId"));
                    license.setLicenseType(rs.getString("licenseType"));
                    license.setIssueDate(rs.getDate("issueDate"));
                    license.setExpirationDate(rs.getDate("expirationDate"));
                    license.setRestrictions(rs.getString("restrictions"));
                    license.setRenewed(rs.getBoolean("renewed"));
                    license.setLicenseStatus(rs.getString("licenseStatus"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return license;
    }

    public List<License> getAllLicenses() {
        List<License> list = new ArrayList<>();
        String sql = "SELECT * FROM License";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                License license = new License();
                license.setLicenseId(rs.getInt("licenseId"));
                license.setDriverId(rs.getInt("driverId"));
                license.setLicenseType(rs.getString("licenseType"));
                license.setIssueDate(rs.getDate("issueDate"));
                license.setExpirationDate(rs.getDate("expirationDate"));
                license.setRestrictions(rs.getString("restrictions"));
                license.setRenewed(rs.getBoolean("renewed"));
                license.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(license);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateLicense(License license) {
        String sql = "UPDATE License SET driverId = ?, licenseType = ?, issueDate = ?, expirationDate = ?, " +
                "restrictions = ?, renewed = ?, licenseStatus = ? WHERE licenseId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, license.getDriverId());
            pstmt.setString(2, license.getLicenseType());
            pstmt.setDate(3, license.getIssueDate());
            pstmt.setDate(4, license.getExpirationDate());
            pstmt.setString(5, license.getRestrictions());
            pstmt.setBoolean(6, license.isRenewed());
            pstmt.setString(7, license.getLicenseStatus());
            pstmt.setInt(8, license.getLicenseId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLicense(int licenseId) {
        String sql = "DELETE FROM License WHERE licenseId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, licenseId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
