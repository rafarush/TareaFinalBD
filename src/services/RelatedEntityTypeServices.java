package services;

import dataBase.DataBaseConnection;
import models.RelatedEntityType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RelatedEntityTypeServices {



    public static void insertRelatedEntityType( RelatedEntityType entityType)  {
        if (entityType == null) {
            throw new NullPointerException("entityType is null");
        }
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
        if (oldRelatedEntityType == null || newEntityType == null) {
            throw new NullPointerException("oldRelatedEntityType or newEntityType is null");
        }
        String sql = "UPDATE RelatedEntityType SET relatedEntityType = ? WHERE relatedEntityType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newEntityType.getRelatedEntityType());
            pstmt.setString(2, oldRelatedEntityType);
            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license category: " + oldRelatedEntityType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRelatedEntityType(String relatedEntityType) {
        if (relatedEntityType == null) {
            throw new NullPointerException("relatedEntityType is null");
        }
        String sql = "DELETE FROM RelatedEntityType WHERE relatedEntityType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, relatedEntityType);
            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license category: " + relatedEntityType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

