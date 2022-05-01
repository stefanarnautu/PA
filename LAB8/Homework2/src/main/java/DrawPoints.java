import DB.Database;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Thread.sleep;

public class DrawPoints extends JPanel {

    double xAxisProjection(double input) {
        return 6378137.0 * Math.toRadians(input);
    }

    double yAxisProjection(double input) {
        input = Math.min(Math.max(input, -89.5), 89.5);
        double earthDimensionalRateNormalized = 1.0 - Math.pow(6356752.3142 / 6378137.0, 2);

        double inputOnEarthProj = Math.sqrt(earthDimensionalRateNormalized) *
                Math.sin( Math.toRadians(input));

        inputOnEarthProj = Math.pow(((1.0 - inputOnEarthProj) / (1.0+inputOnEarthProj)),
                0.5 * Math.sqrt(earthDimensionalRateNormalized));

        double inputOnEarthProjNormalized =
                Math.tan(0.5 * ((Math.PI * 0.5) - Math.toRadians(input))) / inputOnEarthProj;

        return (-1) * 6378137.0 * Math.log(inputOnEarthProjNormalized);
    }

    public String getCapitalName(int id) throws SQLException{
        Connection con = DB.Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from cities where id=" + id)) {
             return rs.next() ? rs.getString(1):null;
            }
    }

    public Double[] getCoordonates(int id){
        Connection con = DB.Database.getConnection();

        Double tempCoordonates[] = new Double[3];
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select latitude,longitude from cities where id=" + id )) {
            if(rs.next()) {
                tempCoordonates[1] = Double.parseDouble(rs.getString(1));
                tempCoordonates[2] = Double.parseDouble(rs.getString(2));
            }
            else {
                tempCoordonates[1] = Double.valueOf(0);
                tempCoordonates[2] = Double.valueOf(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempCoordonates;
    }

    public Integer numberOfCities(){
        Connection con = DB.Database.getConnection();

        int numberOfLines = 0;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select count(*) from cities")) {
            if(rs.next())
                numberOfLines = rs.getInt(1);
            else
                numberOfLines = 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfLines;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        this.setBackground(Color.gray);
        Integer nrOfLines = numberOfCities();
        Connection con = Database.getConnection();
        Font font = new Font("Verdana", Font.BOLD, 6);
        g2d.setFont(font);
        double xDraw,yDraw;

        for(int contor = 1; contor <= nrOfLines ; contor++){
            Double coordonates[];
            coordonates = getCoordonates(contor);
            xDraw = xAxisProjection(coordonates[1]);
            yDraw = yAxisProjection(coordonates[2]);

            xDraw = (xDraw + 6042792.988121703);
            yDraw = (yDraw + 3.461928937185626E7 + 1000);

            xDraw = (xDraw/(8707039.504880548 + 6042791.988121703));
            yDraw = (yDraw/(3.461928937185635E7 + 3.461928937185626E7));

            xDraw = 800 - (xDraw * 800);
            yDraw = yDraw * 1100 + 100;
            g2d.setPaint(Color.black);
            g2d.draw(new Rectangle2D.Double(yDraw+2, xDraw+2, 3, 3));


            g2d.setPaint(Color.black);
            try {
                g2d.drawString(getCapitalName(contor), (int) yDraw, (int) xDraw + 2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
