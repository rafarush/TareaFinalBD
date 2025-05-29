import models.Center;
import report.HTMLReportGenerator;
import report.PDFReportGenerator;
import services.ServicesLocator;
import visual.LoginScreen.LoginScreen;
import visual.MainScreen.MainScreen;

public class Main {
    public static void main(String[] args) {

      
        java.awt.EventQueue.invokeLater(() -> {
            /*USERS            PASSWORD      role
            * Administrator     admin       admin
            * Anaisa           anaisa       manager
            * Tony              tony         client
            *
            * */
            //new MainScreen().setVisible(true);
            new LoginScreen().setVisible(true);
        });

    }
}