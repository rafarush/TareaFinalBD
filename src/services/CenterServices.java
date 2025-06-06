package services;

import dataBase.DataBaseConnection;
import models.Center;
import java.sql.*;
import java.util.NoSuchElementException;

public class CenterServices {

    public void createCenter(Center center) throws Exception {
        if (center != null) {
            if (!isCenterCreated()){
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
            } else {
                throw new Exception("The center has already been created");
            }
        } else {
            throw new NullPointerException("The center cannot be null");
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

    public Center getCenter() {
        Center center = null;
        String sql = "SELECT * FROM Center LIMIT 1";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
        if (center != null) {
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

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new NoSuchElementException("There is not record of a center with ID: " + center.getCenterCode());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("The center cannot be null");
        }

    }

    public void deleteCenter(String centerCode) {
        if (centerCode != null) {
            String sql = "DELETE FROM Center WHERE centerCode = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, centerCode);
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new NoSuchElementException("There is not record of a center with ID: " + centerCode);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("The centerCode cannot be null");
        }

    }

//    public boolean validateDuplicate(String id) {
//        boolean isDuplicated = false;
//        String sql = "Select * from center where id = ?";
//        try (Connection conn = DataBaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, id);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    isDuplicated = true;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return isDuplicated;
//    }

    public boolean isCenterCreated() {
        boolean exists = false;
        String sql = "Select count(*) as quantity from center";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    exists = rs.getInt("quantity") > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }


















}
