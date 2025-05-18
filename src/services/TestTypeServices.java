package services;


import dataBase.DataBaseConnection;
import models.TestType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestTypeServices {

    public void createTestType(TestType testType) {
        String sql = "INSERT INTO TestType (testType) VALUES (?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, testType.getTestType());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TestType obtainTestType(String type) {
        TestType testType = null;
        String sql = "SELECT * FROM TestType WHERE testType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, type);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    testType = new TestType();
                    testType.setTestType(rs.getString("testType"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testType;
    }

    public List<TestType> getAllTestTypes() {
        List<TestType> list = new ArrayList<>();
        String sql = "SELECT * FROM TestType";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TestType testType = new TestType();
                testType.setTestType(rs.getString("testType"));
                list.add(testType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateTestType(String oldType, String newType) {
        String sql = "UPDATE TestType SET testType = ? WHERE testType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newType);
            pstmt.setString(2, oldType);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTestType(String type) {
        String sql = "DELETE FROM TestType WHERE testType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, type);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
