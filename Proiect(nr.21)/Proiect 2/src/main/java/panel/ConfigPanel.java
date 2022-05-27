package panel;

import classes.AddressCorrector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label,correctAddress,cityFalse,incorrectAddress,addressLabel,labelCity,labelState,labelCountry;
    JTextField cityText, stateText,countryText;
    JButton create;
    String city,state,country;
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Address Input:");
        labelCity = new JLabel("City: ");
        labelState = new JLabel("State: ");
        labelCountry = new JLabel("Country: ");
        cityText = new JTextField();
        stateText = new JTextField();
        countryText = new JTextField();
        addressLabel = new JLabel();

        cityText.setPreferredSize( new Dimension( 200, 24 ) );
        stateText.setPreferredSize( new Dimension( 200, 24 ) );
        countryText.setPreferredSize( new Dimension( 200, 24 ) );

        create = new JButton("Verify Address");
        create.addActionListener(this::createGame);
        //create spinners for rows and cols, and the button
        cityFalse = new JLabel("City doesn't exist!");
        cityFalse.setVisible(false);
        correctAddress = new JLabel("Correct Address!");
        correctAddress.setVisible(false);
        incorrectAddress = new JLabel("Incorrect Address!");
        incorrectAddress.setVisible(false);
        addressLabel.setVisible(false);
        add(label); //JPanel uses FlowLayout by default
        add(labelCity);
        add(cityText);
        add(labelState);
        add(stateText);
        add(labelCountry);
        add(countryText);
        add(create);
        add(cityFalse);
        add(incorrectAddress);
        add(correctAddress);
        add(addressLabel);
    }

    private void createGame(ActionEvent e) {
        city=cityText.getText();
        state=stateText.getText();
        country=countryText.getText();
        AddressCorrector addressCorrector = new AddressCorrector(city,state,country,entityManager);
        if(addressCorrector.VerifyCity()==false)
            cityFalse.setVisible(true);

        {
            if(addressCorrector.VerifyState()==false || addressCorrector.VerifyCountry()==false)
                incorrectAddress.setVisible(true);
            else
                correctAddress.setVisible(true);
        }
        addressCorrector.VerifyState();
        addressCorrector.VerifyCountry();
        addressLabel = new JLabel("The correct address is: City: "+ addressCorrector.getCity()+" State: "+addressCorrector.getState()+" Country: "+addressCorrector.getCountry());
        add(addressLabel);
        addressLabel.setVisible(true);
    }

}
