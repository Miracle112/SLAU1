package com.example.slau;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ComparisonResultController {
    float iter_x01;
    float iter_x02;
    float iter_x03;
    float seidel_x01;
    float seidel_x02;
    float seidel_x03;
    float[] Array_seidel;
    float[] Array_iter;



    @FXML
    private TextField answer;

    @FXML
    private Button homeButton;

    @FXML
    private TextField iterX1;

    @FXML
    private TextField iterX2;

    @FXML
    private TextField iterX3;

    @FXML
    private TextField seidelX1;

    @FXML
    private TextField seidelX2;

    @FXML
    private TextField seidelX3;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler1 = new DatabaseHandler();
        Array_seidel = dbHandler1.getDataSeidel();
        Array_iter = dbHandler1.getDataIter();

        iter_x01 = Array_iter[0];
        iter_x02 = Array_iter[1];
        iter_x03 = Array_iter[2];

        seidel_x01 = Array_seidel[0];
        seidel_x02 = Array_seidel[1];
        seidel_x03 = Array_seidel[2];

        if (iter_x01 == seidel_x01 && iter_x02 == seidel_x02 && iter_x03 == seidel_x03){
            answer.setText("Результаты равны");
        } else {
            answer.setText("Результаты не равны");
        }

        homeButton.setOnAction(event -> {
            try {
                Application.openAnotherWindow("hello-view.fxml");
                homeButton.getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        iterX1.setText(String.valueOf(iter_x01));
        iterX2.setText(String.valueOf(iter_x02));
        iterX3.setText(String.valueOf(iter_x03));

        seidelX1.setText(String.valueOf(seidel_x01));
        seidelX2.setText(String.valueOf(seidel_x02));
        seidelX3.setText(String.valueOf(seidel_x03));
    }




}
