package services;

import dataBase.DataBaseConnection;
import models.LicenseStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LicenseStatusServices {

    public void createLicenseStatus(LicenseStatus status) {
        if (status != null) {
            String sql = "INSERT INTO LicenseStatus (licenseStatus) VALUES (?)";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, status.getLicenseStatus());
                pstmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("License Status is null");
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
        if (status != null && oldLicenseStatus != null) {
            String sql = "UPDATE LicenseStatus SET licenseStatus = ? WHERE licenseStatus = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, status.getLicenseStatus());
                pstmt.setString(2, oldLicenseStatus);
                int affectedrows = pstmt.executeUpdate();

                if (affectedrows == 0) {
                    throw new NoSuchElementException("There is not record of the license category: " + oldLicenseStatus);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("License Status is null");
        }

    }

    public void deleteLicenseStatus(String licenseStatus) {
        if (licenseStatus != null) {
            String sql = "DELETE FROM LicenseStatus WHERE licenseStatus = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, licenseStatus);
                int affectedrows = pstmt.executeUpdate();

                if (affectedrows == 0) {
                    throw new NoSuchElementException("There is not record of the license category: " + licenseStatus);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("License Status is null");
        }

    }
}
