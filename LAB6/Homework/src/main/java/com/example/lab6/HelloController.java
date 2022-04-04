package com.example.lab6;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Spinner<Integer> spinner1;
    @FXML
    private Spinner<Integer> spinner2;
    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Affine affine;
    int topSpace, leftSpace,clicksNumber=0;

    public void initialize(URL url, ResourceBundle resourceBundle){
        SpinnerValueFactory<Integer> value1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(5,10);
        SpinnerValueFactory<Integer> value2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(5,10);
        value1.setValue(1);
        value2.setValue(1);
        spinner1.setValueFactory(value1);
        spinner2.setValueFactory(value2);

        spinner1.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {

            }
        });
        spinner2.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {

            }
        });
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0,0,550,500);

        graphicsContext.setStroke(Color.GRAY);
        graphicsContext.setLineWidth(0.01);
    }

    public void setCanvas(ActionEvent e) {

        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, 550, 500);

        this.affine = new Affine();
        this.affine.appendScale(550 / 10f, 500 / 10f);
        graphicsContext.setTransform(this.affine);

        topSpace = 5 - (int) Math.ceil((float) spinner1.getValue() / 2);
        leftSpace = 5 - (int) Math.ceil((float) spinner2.getValue() / 2);

        Random rand = new Random();

        int nrRandom;
        for (int rowG = topSpace; rowG < this.spinner1.getValue() + topSpace; rowG++) {
            for (int columnG = leftSpace; columnG < this.spinner2.getValue() + leftSpace; columnG++) {
                nrRandom = rand.nextInt(100);
                if (columnG < this.spinner2.getValue() + leftSpace - 1) {
                    if (nrRandom <= 15) {
                        graphicsContext.strokeLine(rowG + 0.4, columnG + 0.4, rowG + 0.4, columnG + 1.4);
                    } else {
                        graphicsContext.setLineWidth(0.05);
                        graphicsContext.setStroke(Color.BLACK);
                        graphicsContext.strokeLine(rowG + 0.4, columnG + 0.4, rowG + 0.4, columnG + 1.4);
                        graphicsContext.setLineWidth(0.01);
                        graphicsContext.setStroke(Color.GRAY);
                    }
                }

                if (rowG < this.spinner1.getValue() + topSpace - 1) {
                    if (nrRandom <= 15) {
                        graphicsContext.strokeLine(rowG + 0.4, columnG + 0.4, rowG + 1.4, columnG + 0.4);
                    } else {
                        graphicsContext.setLineWidth(0.05);
                        graphicsContext.setStroke(Color.BLACK);
                        graphicsContext.strokeLine(rowG + 0.4, columnG + 0.4, rowG + 1.4, columnG + 0.4);
                        graphicsContext.setLineWidth(0.01);
                        graphicsContext.setStroke(Color.GRAY);
                    }
                }
            }
        }

        for (int rowG = topSpace; rowG < this.spinner1.getValue() + topSpace; rowG++) {
            for (int columnG = leftSpace; columnG < this.spinner2.getValue() + leftSpace; columnG++) {
                graphicsContext.setFill(Color.BLACK);
                graphicsContext.fillOval(rowG + 0.2, columnG + 0.2, 0.4, 0.4);
            }
        }

    clicksNumber=0;
    }
    public void load(ActionEvent e){ System.out.println("Load"); }
    public void save(ActionEvent e){
        System.out.println("Save");

    }

    public void exitProgram(ActionEvent e){ Platform.exit(); }

    public void mouseClicked(MouseEvent mouseEvent) {
        int mouseX = (int) mouseEvent.getX();
        int mouseY = (int) mouseEvent.getY();

        this.affine = new Affine();
        this.affine.appendScale(500 / 10f, 500 / 10f);
        graphicsContext.setTransform(this.affine);
        if(clicksNumber%2==0)
        graphicsContext.setFill(Color.RED);
        else  graphicsContext.setFill(Color.BLUE);
        clicksNumber++;
        graphicsContext.fillOval(mouseX/100f + mouseX/100f-0.1, mouseY/100f + mouseY/100f-0.1,0.25, 0.25);
    }
}