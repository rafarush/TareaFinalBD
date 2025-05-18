package services;

import dataBase.DataBaseConnection;
import models.LicenseStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LicenseStatusServices {

    public void createLicenseStatus(LicenseStatus status) {
        String sql = "INSERT INTO LicenseStatus (licenseStatus) VALUES (?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status.getLicenseStatus());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LicenseStatus obtainLicenseStatus(String licenseStatus) {
        LicenseStatus status = null;
        String sql = "SELECT * FROM LicenseStatus WHERE licenseStatus = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, licenseStatus);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    status = new LicenseStatus();
                    status.setLicenseStatus(rs.getString("licenseStatus"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<LicenseStatus> getAllLicenseStatuses() {
        List<LicenseStatus> list = new ArrayList<>();
        String sql = "SELECT * FROM LicenseStatus";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                LicenseStatus status = new LicenseStatus();
                status.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateLicenseStatus(LicenseStatus status, String oldLicenseStatus) {
        String sql = "UPDATE LicenseStatus SET licenseStatus = ? WHERE licenseStatus = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status.getLicenseStatus());
            pstmt.setString(2, oldLicenseStatus);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLicenseStatus(String licenseStatus) {
        String sql = "DELETE FROM LicenseStatus WHERE licenseStatus = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, licenseStatus);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
