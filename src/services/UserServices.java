package services;

import dataBase.DataBaseConnection;
import models.Role;
import models.User;
import utils.PasswordUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserServices {

    public void createUser(User user) {
        if (user != null && user.getRole() != null) {
            String sql = "INSERT INTO \"user\" (username, password, role) VALUES (?, ?, ?)";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, PasswordUtil.hashPassword(user.getPassword()));
                pstmt.setString(3, user.getRole());

                pstmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("User or Role is null");
        }
    }

    public User getUser(String username) {
        User user = null;
        String sql = "SELECT * FROM \"user\" WHERE username = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM \"user\"";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateUser(User user) {
        if (user != null && user.getRole() != null) {
            String sql = "UPDATE \"user\" SET password = ?, role = ? WHERE username = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, PasswordUtil.hashPassword(user.getPassword()));
                pstmt.setString(2, user.getRole());
                pstmt.setString(3, user.getUsername());

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new NoSuchElementException("No user found with username: " + user.getUsername());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("User or Role is null");
        }
    }

    public void deleteUser(String username) {
        String sql = "DELETE FROM \"user\" WHERE username = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new NoSuchElementException("No user found with username: " + username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

