package dataBase;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {
    public static void main(String[] args) {
        try (Connection conn = DataBaseConnection.getConnection()) {
            System.out.println("¡Conexión exitosa a PostgreSQL!");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}