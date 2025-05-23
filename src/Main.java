import models.Center;
import report.HTMLReportGenerator;
import report.PDFReportGenerator;
import services.ServicesLocator;
import visual.MainScreen.MainScreen;

public class Main {
    public static void main(String[] args) {

      
        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });


        PDFReportGenerator.createCenterReportPDF();
        HTMLReportGenerator.createCenterReport();
        HTMLReportGenerator.createDriverReport("3");
        PDFReportGenerator.createDriverReportPDF("3");
        HTMLReportGenerator.createRelatedEntityReport("1");
        PDFReportGenerator.createRelatedEntityReportPDF("1");
        java.sql.Date start = java.sql.Date.valueOf("2020-01-01");
        java.sql.Date end = java.sql.Date.valueOf("2025-03-31");
        HTMLReportGenerator.createLicenseReport(start, end);
        PDFReportGenerator.createLicenseReportPDF(start, end);
        start = java.sql.Date.valueOf("2010-01-01");
        HTMLReportGenerator.createTestReport(start, end);
        PDFReportGenerator.createTestReportPDF(start, end);

        HTMLReportGenerator.createInfractionReport(start, end);
        PDFReportGenerator.createInfractionReportPDF(start, end);

        HTMLReportGenerator.createConsolidatedInfractionReport(2014);
        PDFReportGenerator.createConsolidatedInfractionReportPDF(2014);


        HTMLReportGenerator.createExpiredLicensesReport(start, end);
        PDFReportGenerator.createExpiredLicensesReportPDF(start, end);

    }
}