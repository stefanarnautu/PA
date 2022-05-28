package panel;


import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private Image image;
    public DrawingPanel(Image image) {
        this.image = image;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

