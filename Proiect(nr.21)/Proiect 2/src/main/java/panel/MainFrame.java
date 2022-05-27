package panel;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    JPanel jPanelWest, jPanelEast;

    public MainFrame() {
        super("My game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        //canvas = new DrawingPanel(this);
        jPanelWest = new JPanel();
        jPanelEast = new JPanel();
        //...TODO


        //arrange the components in the container (frame)

        //JFrame uses a BorderLayout by default
        //add(canvas, CENTER); //this is BorderLayout.CENTER
        add(configPanel, NORTH);
        add(controlPanel, SOUTH);
        add(jPanelWest, WEST);
        add(jPanelEast, EAST);
        //...TODO

        //invoke the layout manager
        pack();
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

}
