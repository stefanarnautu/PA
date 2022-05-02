import DB.Database;
import places.CitiesDAO;
import places.ContinentDAO;
import places.CountryDAO;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Database.createConnection();
            Connection con = Database.getConnection();
            var continents = new ContinentDAO();
            var countries = new CountryDAO();
            var cities = new CitiesDAO();

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
