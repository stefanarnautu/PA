import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/cities";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;
    private Database() {}
    public static Connection getConnection() {
        //TODO
        return connection;
    }
    private static void createConnection() {
        try {
            //Connection = TODO
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() { //TODO
         }
}
