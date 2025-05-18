package services;

import dataBase.DataBaseConnection;
import models.RelatedEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelatedEntityServices {

    public void createRelatedEntity(RelatedEntity entity) {
        String sql = "INSERT INTO RelatedEntity (entityName, entityType, address, phone, contactEmail, directorName, centerCode) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entity.getEntityName());
            pstmt.setString(2, entity.getEntityType());
            pstmt.setString(3, entity.getAddress());
            pstmt.setString(4, entity.getPhone());
            pstmt.setString(5, entity.getContactEmail());
            pstmt.setString(6, entity.getDirectorName());
            pstmt.setString(7, entity.getCenterCode());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RelatedEntity obtainRelatedEntity(String entityName) {
        RelatedEntity entity = null;
        String sql = "SELECT * FROM RelatedEntity WHERE entityName = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entityName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    entity = new RelatedEntity();
                    entity.setEntityName(rs.getString("entityName"));
                    entity.setEntityType(rs.getString("entityType"));
                    entity.setAddress(rs.getString("address"));
                    entity.setPhone(rs.getString("phone"));
                    entity.setContactEmail(rs.getString("contactEmail"));
                    entity.setDirectorName(rs.getString("directorName"));
                    entity.setCenterCode(rs.getString("centerCode"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public List<RelatedEntity> getAllRelatedEntities() {
        List<RelatedEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM RelatedEntity";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                RelatedEntity entity = new RelatedEntity();
                entity.setEntityName(rs.getString("entityName"));
                entity.setEntityType(rs.getString("entityType"));
                entity.setAddress(rs.getString("address"));
                entity.setPhone(rs.getString("phone"));
                entity.setContactEmail(rs.getString("contactEmail"));
                entity.setDirectorName(rs.getString("directorName"));
                entity.setCenterCode(rs.getString("centerCode"));
                list.add(entity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateRelatedEntity(RelatedEntity entity) {
        String sql = "UPDATE RelatedEntity SET entityType = ?, address = ?, phone = ?, contactEmail = ?, " +
                "directorName = ?, centerCode = ? WHERE entityName = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entity.getEntityType());
            pstmt.setString(2, entity.getAddress());
            pstmt.setString(3, entity.getPhone());
            pstmt.setString(4, entity.getContactEmail());
            pstmt.setString(5, entity.getDirectorName());
            pstmt.setString(6, entity.getCenterCode());
            pstmt.setString(7, entity.getEntityName());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRelatedEntity(String entityName) {
        String sql = "DELETE FROM RelatedEntity WHERE entityName = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entityName);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
