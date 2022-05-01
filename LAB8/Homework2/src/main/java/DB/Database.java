package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/lab8pa";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Stefan123";
    private static Connection connection = null;
    private Database() {}
    public static Connection getConnection(){
        return connection;
    }

    public static void createConnection() {
        try {
            try {
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                System.out.println("Connected to the database");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Close connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
