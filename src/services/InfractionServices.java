package services;

import dataBase.DataBaseConnection;
import models.Infraction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class InfractionServices {

    public void createInfraction(Infraction infraction) {
        if (infraction != null) {
            if (!isDuplicated(infraction.getInfractionCode())){
                String sql = "INSERT INTO Infraction (infractionCode, licenseId, violationType, date, location, description, points, status) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (Connection conn = DataBaseConnection.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, infraction.getInfractionCode());
                    pstmt.setInt(2, infraction.getLicenseId());
                    pstmt.setString(3, infraction.getViolationType());
                    pstmt.setDate(4, infraction.getDate());
                    pstmt.setString(5, infraction.getLocation());
                    pstmt.setString(6, infraction.getDescription());
                    pstmt.setInt(7, infraction.getPoints());
                    pstmt.setString(8, infraction.getStatus());

                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new NullPointerException("The Infraction cannot be null");
        }

    }

    public Infraction obtainInfraction(String infractionCode) {
        Infraction infraction = null;
        String sql = "SELECT * FROM Infraction WHERE infractionCode = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, infractionCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    infraction = new Infraction();
                    infraction.setInfractionCode(rs.getString("infractionCode"));
                    infraction.setLicenseId(rs.getInt("licenseId"));
                    infraction.setViolationType(rs.getString("violationType"));
                    infraction.setDate(rs.getDate("date"));
                    infraction.setLocation(rs.getString("location"));
                    infraction.setDescription(rs.getString("description"));
                    infraction.setPoints(rs.getInt("points"));
                    infraction.setStatus(rs.getString("status"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return infraction;
    }

    public List<Infraction> getAllInfractions() {
        List<Infraction> list = new ArrayList<>();
        String sql = "SELECT * FROM Infraction";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Infraction infraction = new Infraction();
                infraction.setInfractionCode(rs.getString("infractionCode"));
                infraction.setLicenseId(rs.getInt("licenseId"));
                infraction.setViolationType(rs.getString("violationType"));
                infraction.setDate(rs.getDate("date"));
                infraction.setLocation(rs.getString("location"));
                infraction.setDescription(rs.getString("description"));
                infraction.setPoints(rs.getInt("points"));
                infraction.setStatus(rs.getString("status"));
                list.add(infraction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateInfraction(Infraction infraction) {
        if (infraction != null) {
            String sql = "UPDATE Infraction SET licenseId = ?, violationType = ?, date = ?, location = ?, description = ?, points = ?, status = ? " +
                    "WHERE infractionCode = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, infraction.getLicenseId());
                pstmt.setString(2, infraction.getViolationType());
                pstmt.setDate(3, infraction.getDate());
                pstmt.setString(4, infraction.getLocation());
                pstmt.setString(5, infraction.getDescription());
                pstmt.setInt(6, infraction.getPoints());
                pstmt.setString(7, infraction.getStatus());
                pstmt.setString(8, infraction.getInfractionCode());

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new NoSuchElementException("There is not record of a infraction with ID: " + infraction.getInfractionCode());

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("The Infraction cannot be null");
        }
    }

    public void deleteInfraction(String infractionCode) {
        if (infractionCode != null) {
            String sql = "DELETE FROM Infraction WHERE infractionCode = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, infractionCode);
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows == 0) {
                    throw new NoSuchElementException("There is not record of a infraction with ID: " + infractionCode);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("The Infraction cannot be null");
        }

    }

    public boolean isDuplicated(String infractionCode) {
        boolean isDuplicated = false;
        String sql = "Select * from infraction where infractioncode = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, infractionCode);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    isDuplicated = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDuplicated;
    }
}
