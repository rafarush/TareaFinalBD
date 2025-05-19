import models.Driver;
import services.ServicesLocator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        List<Driver> drivers = ServicesLocator.getInstance().getDriverServices().getAllDrivers();
        for (Driver driver : drivers) {
            System.out.println("Driver: "+ driver.toString());
        }


    }
}