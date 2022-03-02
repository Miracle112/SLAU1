package com.example.slau;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
        dbHandler1.getDataSeidel(dbHandler1);
        DatabaseHandler dbHandler2 = new DatabaseHandler();
        Array_seidel = dbHandler1.getDataIter(dbHandler2);
        Array_iter = dbHandler1.getDataIter(dbHandler2);

        iter_x01 = Array_iter[0];
        iter_x02 = Array_iter[1];
        iter_x03 = Array_iter[2];

        seidel_x01 = Array_seidel[0];
        seidel_x02 = Array_seidel[1];
        seidel_x03 = Array_seidel[2];

        iterX1.setText(String.valueOf(iter_x01));
        iterX2.setText(String.valueOf(iter_x02));
        iterX3.setText(String.valueOf(iter_x03));

        seidelX1.setText(String.valueOf(seidel_x01));
        seidelX2.setText(String.valueOf(seidel_x02));
        seidelX3.setText(String.valueOf(seidel_x03));
    }




}
