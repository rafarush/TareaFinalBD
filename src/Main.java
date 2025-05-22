import models.Driver;
import models.License;
import services.ServicesLocator;
import visual.MainScreen.MainScreem;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        java.awt.EventQueue.invokeLater(() -> {
            new MainScreem().setVisible(true);
        });

    }
}