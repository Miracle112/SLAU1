package com.example.slau;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class mainController {

    @FXML
    private Button button_iteration_method;

    @FXML
    private Button button_seidel_method;

    @FXML
    void initialize() {
        button_iteration_method.setOnAction(event -> {
            try {
                Application.openAnotherWindow("input_date_iter.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            button_iteration_method.getScene().getWindow().hide();
        });
        button_seidel_method.setOnAction(event -> {
            try {
                Application.openAnotherWindow("input_date_seidel.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            button_seidel_method.getScene().getWindow().hide();
        });
    }
}