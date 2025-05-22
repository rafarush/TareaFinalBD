package report;

import java.io.FileWriter;
import java.io.IOException;

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
}

