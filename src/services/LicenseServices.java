package services;

import dataBase.DataBaseConnection;
import models.License;
import models.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LicenseServices {

    public void createLicense(License license) {
        if (license != null) {
            if (is_valid(license)) {
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
            } else {
                throw new IllegalArgumentException("License not valid");
            }

        } else {
            throw new NullPointerException("License is null");
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
        if (license != null) {
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

                int affectedrows = pstmt.executeUpdate();

                if (affectedrows == 0) {
                    throw new NoSuchElementException("There is not record of the license: " + license.getLicenseId());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("License is null");
        }

    }

    public void deleteLicense(int licenseId) {
        String sql = "DELETE FROM License WHERE licenseId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, licenseId);
            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license: " + licenseId);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int countLicenses() {
        int count = 0;
        String sql = "SELECT count(*) as quantity FROM license";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            if (rs.next()) {
                count = rs.getInt("quantity");
            } else {
                throw new NoSuchElementException("There is not record of a license");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private boolean is_valid(License license) {
        boolean is_valid = false;
        boolean theoric = false;
        boolean practical = false;
        boolean medical = false;

        List<Test> tests = new ArrayList<>();
        tests = ServicesLocator.getInstance().getTestServices().getAllApprovedValidTests();


        int i = 0;
        while (i<tests.size() && !is_valid) {
            String testType = tests.get(i).getTestType();
            if (testType.equalsIgnoreCase("Teorico")) {
                theoric = true;
            }else if (testType.equalsIgnoreCase("Practico")) {
                practical = true;
            }else if (testType.equalsIgnoreCase("Medico")) {
                medical = true;
            }
            if (theoric && practical && medical) {
                is_valid = true;
            }
            i++;
        }

        return is_valid;
    }

}
