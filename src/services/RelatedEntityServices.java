package services;

import dataBase.DataBaseConnection;
import models.RelatedEntity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RelatedEntityServices {

    public void createRelatedEntity(RelatedEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("The related entity cannot be null");
        }
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
        if (entity == null) {
            throw new IllegalArgumentException("The related entity cannot be null");
        }
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
            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license category: " + entity.getEntityName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRelatedEntity(String entityName) {
        if (entityName == null) {
            throw new IllegalArgumentException("The related entity cannot be null");
        }
        String sql = "DELETE FROM RelatedEntity WHERE entityName = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entityName);
            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license category: " + entityName);
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException("No se puede eliminar esta entidad al estar relacionada con varios examenes.");
        }
    }


    public List<RelatedEntity> getAllEntityByType(String entityType) {
        List<RelatedEntity> allEntities = new ArrayList<>();
        RelatedEntity entity = null;
        String sql = "SELECT * FROM RelatedEntity WHERE entityType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, entityType);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    entity = new RelatedEntity();
                    entity.setEntityName(rs.getString("entityName"));
                    entity.setEntityType(rs.getString("entityType"));
                    entity.setAddress(rs.getString("address"));
                    entity.setPhone(rs.getString("phone"));
                    entity.setContactEmail(rs.getString("contactEmail"));
                    entity.setDirectorName(rs.getString("directorName"));
                    entity.setCenterCode(rs.getString("centerCode"));
                    allEntities.add(entity);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEntities;
    }


}
