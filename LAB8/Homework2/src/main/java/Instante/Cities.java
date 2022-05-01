package Instante;
import DB.Database;
import java.sql.*;

public class Cities {

    public void create(String country, String name,String latitude,String longitude) throws SQLException {
        Connection con = Database.getConnection();
        if(findByName(name)!=null){
            System.out.println("Exista deja aceasta tara in baza de date");
        }
        else {
            try (PreparedStatement pstmt = con.prepareStatement("insert into cities (country,name,capital,latitude,longitude) values (?,?,1,?,?)")) {
                pstmt.setString(1,country);
                pstmt.setString(2,name);
                pstmt.setDouble(3, Double.parseDouble(latitude));
                pstmt.setDouble(4, Double.parseDouble(longitude));
                pstmt.executeUpdate();
            }
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from cities where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from cities where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

}
