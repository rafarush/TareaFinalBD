package services;

import dataBase.DataBaseConnection;
import models.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TestServices {

    public void createTest(Test test) {
        if (test == null) {
            throw new NullPointerException("The test is null");
        }
        String sql = "INSERT INTO Test (testCode, testType, date, result, entityName, examinerName, driverId, licensetype) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, test.getTestCode());
            pstmt.setString(2, test.getTestType());
            pstmt.setDate(3, test.getDate());
            pstmt.setBoolean(4, test.getResult());
            pstmt.setString(5, test.getEntityName());
            pstmt.setString(6, test.getExaminerName());
            pstmt.setString(7, test.getDriverId());
            pstmt.setString(8, test.getLicenseType());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Test obtainTest(String testCode) {
        Test test = null;
        String sql = "SELECT * FROM Test WHERE testCode = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, testCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    test = new Test();
                    test.setTestCode(rs.getString("testCode"));
                    test.setTestType(rs.getString("testType"));
                    test.setDate(rs.getDate("date"));
                    test.setResult(rs.getBoolean("result"));
                    test.setEntityName(rs.getString("entityName"));
                    test.setExaminerName(rs.getString("examinerName"));
                    test.setDriverId(rs.getString("driverId"));
                    test.setLicenseType(rs.getString("licensetype"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;
    }

    public List<Test> getAllTests() {
        List<Test> list = new ArrayList<>();
        String sql = "SELECT * FROM Test";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Test test = new Test();
                test.setTestCode(rs.getString("testCode"));
                test.setTestType(rs.getString("testType"));
                test.setDate(rs.getDate("date"));
                test.setResult(rs.getBoolean("result"));
                test.setEntityName(rs.getString("entityName"));
                test.setExaminerName(rs.getString("examinerName"));
                test.setDriverId(rs.getString("driverId"));
                test.setLicenseType(rs.getString("licensetype"));
                list.add(test);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateTest(Test test) {
        if (test == null) {
            throw new NullPointerException("The test is null");
        }
        String sql = "UPDATE Test SET testType = ?, date = ?, result = ?, entityName = ?, examinerName = ?, driverId = ?, licensetype = ? WHERE testCode = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, test.getTestType());
            pstmt.setDate(2, test.getDate());
            pstmt.setBoolean(3, test.getResult());
            pstmt.setString(4, test.getEntityName());
            pstmt.setString(5, test.getExaminerName());
            pstmt.setString(6, test.getDriverId());
            pstmt.setString(7, test.getTestCode());
            pstmt.setString(8, test.getLicenseType());

            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license category: " + test.getTestCode());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTest(String testCode) {
        if (testCode == null) {
            throw new NullPointerException("The test is null");
        }
        String sql = "DELETE FROM Test WHERE testCode = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, testCode);
            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license category: " + testCode);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected List<Test> getAllApprovedValidTests() {
        List<Test> list = new ArrayList<>();
        String sql = "SELECT * FROM test " +
                " WHERE driverid = 1 " +
                "  AND licensetype = 'A' " +
                "  AND date BETWEEN (current_date - INTERVAL '6 months') AND current_date " +
                "  AND result = true ";
        return getTestsFromDB(list, sql);
    }

    private List<Test> getTestsFromDB(List<Test> list, String sql) {
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Test test = new Test();
                test.setTestCode(rs.getString("testCode"));
                test.setTestType(rs.getString("testType"));
                test.setDate(rs.getDate("date"));
                test.setResult(rs.getBoolean("result"));
                test.setEntityName(rs.getString("entityName"));
                test.setExaminerName(rs.getString("examinerName"));
                test.setDriverId(rs.getString("driverId"));
                test.setLicenseType(rs.getString("licensetype"));
                list.add(test);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countTests() {
        int count = 0;
        String sql = "SELECT count(*) as quantity FROM test";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            if (rs.next()) {
                count = rs.getInt("quantity");
            } else {
                throw new NoSuchElementException("There is not record of a test");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
