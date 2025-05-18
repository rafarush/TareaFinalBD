package services;

import dataBase.DataBaseConnection;
import models.Center;
import java.sql.*;

public class CenterServices {

    public void createCenter(Center center) {
        String sql = "INSERT INTO Center (centerCode, centerName, postalAddress, phone, centerEmail, generalDirectorName, hrManager, accountingManager, secretaryName, logo) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, center.getCenterCode());
            pstmt.setString(2, center.getCenterName());
            pstmt.setString(3, center.getPostalAddress());
            pstmt.setString(4, center.getPhone());
            pstmt.setString(5, center.getCenterEmail());
            pstmt.setString(6, center.getGeneralDirectorName());
            pstmt.setString(7, center.getHrManager());
            pstmt.setString(8, center.getAccountingManager());
            pstmt.setString(9, center.getSecretaryName());
            pstmt.setString(10, center.getLogo());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Center obtainCenter(String centerCode) {
        Center center = null;
        String sql = "SELECT * FROM Center WHERE centerCode = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, centerCode);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    center = new Center();
                    center.setCenterCode(rs.getString("centerCode"));
                    center.setCenterName(rs.getString("centerName"));
                    center.setPostalAddress(rs.getString("postalAddress"));
                    center.setPhone(rs.getString("phone"));
                    center.setCenterEmail(rs.getString("centerEmail"));
                    center.setGeneralDirectorName(rs.getString("generalDirectorName"));
                    center.setHrManager(rs.getString("hrManager"));
                    center.setAccountingManager(rs.getString("accountingManager"));
                    center.setSecretaryName(rs.getString("secretaryName"));
                    center.setLogo(rs.getString("logo"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return center;
    }

    public void updateCenter(Center center) {
        String sql = "UPDATE Center SET centerName = ?, postalAddress = ?, phone = ?, centerEmail = ?, " +
                "generalDirectorName = ?, hrManager = ?, accountingManager = ?, secretaryName = ?, logo = ? " +
                "WHERE centerCode = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, center.getCenterName());
            pstmt.setString(2, center.getPostalAddress());
            pstmt.setString(3, center.getPhone());
            pstmt.setString(4, center.getCenterEmail());
            pstmt.setString(5, center.getGeneralDirectorName());
            pstmt.setString(6, center.getHrManager());
            pstmt.setString(7, center.getAccountingManager());
            pstmt.setString(8, center.getSecretaryName());
            pstmt.setString(9, center.getLogo());
            pstmt.setString(10, center.getCenterCode());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCenter(String centerCode) {
        String sql = "DELETE FROM Center WHERE centerCode = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, centerCode);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


















}
