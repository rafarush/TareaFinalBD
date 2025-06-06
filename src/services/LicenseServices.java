package services;

import dataBase.DataBaseConnection;
import models.Infraction;
import models.License;
import models.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LicenseServices {

    public void createLicense(License license) {
        if (license != null) {
            if (is_valid(license)) {
                String sql = "INSERT INTO License (licenseId, driverId, licenseType, issueDate, expirationDate, restrictions, renewed, licenseStatus) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (Connection conn = DataBaseConnection.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(sql)) {

                    pstmt.setString(1, license.getLicenseId());
                    pstmt.setString(2, license.getDriverId());
                    pstmt.setString(3, license.getLicenseType());
                    pstmt.setDate(4, license.getIssueDate());
                    pstmt.setDate(5, license.getExpirationDate());
                    pstmt.setString(6, license.getRestrictions());
                    pstmt.setBoolean(7, license.isRenewed());
                    pstmt.setString(8, license.getLicenseStatus());

                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                throw new IllegalArgumentException("License not valid");
            }

        } else {
            throw new NullPointerException("License is null");
        }
    }

    public License obtainLicense(String licenseId) {
        License license = null;
        String sql = "SELECT * FROM License WHERE licenseId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, licenseId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    license = new License();
                    license.setLicenseId(rs.getString("licenseId"));
                    license.setDriverId(rs.getString("driverId"));
                    license.setLicenseType(rs.getString("licenseType"));
                    license.setIssueDate(rs.getDate("issueDate"));
                    license.setExpirationDate(rs.getDate("expirationDate"));
                    license.setRestrictions(rs.getString("restrictions"));
                    license.setRenewed(rs.getBoolean("renewed"));
                    license.setLicenseStatus(rs.getString("licenseStatus"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return license;
    }

    public List<License> getAllLicenses() {
        List<License> list = new ArrayList<>();
        String sql = "SELECT * FROM License";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                License license = new License();
                license.setLicenseId(rs.getString("licenseId"));
                license.setDriverId(rs.getString("driverId"));
                license.setLicenseType(rs.getString("licenseType"));
                license.setIssueDate(rs.getDate("issueDate"));
                license.setExpirationDate(rs.getDate("expirationDate"));
                license.setRestrictions(rs.getString("restrictions"));
                license.setRenewed(rs.getBoolean("renewed"));
                license.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(license);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }




    public List<License> getAllLicensesWithDriverName() {
        List<License> list = new ArrayList<>();
        String sql = "SELECT l.*, d.firstname AS name FROM License l JOIN Driver d ON l.driverid = d.driverid ";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                License license = new License();
                license.setLicenseId(rs.getString("licenseId"));
                license.setDriverId(rs.getString("name"));
                license.setLicenseType(rs.getString("licenseType"));
                license.setIssueDate(rs.getDate("issueDate"));
                license.setExpirationDate(rs.getDate("expirationDate"));
                license.setRestrictions(rs.getString("restrictions"));
                license.setRenewed(rs.getBoolean("renewed"));
                license.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(license);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }




    public List<License> getAllLicensesRevocated() {
        List<License> list = new ArrayList<>();
        String sql = "SELECT DISTINCT l.* \n" +
                "FROM license l \n" +
                "JOIN infraction i ON l.licenseid = i.licenseid \n" +
                "WHERE l.licensestatus != 'Revocada' \n" +
                "AND i.\"date\" < CURRENT_DATE - INTERVAL '6 months' \n" +
                "AND i.ispaid = FALSE" ;
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                License license = new License();
                license.setLicenseId(rs.getString("licenseId"));
                license.setDriverId(rs.getString("driverId"));
                license.setLicenseType(rs.getString("licenseType"));
                license.setIssueDate(rs.getDate("issueDate"));
                license.setExpirationDate(rs.getDate("expirationDate"));
                license.setRestrictions(rs.getString("restrictions"));
                license.setRenewed(rs.getBoolean("renewed"));
                license.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(license);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<License> getAllLicensesNotRevocated() {
        List<License> list = new ArrayList<>();
        String sql = "SELECT DISTINCT l.* \n" +
                "FROM license l \n" +
                "WHERE l.licensestatus != 'Revocada' AND l.licensestatus != 'Vencida'  \n";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                License license = new License();
                license.setLicenseId(rs.getString("licenseId"));
                license.setDriverId(rs.getString("driverId"));
                license.setLicenseType(rs.getString("licenseType"));
                license.setIssueDate(rs.getDate("issueDate"));
                license.setExpirationDate(rs.getDate("expirationDate"));
                license.setRestrictions(rs.getString("restrictions"));
                license.setRenewed(rs.getBoolean("renewed"));
                license.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(license);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<License> getAllLicensesExpirated() {
        List<License> list = new ArrayList<>();
        String sql = "SELECT \n" +
                "  * \n" +
                "FROM \n" +
                "  license \n" +
                "WHERE \n" +
                "  expirationdate < CURRENT_DATE \n" +
                "  AND licensestatus = 'Vigente'" ;
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                License license = new License();
                license.setLicenseId(rs.getString("licenseId"));
                license.setDriverId(rs.getString("driverId"));
                license.setLicenseType(rs.getString("licenseType"));
                license.setIssueDate(rs.getDate("issueDate"));
                license.setExpirationDate(rs.getDate("expirationDate"));
                license.setRestrictions(rs.getString("restrictions"));
                license.setRenewed(rs.getBoolean("renewed"));
                license.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(license);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateLicense(License license) {
        if (license != null) {
            String sql = "UPDATE License SET driverId = ?, licenseType = ?, issueDate = ?, expirationDate = ?, " +
                    "restrictions = ?, renewed = ?, licenseStatus = ? WHERE licenseId = ?";
            try (Connection conn = DataBaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, license.getDriverId());
                pstmt.setString(2, license.getLicenseType());
                pstmt.setDate(3, license.getIssueDate());
                pstmt.setDate(4, license.getExpirationDate());
                pstmt.setString(5, license.getRestrictions());
                pstmt.setBoolean(6, license.isRenewed());
                pstmt.setString(7, license.getLicenseStatus());
                pstmt.setString(8, license.getLicenseId());

                int affectedrows = pstmt.executeUpdate();

                if (affectedrows == 0) {
                    throw new NoSuchElementException("There is not record of the license: " + license.getLicenseId());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NullPointerException("License is null");
        }

    }

    public void deleteLicense(String licenseId) {
        String sql = "DELETE FROM License WHERE licenseId = ?";
        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, licenseId);
            int affectedrows = pstmt.executeUpdate();

            if (affectedrows == 0) {
                throw new NoSuchElementException("There is not record of the license: " + licenseId);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void changeLicenceStatus(License license, String status) {
        if (license == null || status == null) {
            throw new NullPointerException("License or status is null");
        }
        switch (status) {
            case "Suspendida":
                license.setLicenseStatus("Suspendida");
                break;
            case "Vigente":
                license.setLicenseStatus("Vigente");
                break;
            case "Vencida":
                license.setLicenseStatus("Vencida");
                break;
            case "Revocada":
                license.setLicenseStatus("Revocada");
                break;
            default:
                throw new IllegalArgumentException("License status is not valid");
        }
        updateLicense(license);
    }

    public int countLicenses() {
        int count = 0;
        String sql = "SELECT count(*) as quantity FROM license";
        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            if (rs.next()) {
                count = rs.getInt("quantity");
            } else {
                throw new NoSuchElementException("There is not record of a license");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    private boolean is_valid(License license) {
        boolean is_valid = false;
        boolean theoric = false;
        boolean practical = false;
        boolean medical = false;

        List<Test> tests = new ArrayList<>();
        tests = ServicesLocator.getInstance().getTestServices().getAllApprovedValidTests(license.getDriverId(), license.getLicenseType());


        int i = 0;
        while (i<tests.size() && !is_valid) {
            String testType = tests.get(i).getTestType();
            if (testType.equalsIgnoreCase("Teorico")) {
                theoric = true;
            }else if (testType.equalsIgnoreCase("Practico")) {
                practical = true;
            }else if (testType.equalsIgnoreCase("Medico")) {
                medical = true;
            }
            if (theoric && practical && medical) {
                is_valid = true;
            }
            i++;
        }

        return is_valid;
    }

    public ArrayList<License> getAlmostExpiredLicenses() {
        ArrayList<License> list = new ArrayList<>();
        String sql = "SELECT * FROM license WHERE expirationdate BETWEEN CURRENT_DATE AND ( CURRENT_DATE + INTERVAL '6 months' )";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                License license = new License();
                license.setLicenseId(rs.getString("licenseId"));
                license.setDriverId(rs.getString("driverId"));
                license.setLicenseType(rs.getString("licenseType"));
                license.setIssueDate(rs.getDate("issueDate"));
                license.setExpirationDate(rs.getDate("expirationDate"));
                license.setRestrictions(rs.getString("restrictions"));
                license.setRenewed(rs.getBoolean("renewed"));
                license.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(license);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    private void expireLicense() {
        ArrayList<License> licenses = (ArrayList<License>) ServicesLocator.getInstance().getLicenseServices().getAllLicensesExpirated();
        for (License license : licenses) {
            changeLicenceStatus(license, "Vencida");
        }
    }

    private void cancelLicensesWithInfractionsNotPaid(){
        ArrayList<License> licenses = (ArrayList<License>) ServicesLocator.getInstance().getLicenseServices().getAllLicensesRevocated();
        for (License license : licenses) {
            changeLicenceStatus(license, "Revocada");
        }
    }

    private ArrayList<License> getRenewableLicensesWithExpiredInfractions(){
        ArrayList<License> list = new ArrayList<>();
        String sql = "SELECT DISTINCT l.* \n" +
                " FROM license l \n" +
                " JOIN infraction i ON l.licenseid = i.licenseid \n" +
                " WHERE l.licensestatus = 'Suspendida' \n" +
                "  AND i.ispaid = TRUE \n" +
                "  AND l.licenseid IN (\n" +
                "    SELECT licenseid \n" +
                "    FROM infraction \n" +
                "    GROUP BY licenseid \n" +
                "    HAVING MAX(date) < CURRENT_DATE - INTERVAL '6 months' \n" +
                "  );\n";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                License license = new License();
                license.setLicenseId(rs.getString("licenseId"));
                license.setDriverId(rs.getString("driverId"));
                license.setLicenseType(rs.getString("licenseType"));
                license.setIssueDate(rs.getDate("issueDate"));
                license.setExpirationDate(rs.getDate("expirationDate"));
                license.setRestrictions(rs.getString("restrictions"));
                license.setRenewed(rs.getBoolean("renewed"));
                license.setLicenseStatus(rs.getString("licenseStatus"));
                list.add(license);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    private void renewLicensesWithExpiredInfractions(){
        ArrayList<License> list = getRenewableLicensesWithExpiredInfractions();
        for (License license : list) {
            changeLicenceStatus(license, "Vigente");
        }
    }

    public void refreshLicesesData() {
        long startTime = System.nanoTime();  // tiempo inicial

        cancelLicensesWithInfractionsNotPaid();


        long endTime = System.nanoTime();    // tiempo final
        long durationInMillis = (endTime - startTime) / 1_000_000;  // convertir a milisegundos

        System.out.println("cancel Liceses data refreshed");
        System.out.println("Tiempo de ejecución: " + durationInMillis + " ms");

        startTime = System.nanoTime();  // tiempo inicial

        renewLicensesWithExpiredInfractions();

        endTime = System.nanoTime();    // tiempo final
        durationInMillis = (endTime - startTime) / 1_000_000;  // convertir a milisegundos

        System.out.println("Renova Liceses data refreshed");
        System.out.println("Tiempo de ejecución: " + durationInMillis + " ms");


        startTime = System.nanoTime();  // tiempo inicial

        expireLicense();

        endTime = System.nanoTime();    // tiempo final
        durationInMillis = (endTime - startTime) / 1_000_000;  // convertir a milisegundos

        System.out.println("Renova Liceses data refreshed");
        System.out.println("Tiempo de ejecución: " + durationInMillis + " ms");
    }


    public boolean hasPassedAllTestsInLast6Months(String driverId, String licenseType) {
        String sql = """
        SELECT COUNT(DISTINCT t.testtype) AS passed_count
        FROM test t
        WHERE t.driverid = ?
          AND t.licensetype = ?
          AND t.result = TRUE
          AND t.date >= CURRENT_DATE - INTERVAL '6 months'
          AND t.testtype IN ('Teorico', 'Practico', 'Medico')
        """;

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, driverId);
            pstmt.setString(2, licenseType);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("passed_count");
                    return count == 3;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}
