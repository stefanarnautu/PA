package places;

import java.sql.*;
import DB.*;

public class ContinentDAO {

    public void create(String nume) throws SQLException {
        Connection con = Database.getConnection();

        if(findByName(nume)!=null){
            System.out.println(nume +" exista in baza de date.");
        }
        else {
            try (PreparedStatement pstmt = con.prepareStatement("insert into continents (name) values (?)")) {
                pstmt.setString(1,nume);
                pstmt.executeUpdate();
            }
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from continents where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

}
