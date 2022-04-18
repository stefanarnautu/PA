import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/student" ;
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    url, "myUserName", "mySecretPassword");
        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (con != null)
                con.close() ;
        }
    }
}
