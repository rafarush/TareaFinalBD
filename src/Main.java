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

        HTMLReportGenerator.createCenterReport();
        HTMLReportGenerator.createDriverReport(2);
        HTMLReportGenerator.createRelatedEntityReport("1");

        java.sql.Date start = java.sql.Date.valueOf("2025-01-01");
        java.sql.Date end = java.sql.Date.valueOf("2025-03-31");
        HTMLReportGenerator.createLicenseReport(start, end);

        start = java.sql.Date.valueOf("2010-01-01");
        HTMLReportGenerator.createTestReport(start, end);
    }
}