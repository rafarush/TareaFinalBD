package services;

import dataBase.DataBaseConnection;
import models.LicenseCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LicenseCategoryServices {

    public void createLicenseCategory(LicenseCategory category) {
        String sql = "INSERT INTO LicenseCategory (licenseType, licenseCategory) VALUES (?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, category.getLicenseType());
            pstmt.setString(2, category.getLicenseCategory());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LicenseCategory obtainLicenseCategory(String licenseType) {
        LicenseCategory category = null;
        String sql = "SELECT * FROM LicenseCategory WHERE licenseType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, licenseType);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    category = new LicenseCategory();
                    category.setLicenseType(rs.getString("licenseType"));
                    category.setLicenseCategory(rs.getString("licenseCategory"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public List<LicenseCategory> getAllLicenseCategories() {
        List<LicenseCategory> list = new ArrayList<>();
        String sql = "SELECT * FROM LicenseCategory";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                LicenseCategory category = new LicenseCategory();
                category.setLicenseType(rs.getString("licenseType"));
                category.setLicenseCategory(rs.getString("licenseCategory"));
                list.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateLicenseCategory(LicenseCategory category) {
        String sql = "UPDATE LicenseCategory SET licenseCategory = ? WHERE licenseType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, category.getLicenseCategory());
            pstmt.setString(2, category.getLicenseType());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLicenseCategory(String licenseType) {
        String sql = "DELETE FROM LicenseCategory WHERE licenseType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, licenseType);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
