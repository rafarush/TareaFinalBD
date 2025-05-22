import models.Driver;
import models.License;
import report.HTMLReportGenerator;
import services.ServicesLocator;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<Driver> drivers = ServicesLocator.getInstance().getDriverServices().getAllDrivers();
        for (Driver driver : drivers) {
            System.out.println("Driver: "+ driver.toString());
        }

        // License Creation test
        Date hoy = Date.valueOf(LocalDate.now());
        Date expira = Date.valueOf(LocalDate.now().plusYears(10));

        License license = new License(2, 1, "A", hoy,
                expira, "usar espejuelos", false, "Vigente");
        try {
            ServicesLocator.getInstance().getLicenseServices().createLicense(license);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        String[] headers = { "ID", "Nombre", "Edad" };
        String[][] data = {
                { "11", "Juan", "25" },
                { "2", "María", "30" },
                { "3", "Luis", "28" }
        };

        String desktopDir = System.getProperty("user.home") + "\\Escritorio";
        File dir = new File(desktopDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String filePath = desktopDir + "\\reporte.html";

        try {
            HTMLReportGenerator.createHTMLReport("C:\\Users\\Jorgito\\OneDrive\\Desktop\\reporte.html", "Reporte de Usuarios", headers, data);
            System.out.println("Reporte creado en: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}