package com.example.compulsory;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Label canvas;

    @FXML
    protected void onClickCreate(){
        canvas.setText("Welcome to JavaFX Application!");
    }
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}