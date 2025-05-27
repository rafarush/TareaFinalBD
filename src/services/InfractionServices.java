package services;

import dataBase.DataBaseConnection;
import models.Infraction;
import models.License;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
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
                    pstmt.setString(2, infraction.getLicenseId());
                    pstmt.setString(3, infraction.getViolationType());
                    pstmt.setDate(4, infraction.getDate());
                    pstmt.setString(5, infraction.getLocation());
                    pstmt.setString(6, infraction.getDescription());
                    pstmt.setInt(7, infraction.getPoints());
                    pstmt.setBoolean(8, infraction.getIspaid());

                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                //Checking for suspension or cancellation reasons
                checkForSuspension(infraction);
                // TODO
                // Look for cancellation reasons

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
                    infraction.setLicenseId(rs.getString("licenseId"));
                    infraction.setViolationType(rs.getString("violationType"));
                    infraction.setDate(rs.getDate("date"));
                    infraction.setLocation(rs.getString("location"));
                    infraction.setDescription(rs.getString("description"));
                    infraction.setPoints(rs.getInt("points"));
                    infraction.setIspaid(rs.getBoolean("status"));
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
                infraction.setLicenseId(rs.getString("licenseId"));
                infraction.setViolationType(rs.getString("violationType"));
                infraction.setDate(rs.getDate("date"));
                infraction.setLocation(rs.getString("location"));
                infraction.setDescription(rs.getString("description"));
                infraction.setPoints(rs.getInt("points"));
                infraction.setIspaid(rs.getBoolean("ispaid"));
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

                pstmt.setString(1, infraction.getLicenseId());
                pstmt.setString(2, infraction.getViolationType());
                pstmt.setDate(3, infraction.getDate());
                pstmt.setString(4, infraction.getLocation());
                pstmt.setString(5, infraction.getDescription());
                pstmt.setInt(6, infraction.getPoints());
                pstmt.setBoolean(7, infraction.getIspaid());
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

    public int countInfractions() {
        int count = 0;
        String sql = "SELECT count(*) as quantity FROM infraction";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            if (rs.next()) {
                count = rs.getInt("quantity");
            } else {
                throw new NoSuchElementException("There is not record of a infraction");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
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

    public ArrayList<Infraction> getRecentInfractions() {
        ArrayList<Infraction> list = new ArrayList<>();
        String sql = "SELECT * FROM infraction WHERE \"date\" BETWEEN (CURRENT_DATE - INTERVAL '1 week') AND CURRENT_DATE";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                Infraction infraction = new Infraction();
                infraction.setInfractionCode(rs.getString("infractionCode"));
                infraction.setLicenseId(rs.getString("licenseId"));
                infraction.setViolationType(rs.getString("violationType"));
                infraction.setDate(rs.getDate("date"));
                infraction.setLocation(rs.getString("location"));
                infraction.setDescription(rs.getString("description"));
                infraction.setPoints(rs.getInt("points"));
                infraction.setIspaid(rs.getBoolean("ispaid"));
                list.add(infraction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return list;
    }

    private ArrayList<Infraction> get6MonthsNotPaidInfractions(){
        String sql = "SELECT * " +
                " FROM infraction " +
                " WHERE infraction.\"date\" < ( CURRENT_DATE - INTERVAL '6 months' ) AND infraction.ispaid = FALSE";
        ArrayList<Infraction> ls = new ArrayList<>();
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                Infraction infraction = new Infraction();
                infraction.setInfractionCode(rs.getString("infractionCode"));
                infraction.setLicenseId(rs.getString("licenseId"));
                infraction.setViolationType(rs.getString("violationType"));
                infraction.setDate(rs.getDate("date"));
                infraction.setLocation(rs.getString("location"));
                infraction.setDescription(rs.getString("description"));
                infraction.setPoints(rs.getInt("points"));
                infraction.setIspaid(rs.getBoolean("ispaid"));
                ls.add(infraction);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ls;
    }

    private void checkForSuspension(Infraction infraction) {
        String licenseId = infraction.getLicenseId();
        License license = ServicesLocator.getInstance().getLicenseServices().obtainLicense(licenseId);

        // Searching for two major infractions
        if(infraction.getViolationType().equalsIgnoreCase("Muy Grave"))
            if (searchForTwoMajorInfraction(licenseId))
                ServicesLocator.getInstance().getLicenseServices().changeLicenceStatus(license, "Suspendida");


        // Checks if the license points has reached the limit
        license = ServicesLocator.getInstance().getLicenseServices().obtainLicense(licenseId);
        if (!license.getLicenseStatus().equalsIgnoreCase("Suspendida"))
            checkLicensePoints(licenseId);

    }

    private void checkLicensePoints(String licenseId) {
        if (licenseId == null) {
            throw new NullPointerException("The license ID cannot be null");
        }
        String sql = "SELECT sum(points) FROM infraction WHERE licenseid = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery(sql)){

            pstmt.setString(1, licenseId);
            if (rs.next()) {
                License license = ServicesLocator.getInstance().getLicenseServices().obtainLicense(licenseId);
                int currentPoints = rs.getInt("sum(points)");
                changeStatusOnYears(currentPoints, license);

            }else{
                throw new NoSuchElementException("There is not record of a infraction with ID: " + licenseId);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void changeStatusOnYears(int currentPoints, License license){
        LocalDate issueDate = license.getIssueDate().toLocalDate();
        LocalDate now = LocalDate.now();
        if (ChronoUnit.YEARS.between(issueDate, now) < 1) {
            if (currentPoints >= 24){
                ServicesLocator.getInstance().getLicenseServices().changeLicenceStatus(license, "Suspendida");
            }
        }else{
            if (currentPoints >= 32){
                ServicesLocator.getInstance().getLicenseServices().changeLicenceStatus(license, "Suspendida");
            }
        }
    }

    private boolean searchForTwoMajorInfraction(String licenseId) {
        if (licenseId == null) {
            throw new NullPointerException("The license ID cannot be null");
        }
        boolean found = false;
        String sql = "SELECT COUNT(*) AS quantity FROM infraction WHERE violationtype = 'Muy Grave' AND licenseid = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery(sql)){

            pstmt.setString(1, licenseId);
            if (rs.next()) {
                License license = ServicesLocator.getInstance().getLicenseServices().obtainLicense(licenseId);
                int quantity = rs.getInt("quantity");
                if (quantity == 2) {
                    found = true;
                }

            }else{
                throw new NoSuchElementException("There is not record of a infraction with ID: " + licenseId);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return found;
    }

}
