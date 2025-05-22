package report;

import dataBase.DataBaseConnection;


import dataBase.DataBaseConnection;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class HTMLReportGenerator {

    public static void createHTMLReport(String filePath, String title, String[] headers, String[][] data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("<html><head><title>" + title + "</title></head><body>");
            writer.write("<h1>" + title + "</h1>");
            writer.write("<table border='1' cellpadding='5' cellspacing='0'>");

            // Crear fila de encabezados
            writer.write("<tr>");
            for (String header : headers) {
                writer.write("<th>" + header + "</th>");
            }
            writer.write("</tr>");

            // Agregar filas de datos
            for (String[] row : data) {
                writer.write("<tr>");
                for (String cell : row) {
                    writer.write("<td>" + cell + "</td>");
                }
                writer.write("</tr>");
            }

            writer.write("</table>");
            writer.write("</body></html>");
        }

    }



    public static void createCenterReport() {
        String filePath = "src\\report\\centerReporte.html";
        String query = "SELECT centerCode, postalAddress, logo, centerEmail, phone, generalDirectorName, hrManager, accountingManager, secretaryName FROM Center";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             FileWriter writer = new FileWriter(filePath)) {

            writer.write("<html><head><title>Reporte de Centro</title>");
            writer.write("<style>");
            writer.write("body { font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px; }");
            writer.write("h2 { text-align: center; color: #333; }");
            writer.write("table { width: 100%; border-collapse: collapse; background-color: #fff; }");
            writer.write("th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }");
            writer.write("th { background-color: #007acc; color: white; }");
            writer.write("tr:nth-child(even) { background-color: #f2f2f2; }");
            writer.write("</style>");
            writer.write("</head><body>");
            writer.write("<h2>Reporte de Centro</h2>");
            writer.write("<table>");
            writer.write("<tr><th>Código del Centro</th><th>Dirección Postal</th><th>Logo</th><th>Email</th><th>Teléfono</th><th>Director General</th><th>Gerente de RRHH</th><th>Gerente de Contabilidad</th><th>Secretario</th></tr>");

            while (rs.next()) {
                writer.write("<tr>");
                writer.write("<td>" + rs.getString("centerCode") + "</td>");
                writer.write("<td>" + rs.getString("postalAddress") + "</td>");
                writer.write("<td>" + rs.getString("logo") + "</td>");
                writer.write("<td>" + rs.getString("centerEmail") + "</td>");
                writer.write("<td>" + rs.getString("phone") + "</td>");
                writer.write("<td>" + rs.getString("generalDirectorName") + "</td>");
                writer.write("<td>" + rs.getString("hrManager") + "</td>");
                writer.write("<td>" + rs.getString("accountingManager") + "</td>");
                writer.write("<td>" + rs.getString("secretaryName") + "</td>");
                writer.write("</tr>");
            }

            writer.write("</table></body></html>");
            System.out.println("Reporte generado correctamente en: " + filePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }



    public static void createDriverReport(int driverId) {

        String filePath = "src\\report\\driverReporte.html";
        String driverQuery = "SELECT firstName, lastName, birthDate, address, phone, email FROM Driver WHERE driverId = ?";
        String licensesQuery = "SELECT licenseType, issueDate, expirationDate, restrictions, renewed, licenseStatus FROM License WHERE driverId = ?";
        String infractionsQuery = "SELECT violationType, date, points FROM Infraction i JOIN License l ON i.licenseId = l.licenseId WHERE l.driverId = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement driverStmt = conn.prepareStatement(driverQuery);
             PreparedStatement licensesStmt = conn.prepareStatement(licensesQuery);
             PreparedStatement infractionsStmt = conn.prepareStatement(infractionsQuery);
             FileWriter writer = new FileWriter(filePath)) {

            driverStmt.setInt(1, driverId);
            licensesStmt.setInt(1, driverId);
            infractionsStmt.setInt(1, driverId);

            ResultSet driverRs = driverStmt.executeQuery();

            writer.write("<html><head><title>Reporte de Conductor</title>");
            writer.write("<style>");
            writer.write("body { font-family: Arial, sans-serif; background: #f9f9f9; padding: 20px; }");
            writer.write("h2, h3 { color: #004080; }");
            writer.write("table { border-collapse: collapse; width: 100%; background: white; margin-bottom: 20px; }");
            writer.write("th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }");
            writer.write("th { background-color: #007acc; color: white; }");
            writer.write("tr:nth-child(even) { background-color: #f2f2f2; }");
            writer.write("</style>");
            writer.write("</head><body>");
            writer.write("<h2>Reporte de Conductor</h2>");

            if (driverRs.next()) {
                writer.write("<h3>Información del Conductor</h3>");
                writer.write("<table>");
                writer.write("<tr><th>Nombre</th><td>" + driverRs.getString("firstName") + " " + driverRs.getString("lastName") + "</td></tr>");
                writer.write("<tr><th>Fecha de Nacimiento</th><td>" + driverRs.getDate("birthDate") + "</td></tr>");
                writer.write("<tr><th>Dirección</th><td>" + driverRs.getString("address") + "</td></tr>");
                writer.write("<tr><th>Teléfono</th><td>" + driverRs.getString("phone") + "</td></tr>");
                writer.write("<tr><th>Email</th><td>" + driverRs.getString("email") + "</td></tr>");
                writer.write("</table>");

                writer.write("<h3>Licencias Emitidas</h3>");
                writer.write("<table>");
                writer.write("<tr><th>Tipo</th><th>Fecha de Emisión</th><th>Fecha de Vencimiento</th><th>Restricciones</th><th>Renovada</th><th>Estado</th></tr>");
                ResultSet licensesRs = licensesStmt.executeQuery();
                while (licensesRs.next()) {
                    writer.write("<tr>");
                    writer.write("<td>" + licensesRs.getString("licenseType") + "</td>");
                    writer.write("<td>" + licensesRs.getDate("issueDate") + "</td>");
                    writer.write("<td>" + licensesRs.getDate("expirationDate") + "</td>");
                    writer.write("<td>" + licensesRs.getString("restrictions") + "</td>");
                    writer.write("<td>" + (licensesRs.getBoolean("renewed") ? "Sí" : "No") + "</td>");
                    writer.write("<td>" + licensesRs.getString("licenseStatus") + "</td>");
                    writer.write("</tr>");
                }
                writer.write("</table>");

                writer.write("<h3>Infracciones Registradas</h3>");
                writer.write("<table>");
                writer.write("<tr><th>Tipo de Infracción</th><th>Fecha</th><th>Puntos</th></tr>");
                ResultSet infractionsRs = infractionsStmt.executeQuery();
                while (infractionsRs.next()) {
                    writer.write("<tr>");
                    writer.write("<td>" + infractionsRs.getString("violationType") + "</td>");
                    writer.write("<td>" + infractionsRs.getDate("date") + "</td>");
                    writer.write("<td>" + infractionsRs.getInt("points") + "</td>");
                    writer.write("</tr>");
                }
                writer.write("</table>");

            } else {
                writer.write("<p>No se encontró ningún conductor con ID: " + driverId + "</p>");
            }

            writer.write("</body></html>");

            System.out.println("Reporte de conductor generado en: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void createRelatedEntityReport(String entityName) {
        String filePath="src\\report\\relatedEntityReporte.html";

        String query = "SELECT entityName, entityType, address, phone, contactEmail, directorName, centerCode FROM RelatedEntity WHERE entityName = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             FileWriter writer = new FileWriter(filePath)) {

            stmt.setString(1, entityName);
            ResultSet rs = stmt.executeQuery();

            writer.write("<html><head><title>Related Entity Report</title>");
            writer.write("<style>");
            writer.write("body { font-family: Arial, sans-serif; background: #f9f9f9; padding: 20px; }");
            writer.write("h2 { color: #004080; }");
            writer.write("table { border-collapse: collapse; width: 100%; background: white; }");
            writer.write("th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }");
            writer.write("th { background-color: #007acc; color: white; }");
            writer.write("tr:nth-child(even) { background-color: #f2f2f2; }");
            writer.write("</style>");
            writer.write("</head><body>");
            writer.write("<h2>Ficha de Entidad Asociada</h2>");

            if (rs.next()) {
                writer.write("<table>");
                writer.write("<tr><th>Nombre</th><td>" + rs.getString("entityName") + "</td></tr>");
                writer.write("<tr><th>Tipo</th><td>" + rs.getString("entityType") + "</td></tr>");
                writer.write("<tr><th>Dirección</th><td>" + rs.getString("address") + "</td></tr>");
                writer.write("<tr><th>Teléfono</th><td>" + rs.getString("phone") + "</td></tr>");
                writer.write("<tr><th>Email</th><td>" + rs.getString("contactEmail") + "</td></tr>");
                writer.write("<tr><th>Director</th><td>" + rs.getString("directorName") + "</td></tr>");
                writer.write("<tr><th>Código del Centro</th><td>" + rs.getString("centerCode") + "</td></tr>");
                writer.write("</table>");
            } else {
                writer.write("<p>No se encontró ninguna entidad con el nombre: " + entityName + "</p>");
            }

            writer.write("</body></html>");

            System.out.println("Reporte de Entidad Asociada generado en: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}

