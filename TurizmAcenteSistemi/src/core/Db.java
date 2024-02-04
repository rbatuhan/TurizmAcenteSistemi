package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Veritabanı bağlantısını yöneten  sınıf
public class Db {
    private static Db instance= null;
    private Connection connection = null; // Veritabanı bağlantısı
    private final String DB_URL = "jdbc:postgresql://localhost:5432/TourismAgency"; // Veritabanı URL'si
    private final String DB_USERNAME = "postgres"; // Veritabanı kullanıcı adı
    private final String DB_PASSWORD = "postgres"; // Veritabanı şifresi

    private Db() {
        try {
            // Veritabanı bağlantısını oluştur
            this.connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public static Connection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()){
                instance = new Db();
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return instance.getConnection();
    }
}
