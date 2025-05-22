import visual.MainScreen.MainScreen;

public class Main {
    public static void main(String[] args) {

      
        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });
      
      
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