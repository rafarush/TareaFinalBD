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



    public static void createCenterReport(String filePath) {
        String query = "SELECT centerCode, postalAddress, logo, centerEmail, phone, generalDirectorName, hrManager, accountingManager, secretaryName FROM Center";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             FileWriter writer = new FileWriter(filePath)) {

            writer.write("<html><head><title>Center Report</title></head><body>");
            writer.write("<h2>Driver Report</h2>");
            writer.write("<table border='1'>");
            writer.write("<tr><th>Center Code</th><th>Postal Address</th><th>Logo</th><th>Email</th><th>Phone</th><th>General Director</th><th>HR Manager</th><th>Accounting Manager</th><th>Secretary</th></tr>");

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
}

