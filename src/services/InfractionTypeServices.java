package services;

import dataBase.DataBaseConnection;
import models.InfractionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InfractionTypeServices {

    public void createInfractionType(InfractionType infractionType) {
        String sql = "INSERT INTO InfractionType (infractionType) VALUES (?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, infractionType.getInfractionType());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public InfractionType obtainInfractionType(String infractionTypeStr) {
        InfractionType infractionType = null;
        String sql = "SELECT * FROM InfractionType WHERE infractionType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, infractionTypeStr);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    infractionType = new InfractionType();
                    infractionType.setInfractionType(rs.getString("infractionType"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return infractionType;
    }

    public List<InfractionType> getAllInfractionTypes() {
        List<InfractionType> list = new ArrayList<>();
        String sql = "SELECT * FROM InfractionType";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                InfractionType infractionType = new InfractionType();
                infractionType.setInfractionType(rs.getString("infractionType"));
                list.add(infractionType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateInfractionType(InfractionType infractionType, String oldInfractionType) {
        String sql = "UPDATE InfractionType SET infractionType = ? WHERE infractionType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, infractionType.getInfractionType());
            pstmt.setString(2, oldInfractionType);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInfractionType(String infractionTypeStr) {
        String sql = "DELETE FROM InfractionType WHERE infractionType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, infractionTypeStr);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
