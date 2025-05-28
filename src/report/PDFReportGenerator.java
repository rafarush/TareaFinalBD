package report;

import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import dataBase.DataBaseConnection;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;



import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;


public class PDFReportGenerator {

    public static String createCenterReportPDF() {
        String pdfPath = "reportsPDF\\centerReporte.pdf";
        String query = "SELECT centerName, postalAddress, logo, centerEmail, phone, generalDirectorName, hrManager, accountingManager, secretaryName FROM Center LIMIT 1";

        try (Connection conn = DataBaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, new Color(0, 122, 204));
            Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 11, Color.BLACK);

            Paragraph title = new Paragraph("Reporte de Centro", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            if (rs.next()) {
                String basePath = System.getProperty("user.dir");
                String logoPath = basePath + File.separator + "src" + File.separator + "utils" + File.separator + "logos" + File.separator + "PFBD.png";

                try {
                    Image logo = Image.getInstance(logoPath);
                    logo.scaleToFit(200, 100);
                    logo.setAlignment(Element.ALIGN_CENTER);
                    document.add(logo);
                    document.add(Chunk.NEWLINE);
                } catch (Exception e) {
                    System.out.println("No se pudo cargar la imagen del logo: " + logoPath);
                    e.printStackTrace();
                }

                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(80);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);
                table.setWidths(new float[]{3f, 7f});

                Color labelBgColor = new Color(0, 122, 204);
                Color valueBgColor = Color.WHITE;

                String[][] data = {
                        {"Nombre del Centro:", rs.getString("centerName")},
                        {"Dirección Postal:", rs.getString("postalAddress")},
                        {"Email:", rs.getString("centerEmail")},
                        {"Teléfono:", rs.getString("phone")},
                        {"Director General:", rs.getString("generalDirectorName")},
                        {"Gerente de RRHH:", rs.getString("hrManager")},
                        {"Gerente de Contabilidad:", rs.getString("accountingManager")},
                        {"Secretario:", rs.getString("secretaryName")}
                };

                for (String[] entry : data) {
                    PdfPCell labelCell = new PdfPCell(new Phrase(entry[0], labelFont));
                    labelCell.setBackgroundColor(labelBgColor);
                    labelCell.setPadding(8);
                    labelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    labelCell.setBorder(Rectangle.NO_BORDER);

                    PdfPCell valueCell = new PdfPCell(new Phrase(entry[1] == null ? "No disponible" : entry[1], valueFont));
                    valueCell.setBackgroundColor(valueBgColor);
                    valueCell.setPadding(8);
                    valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    valueCell.setBorderColor(new Color(220, 220, 220));
                    valueCell.setBorderWidth(1f);

                    table.addCell(labelCell);
                    table.addCell(valueCell);
                }

                document.add(table);

                System.out.println("Reporte PDF generado correctamente en: " + pdfPath);
            } else {
                System.out.println("No se encontraron centros en la base de datos.");
            }

