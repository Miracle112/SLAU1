package com.example.slau;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class resultSeidelController {
    Double x1;
    Double x2;
    Double x3;

    @FXML
    private TextField answer1;

    @FXML
    private TextField answer2;

    @FXML
    private TextField answer3;

    @FXML
    private Button dataSaveButton;

    @FXML
    private Button homeButton;

    @FXML
    private Label textSave;

    @FXML
    private Button comparisonButton;

    @FXML
    private Label comparisonText;

    public void transferDate(Double x01, Double x02, Double x03 ) {
        this.x1 = x01;
        this.x2 = x02;
        this.x3 = x03;
        System.out.println(x01 + " " + x02 + " " + x03);

        textSave.setVisible(false);
        comparisonText.setVisible(false);
        answer1.setText(String.valueOf(x1));
        answer2.setText(String.valueOf(x2));
        answer3.setText(String.valueOf(x3));

    }

    @FXML
    void initialize() {
        dataSaveButton.setOnAction(event -> {

            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.seidelResult(x1, x2, x3);
            textSave.setVisible(true);
        });

        homeButton.setOnAction(event -> {
            try {
                Application.openAnotherWindow("hello-view.fxml");
                homeButton.getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        comparisonButton.setOnAction(event -> {
            try {
                Application.openAnotherWindow("comparison_result.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            comparisonButton.getScene().getWindow().hide();
        });
    }

}
