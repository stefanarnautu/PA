import java.sql.*;
import java.util.Scanner;

public class Main {

    public static double distanceBeetween(double lat1, double lat2, double lon1, double lon2)
    {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2),2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;

        return(c * r);
    }

    public static void main(String[] args) {
        try {
            Database.createConnection();
            Connection con = Database.getConnection();
            var continents = new ContinentDAO();
            var countries = new CountryDAO();
            var cities = new Cities();

            int numberOfLines;
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


            String firstCountry,secondCountry;
            Scanner console = new Scanner(System.in);
            System.out.print("Enter first country: ");
            firstCountry = console.nextLine();
            System.out.print("Enter second country: ");
            secondCountry = console.nextLine();

            double latitudine1, longitudine1,latitudine2, longitudine2;

            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select latitude,longitude from cities where id="+ cities.findByName(firstCountry))) {
                if (rs.next()) {
                    latitudine1 = rs.getDouble(1);
                    longitudine1 = rs.getDouble(2);
                } else {
                    latitudine1 = 0;
                    longitudine1 = 0;
                }
            }

            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select latitude,longitude from cities where id="+ cities.findByName(secondCountry))) {
                if (rs.next()) {
                    latitudine2 = rs.getDouble(1);
                    longitudine2 = rs.getDouble(2);
                } else {
                    latitudine2 = 0;
                    longitudine2 = 0;
                }
            }
            System.out.println(String.format("%.3f",distanceBeetween(latitudine1, latitudine2, longitudine1, longitudine2)) + " K.M. de la " + firstCountry + " la " + secondCountry + ".");

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
