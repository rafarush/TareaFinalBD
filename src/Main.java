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

    }
}