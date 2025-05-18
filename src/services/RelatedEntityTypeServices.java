package services;

import dataBase.DataBaseConnection;
import models.RelatedEntityType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatedEntityTypeServices {



    public static void insertRelatedEntityType( RelatedEntityType entityType)  {
        String sql = "INSERT INTO RelatedEntityType (relatedEntityType) VALUES (?)";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entityType.getRelatedEntityType());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RelatedEntityType obtainRelatedEntityType(String relatedEntityType) {
        RelatedEntityType entityType = null;
        String sql = "SELECT * FROM RelatedEntityType WHERE relatedEntityType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, relatedEntityType);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    entityType = new RelatedEntityType();
                    entityType.setRelatedEntityType(rs.getString("relatedEntityType"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entityType;
    }

    public List<RelatedEntityType> getAllRelatedEntityTypes() {
        List<RelatedEntityType> list = new ArrayList<>();
        String sql = "SELECT * FROM RelatedEntityType";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                RelatedEntityType entityType = new RelatedEntityType();
                entityType.setRelatedEntityType(rs.getString("relatedEntityType"));
                list.add(entityType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateRelatedEntityType(String oldRelatedEntityType, RelatedEntityType newEntityType) {
        String sql = "UPDATE RelatedEntityType SET relatedEntityType = ? WHERE relatedEntityType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newEntityType.getRelatedEntityType());
            pstmt.setString(2, oldRelatedEntityType);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRelatedEntityType(String relatedEntityType) {
        String sql = "DELETE FROM RelatedEntityType WHERE relatedEntityType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, relatedEntityType);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

