import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            Database.createConnection();
            Connection con = Database.getConnection();
            var continents = new ContinentDAO();
            var countries = new CountryDAO();
            var cities = new Cities();
            int numberOfLines;
          /*
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select count(*) from mydata")) {
                if(rs.next())
                numberOfLines = rs.getInt(1);
                else
                    numberOfLines = 0;
            }

            System.out.println(numberOfLines);

            for(int contor = 0 ; contor<numberOfLines ; contor++) {
                try (Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery("select countryname,capitalname,capitallatitude,capitallongitude,countrycode,continentname from mydata where id=" + contor)) {
                    if (rs.next()) {
                        continents.create(rs.getString(6));
                        countries.create(rs.getString(1), rs.getString(5), continents.findByName(rs.getString(6)));
                        cities.create(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    }
                }
            }
            Database.getConnection().commit();
            System.out.println(cities.findByName("Bucharest"));
          */

            double latitudine, longitudine;

            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select latitude,longitude from cities where id="+ cities.findByName("Bucharest"))) {
                if (rs.next()) {
                    latitudine = rs.getDouble(1);
                    longitudine = rs.getDouble(2);
                } else {
                    latitudine = 0;
                    longitudine = 0;
                }
            }
            System.out.println(latitudine + "  " + longitudine);

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
