package services;

import dataBase.DataBaseConnection;
import models.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleServices {

    public void createRole(Role role) {
        if (role != null) {
            String sql = "INSERT INTO role (role) VALUES (?)";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, role.getRole());
                pstmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("Role is null");
        }
    }

    public Role getRole(String roleName) {
        Role role = null;
        String sql = "SELECT * FROM role WHERE role = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, roleName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    role = new Role(rs.getString("role"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public List<Role> getAllRoles() {
        List<Role> list = new ArrayList<>();
        String sql = "SELECT * FROM role";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Role(rs.getString("role")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteRole(String roleName) {
        String sql = "DELETE FROM role WHERE role = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, roleName);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

