import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Database.createConnection();
            var continents = new ContinentDAO();
            continents.create("Asia");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");

            System.out.println("Exista Europa?");
            System.out.println(continents.findByName("Europe")!=null ? "DA" : "NU");
            System.out.println("Gasit dupa id:" + continents.findById(3));

            countries.create("Romania","RO", europeId);
            countries.create("Ukraine","UA", europeId);
            Database.getConnection().commit();

            System.out.println("Exista Ukraine?");
            System.out.println(countries.findByName("Ukraine")!=null ? "DA" : "NU");
            System.out.println("Gasit dupa id:" + countries.findById(1));

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