            document.close();

        } catch (SQLException | IOException | DocumentException e) {
            e.printStackTrace();
        }
        return pdfPath;
    }



    public static void createDriverReportPDF(String driverId) {
        String pdfPath = "reportsPDF\\driverReporte.pdf";

        String driverQuery = "SELECT firstname, lastname, birthdate, address, phone, email FROM driver WHERE driverid = ?";
        String licensesQuery = "SELECT licensetype, issuedate, expirationdate, restrictions, renewed, licensestatus FROM license WHERE driverid = ?";
        String infractionsQuery = "SELECT i.violationtype, i.date, i.points " +
                "FROM infraction i " +
                "JOIN license l ON i.licenseid = l.licenseid " +
                "WHERE l.driverid = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement driverStmt = conn.prepareStatement(driverQuery);
             PreparedStatement licensesStmt = conn.prepareStatement(licensesQuery);
             PreparedStatement infractionsStmt = conn.prepareStatement(infractionsQuery)) {

            driverStmt.setString(1, driverId);
            licensesStmt.setString(1, driverId);
            infractionsStmt.setString(1, driverId);

            ResultSet driverRs = driverStmt.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            // Usar java.awt.Color directamente
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.BLACK);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Color.BLACK);

            // Título general
            Paragraph title = new Paragraph("Reporte de Conductor", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));

            if (driverRs.next()) {
                // Info conductor
                Paragraph driverInfoTitle = new Paragraph("Información del Conductor", headerFont);
                driverInfoTitle.setAlignment(Element.ALIGN_LEFT);
                document.add(driverInfoTitle);

                PdfPTable driverTable = new PdfPTable(2);
                driverTable.setWidthPercentage(100);
                driverTable.setSpacingBefore(10);
                driverTable.setSpacingAfter(20);

                String[][] driverData = {
                        {"Nombre", driverRs.getString("firstname") + " " + driverRs.getString("lastname")},
                        {"Fecha de Nacimiento", driverRs.getDate("birthdate") != null ? driverRs.getDate("birthdate").toString() : ""},
                        {"Dirección", driverRs.getString("address")},
                        {"Teléfono", driverRs.getString("phone")},
                        {"Email", driverRs.getString("email")}
                };

                for (String[] row : driverData) {
                    PdfPCell cell1 = new PdfPCell(new Phrase(row[0], headerFont));
                    cell1.setBackgroundColor(new Color(0, 122, 204));
                    cell1.setPadding(6);
                    driverTable.addCell(cell1);

                    PdfPCell cell2 = new PdfPCell(new Phrase(row[1] != null ? row[1] : "", cellFont));
                    cell2.setPadding(6);
                    driverTable.addCell(cell2);
                }
                document.add(driverTable);

                // Licencias
                Paragraph licensesTitle = new Paragraph("Licencias Emitidas", headerFont);
                licensesTitle.setAlignment(Element.ALIGN_LEFT);
                document.add(licensesTitle);

                PdfPTable licensesTable = new PdfPTable(6);
                licensesTable.setWidthPercentage(100);
                licensesTable.setSpacingBefore(10);
                licensesTable.setSpacingAfter(20);

                String[] licensesHeaders = {"Tipo", "Fecha de Emisión", "Fecha de Vencimiento", "Limitaciones", "Renovada", "Estado"};
                for (String header : licensesHeaders) {
                    PdfPCell headerCell = new PdfPCell(new Phrase(header, headerFont));
                    headerCell.setBackgroundColor(new Color(0, 122, 204));
                    headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    headerCell.setPadding(6);
                    licensesTable.addCell(headerCell);
                }

                try (ResultSet licensesRs = licensesStmt.executeQuery()) {
                    boolean evenRow = false;
                    while (licensesRs.next()) {
                        evenRow = !evenRow;

                        String renewedStr = licensesRs.getBoolean("renewed") ? "Sí" : "No";

                        String[] licenseRow = {
                                licensesRs.getString("licensetype"),
                                licensesRs.getDate("issuedate") != null ? licensesRs.getDate("issuedate").toString() : "",
                                licensesRs.getDate("expirationdate") != null ? licensesRs.getDate("expirationdate").toString() : "",
                                licensesRs.getString("restrictions"),
                                renewedStr,
                                licensesRs.getString("licensestatus")
                        };

                        for (String col : licenseRow) {
                            PdfPCell cell = new PdfPCell(new Phrase(col != null ? col : "", cellFont));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell.setPadding(6);
                            if (evenRow) cell.setBackgroundColor(new Color(242, 242, 242));
                            licensesTable.addCell(cell);
                        }
                    }
                }
                document.add(licensesTable);

                // Infracciones
                Paragraph infractionsTitle = new Paragraph("Infracciones Registradas", headerFont);
                infractionsTitle.setAlignment(Element.ALIGN_LEFT);
                document.add(infractionsTitle);

                PdfPTable infractionsTable = new PdfPTable(3);
                infractionsTable.setWidthPercentage(100);
                infractionsTable.setSpacingBefore(10);

                String[] infractionsHeaders = {"Tipo de Infracción", "Fecha", "Puntos"};
                for (String header : infractionsHeaders) {
                    PdfPCell headerCell = new PdfPCell(new Phrase(header, headerFont));
                    headerCell.setBackgroundColor(new Color(0, 122, 204));
                    headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    headerCell.setPadding(6);
                    infractionsTable.addCell(headerCell);
                }

                try (ResultSet infractionsRs = infractionsStmt.executeQuery()) {
                    boolean evenRow = false;
                    while (infractionsRs.next()) {
                        evenRow = !evenRow;

                        String[] infractionRow = {
                                infractionsRs.getString("violationtype"),
                                infractionsRs.getDate("date") != null ? infractionsRs.getDate("date").toString() : "",
                                String.valueOf(infractionsRs.getInt("points"))
                        };

                        for (String col : infractionRow) {
                            PdfPCell cell = new PdfPCell(new Phrase(col != null ? col : "", cellFont));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            cell.setPadding(6);
                            if (evenRow) cell.setBackgroundColor(new Color(242, 242, 242));
                            infractionsTable.addCell(cell);
                        }
                    }
                }
                document.add(infractionsTable);

            } else {
                Paragraph noDriver = new Paragraph("No se encontró ningún conductor con ID: " + driverId, cellFont);
                document.add(noDriver);
            }

            document.close();
            System.out.println("Reporte PDF generado correctamente en: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }








    public static void createRelatedEntityReportPDF(String entityName) {
        String pdfPath = "reportsPDF/relatedEntityReporte.pdf";

        String query = "SELECT entityName, entityType, address, phone, contactEmail, directorName, centerCode FROM RelatedEntity WHERE entityName = ?";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, entityName);
            ResultSet rs = stmt.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font labelFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font valueFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);

            Paragraph title = new Paragraph("Ficha de Entidad Asociada", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Espacio

            if (rs.next()) {
                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);

                addRow(table, "Nombre", rs.getString("entityName"), labelFont, valueFont);
                addRow(table, "Tipo", rs.getString("entityType"), labelFont, valueFont);
                addRow(table, "Dirección", rs.getString("address"), labelFont, valueFont);
                addRow(table, "Teléfono", rs.getString("phone"), labelFont, valueFont);
                addRow(table, "Email", rs.getString("contactEmail"), labelFont, valueFont);
                addRow(table, "Director", rs.getString("directorName"), labelFont, valueFont);
                addRow(table, "Código del Centro", rs.getString("centerCode"), labelFont, valueFont);

                document.add(table);
            } else {
                document.add(new Paragraph("No se encontró ninguna entidad con el nombre: " + entityName));
            }

            document.close();
            System.out.println("Reporte PDF generado correctamente en: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addRow(PdfPTable table, String label, String value, Font labelFont, Font valueFont) {
        PdfPCell labelCell = new PdfPCell(new Phrase(label, labelFont));
        labelCell.setBackgroundColor(new Color(0, 122, 204)); // Azul
        labelCell.setPadding(6);
        labelCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        labelCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        PdfPCell valueCell = new PdfPCell(new Phrase(value != null ? value : "", valueFont));
        valueCell.setPadding(6);
        valueCell.setHorizontalAlignment(Element.ALIGN_LEFT);

        table.addCell(labelCell);
        table.addCell(valueCell);
    }







    public static void createLicenseReportPDF(java.sql.Date startDate, java.sql.Date endDate) {
        String pdfPath = "reportsPDF/reportLicense.pdf";
        String query = "SELECT l.licenseId, d.firstName, d.lastName, l.licenseType, l.issueDate, l.expirationDate, l.licenseStatus " +
                "FROM License l " +
                "JOIN Driver d ON l.driverId = d.driverId " +
                "WHERE l.issueDate BETWEEN ? AND ? " +
                "ORDER BY l.issueDate";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, startDate);
            stmt.setDate(2, endDate);
            ResultSet rs = stmt.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);

            Paragraph title = new Paragraph("Reporte de Licencias Emitidas", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Desde: " + startDate + "  Hasta: " + endDate, subtitleFont));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            addHeaderCell(table, "Código de Licencia", headerFont);
            addHeaderCell(table, "Nombre del Conductor", headerFont);
            addHeaderCell(table, "Tipo de Licencia", headerFont);
            addHeaderCell(table, "Fecha de Emisión", headerFont);
            addHeaderCell(table, "Fecha de Vencimiento", headerFont);
            addHeaderCell(table, "Estado", headerFont);

            while (rs.next()) {
                table.addCell(new Phrase(String.valueOf(rs.getInt("licenseId")), cellFont));
                table.addCell(new Phrase(rs.getString("firstName") + " " + rs.getString("lastName"), cellFont));
                table.addCell(new Phrase(rs.getString("licenseType"), cellFont));
                table.addCell(new Phrase(rs.getDate("issueDate").toString(), cellFont));
                table.addCell(new Phrase(rs.getDate("expirationDate").toString(), cellFont));
                table.addCell(new Phrase(rs.getString("licenseStatus"), cellFont));
            }

            document.add(table);
            document.close();

            System.out.println("Reporte PDF generado correctamente en: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addHeaderCell(PdfPTable table, String text, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBackgroundColor(new Color(0, 122, 204)); // Azul
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPadding(6);
        table.addCell(cell);
    }



    public static void createTestReportPDF(java.sql.Date startDate, java.sql.Date endDate) {
        String pdfPath = "reportsPDF/reportTest.pdf";
        String query = "SELECT t.testCode, d.firstName, d.lastName, t.testType, t.date, t.result, t.entityName " +
                "FROM Test t " +
                "JOIN Driver d ON t.driverId = d.driverId " +
                "WHERE t.date BETWEEN ? AND ? " +
                "ORDER BY t.date";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, startDate);
            stmt.setDate(2, endDate);
            ResultSet rs = stmt.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);

            Paragraph title = new Paragraph("Reporte de Exámenes Realizados", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Desde: " + startDate + "  Hasta: " + endDate, subtitleFont));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Encabezados
            String[] headers = {"Código del Examen", "Nombre del Conductor", "Tipo de Examen", "Fecha del Examen", "Resultado", "Entidad"};
            for (String header : headers) {
                PdfPCell headerCell = new PdfPCell(new Phrase(header, headerFont));
                headerCell.setBackgroundColor(new Color(0, 122, 204));
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                headerCell.setPadding(6);
                table.addCell(headerCell);
            }

            // Filas
            while (rs.next()) {
                table.addCell(new Phrase(rs.getString("testCode"), cellFont));
                table.addCell(new Phrase(rs.getString("firstName") + " " + rs.getString("lastName"), cellFont));
                table.addCell(new Phrase(rs.getString("testType"), cellFont));
                table.addCell(new Phrase(rs.getDate("date").toString(), cellFont));

                // Resultado con color
                String resultText = rs.getBoolean("result") ? "Aprobado" : "Reprobado";
                Color resultColor = rs.getBoolean("result") ? new Color(0, 153, 0) : new Color(204, 0, 0);
                Font resultFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, resultColor);
                table.addCell(new Phrase(resultText, resultFont));

                table.addCell(new Phrase(rs.getString("entityName"), cellFont));
            }

            document.add(table);
            document.close();

            System.out.println("Reporte PDF de exámenes generado en: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void createInfractionReportPDF(java.sql.Date startDate, java.sql.Date endDate) {
        String pdfPath = "reportsPDF/reportInfraction.pdf";
        String query = "SELECT i.infractioncode, d.firstname, d.lastname, i.violationtype, i.date, i.location, i.points, i.ispaid " +
                "FROM infraction i " +
                "JOIN license l ON i.licenseid = l.licenseid " +
                "JOIN driver d ON l.driverid = d.driverid " +
                "WHERE i.date BETWEEN ? AND ? " +
                "ORDER BY i.date";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, startDate);
            stmt.setDate(2, endDate);
            ResultSet rs = stmt.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);

            Paragraph title = new Paragraph("Reporte de Infracciones Registradas", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Desde: " + startDate + "  Hasta: " + endDate, subtitleFont));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            addHeaderCell(table, "Código de Infracción", headerFont);
            addHeaderCell(table, "Nombre del Conductor", headerFont);
            addHeaderCell(table, "Tipo de Infracción", headerFont);
            addHeaderCell(table, "Fecha", headerFont);
            addHeaderCell(table, "Lugar", headerFont);
            addHeaderCell(table, "Puntos", headerFont);
            addHeaderCell(table, "Estado", headerFont);

            while (rs.next()) {
                table.addCell(new Phrase(rs.getString("infractioncode"), cellFont));
                table.addCell(new Phrase(rs.getString("firstname") + " " + rs.getString("lastname"), cellFont));
                table.addCell(new Phrase(rs.getString("violationtype"), cellFont));
                table.addCell(new Phrase(rs.getDate("date").toString(), cellFont));
                table.addCell(new Phrase(rs.getString("location"), cellFont));
                table.addCell(new Phrase(String.valueOf(rs.getInt("points")), cellFont));
                String estado = rs.getBoolean("ispaid") ? "Pagada" : "Pendiente";
                table.addCell(new Phrase(estado, cellFont));
            }

            document.add(table);
            document.close();

            System.out.println("Reporte PDF generado correctamente en: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void createConsolidatedInfractionReportPDF(int year) {
        String pdfPath = "reportsPDF/reportConsolidatedInfraction.pdf";
        String query = "SELECT violationType, COUNT(*) AS totalInfractions, " +
                "SUM(points) AS totalPoints, " +
                "SUM(CASE WHEN isPaid THEN 1 ELSE 0 END) AS totalPaid, " +
                "SUM(CASE WHEN NOT isPaid THEN 1 ELSE 0 END) AS totalPending " +
                "FROM infraction " +
                "WHERE EXTRACT(YEAR FROM date) = ? " +
                "GROUP BY violationType " +
                "ORDER BY violationType";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, year);
            ResultSet rs = stmt.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);

            Paragraph title = new Paragraph("Reporte Consolidado de Infracciones por Tipo - Año " + year, titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Año: " + year, subtitleFont));
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            addHeaderCell(table, "Tipo de Infracción", headerFont);
            addHeaderCell(table, "Cantidad de Infracciones", headerFont);
            addHeaderCell(table, "Puntos Totales Deducidos", headerFont);
            addHeaderCell(table, "Multas Pagadas", headerFont);
            addHeaderCell(table, "Multas Pendientes", headerFont);

            while (rs.next()) {
                table.addCell(new Phrase(rs.getString("violationType"), cellFont));
                table.addCell(new Phrase(String.valueOf(rs.getInt("totalInfractions")), cellFont));
                table.addCell(new Phrase(String.valueOf(rs.getInt("totalPoints")), cellFont));
                table.addCell(new Phrase(String.valueOf(rs.getInt("totalPaid")), cellFont));
                table.addCell(new Phrase(String.valueOf(rs.getInt("totalPending")), cellFont));
            }

            document.add(table);
            document.close();

            System.out.println("Reporte PDF generado correctamente en: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void createExpiredLicensesReportPDF(java.sql.Date startDate, java.sql.Date endDate) {
        String pdfPath = "reportsPDF/reportExpiredLicenses.pdf";
        String query = "SELECT d.firstName, d.lastName, d.driverId, l.licenseType, l.expirationDate, l.licenseStatus " +
                "FROM License l " +
                "JOIN Driver d ON l.driverId = d.driverId " +
                "WHERE l.expirationDate BETWEEN ? AND ? " +
                "AND l.expirationDate < CURRENT_DATE " +
                "ORDER BY l.expirationDate";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, startDate);
            stmt.setDate(2, endDate);
            ResultSet rs = stmt.executeQuery();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Font subtitleFont = FontFactory.getFont(FontFactory.HELVETICA, 12);
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Color.WHITE);
            Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Color.BLACK);

            // Título
            Paragraph title = new Paragraph("Reporte de Licencias Vencidas", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Subtítulo con fechas
            document.add(new Paragraph("Desde: " + startDate + "  Hasta: " + endDate, subtitleFont));
            document.add(Chunk.NEWLINE);

            // Tabla con 5 columnas
            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            addHeaderCell(table, "Nombre del Conductor", headerFont);
            addHeaderCell(table, "Número de Documento", headerFont);
            addHeaderCell(table, "Tipo de Licencia", headerFont);
            addHeaderCell(table, "Fecha de Vencimiento", headerFont);
            addHeaderCell(table, "Estado de la Licencia", headerFont);

            while (rs.next()) {
                table.addCell(new Phrase(rs.getString("firstName") + " " + rs.getString("lastName"), cellFont));
                table.addCell(new Phrase(String.valueOf(rs.getString("driverId")), cellFont));
                table.addCell(new Phrase(rs.getString("licenseType"), cellFont));
                table.addCell(new Phrase(rs.getDate("expirationDate").toString(), cellFont));
                table.addCell(new Phrase(rs.getString("licenseStatus"), cellFont));
            }

            document.add(table);
            document.close();

            System.out.println("Reporte PDF de licencias vencidas generado en: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}

