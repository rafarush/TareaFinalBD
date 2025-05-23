package services;


import dataBase.DataBaseConnection;
import models.TestType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TestTypeServices {

    public void createTestType(TestType testType) {
        if (testType == null) {
            throw new NullPointerException("The test type is null");
        }
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
        if (oldType == null || newType == null) {
            throw new NullPointerException("The test type is null");
        }
        String sql = "UPDATE TestType SET testType = ? WHERE testType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newType);
            pstmt.setString(2, oldType);
            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license category: " + oldType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTestType(String type) {
        if (type == null) {
            throw new NullPointerException("The test type is null");
        }
        String sql = "DELETE FROM TestType WHERE testType = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, type);
            int affectedrows = pstmt.executeUpdate();
            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license category: " + type);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
