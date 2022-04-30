import java.sql.*;

public class CountryDAO {
    public void create(String nume,String code,int continentId) throws SQLException {
        Connection con = Database.getConnection();
        if(findByName(nume)!=null){
            System.out.println(nume + " exista in baza de date.");
        }
        else {
            try (PreparedStatement pstmt = con.prepareStatement("insert into countries (name,code,continent) values (?,?,?)")) {
                pstmt.setString(1,nume);
                pstmt.setString(2,code);
                pstmt.setInt(3,continentId);
                pstmt.executeUpdate();
            }
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from countries where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from countries where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}
