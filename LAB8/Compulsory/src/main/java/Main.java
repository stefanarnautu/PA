import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();
            //TODO: print all the countries in Europe
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            //Database.rollback();
        }


        /*String url = "jdbc:mysql://localhost/student" ;
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    url, "Student", "STUDENT");
        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (con != null)
                con.close() ;
        }*/
    }
}
