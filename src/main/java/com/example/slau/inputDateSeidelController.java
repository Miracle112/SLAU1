package com.example.slau;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class inputDateSeidelController {

    @FXML
    private Button buttonСalculate;

    @FXML
    private Label exceptionDate;

    @FXML
    private TextField inputA11;

    @FXML
    private TextField inputA12;

    @FXML
    private TextField inputA13;

    @FXML
    private TextField inputA21;

    @FXML
    private TextField inputA22;

    @FXML
    private TextField inputA23;

    @FXML
    private TextField inputA31;

    @FXML
    private TextField inputA32;

    @FXML
    private TextField inputA33;

    @FXML
    private TextField inputB1;

    @FXML
    private TextField inputB2;

    @FXML
    private TextField inputB3;

    @FXML
    private TextField inputT;

    @FXML
    void initialize() {
        exceptionDate.setVisible(false);

        ArrayList<Float> dataRecording = new ArrayList<Float>();

        ArrayList<TextField> textFields = new ArrayList<TextField>();
        textFields.add(inputA11);
        textFields.add(inputA12);
        textFields.add(inputA13);
        textFields.add(inputA21);
        textFields.add(inputA22);
        textFields.add(inputA23);
        textFields.add(inputA31);
        textFields.add(inputA32);
        textFields.add(inputA33);
        textFields.add(inputB1);
        textFields.add(inputB2);
        textFields.add(inputB3);
        textFields.add(inputT);

        buttonСalculate.setOnAction(event -> {
            exceptionDate.setVisible(false);
            boolean bool = false;
            for (TextField i: textFields) {
                bool = Application.inputValidation(i);
                if (bool) {
                    exceptionDate.setVisible(true);
                    break;
                } else {
                    dataRecording.add(Application.data_recording(i));
                }
            }
            if (!bool) {
                double a11 = dataRecording.get(0);
                double a12 = dataRecording.get(1);
                double a13 = dataRecording.get(2);
                double a21 = dataRecording.get(3);
                double a22 = dataRecording.get(4);
                double a23 = dataRecording.get(5);
                double a31 = dataRecording.get(6);
                double a32 = dataRecording.get(7);
                double a33 = dataRecording.get(8);
                double b1 = dataRecording.get(9);
                double b2 = dataRecording.get(10);
                double b3 = dataRecording.get(11);
                double t = dataRecording.get(12);

                double x01 = b1 / a11;
                double x02 = b2 / a22;
                double x03 = b3 / a33;

                System.out.println(x01);
                System.out.println(x02);
                System.out.println(x03);

                double x11;
                double x12;
                double x13;
                double t01 = 1;
                double t02 = 1;
                double t03 = 1;

                for( int i = 0; i < 100; i++) {
                    // Линейное преобразование
                    if (Math.abs(a11) < Math.abs(a12) || Math.abs(a11) < Math.abs(a13)) {
                        double aa11 = a11 + a31 * 2 + a21 * 2;
                        double aa12 = a12 + a32 * 2 + a22 * 2;
                        double aa13 = a13 + a33 * 2 + a23 * 2;
                        double bb1 = b1 + b3 * 2 + b2 * 2;
                        a11 = aa11;
                        a12 = aa12;
                        a13 = aa13;
                        b1 = bb1;

                    } else if (Math.abs(a22) < Math.abs(a21) || Math.abs(a22) < Math.abs(a23)) {
                        double aa21 = a21 - a31 * 2 - a11;
                        double aa22 = a22 - a32 * 2 - a12;
                        double aa23 = a23 - a33 * 2 - a13;
                        double bb2 = b2 - b3 * 2 - b1;
                        a21 = aa21;
                        a22 = aa22;
                        a23 = aa23;
                        b2 = bb2;

                    } else if (Math.abs(a33) < Math.abs(a31) || Math.abs(a33) < Math.abs(a32)) {
                        double aa31 = a31 - a11;
                        double aa32 = a32 - a12;
                        double aa33 = a33 - a13;
                        double bb3 = b3 - b1;
                        a31 = aa31;
                        a32 = aa32;
                        a33 = aa33;
                        b3 = bb3;
                    }
                    else {
                        break;
                    }
                }

                for (int i = 0; i < 100; i++) {
                    if (Math.abs(t01) > t || Math.abs(t02)  > t || Math.abs(t03) > t) {
                        x11 = (b1 - a12 * x02 - a13 * x03) / a11;
                        double x21 = x01;
                        x01 = x11;
                        x12 = (b2 - a21 * x01 - a23 * x03) / a22;
                        double x22 = x02;
                        x02 = x12;
                        x13 = (b3 - a31 * x01 - a32 * x02) / a33;
                        double x23 = x03;
                        x03 = x13;
                        System.out.println("x:" + i + "-aя " + x11);
                        System.out.println(x12);
                        System.out.println(x13);
                        t01 = (x21 - x01);
                        t02 = (x22 - x02);
                        t03 = (x23 - x03);
                        String result1 = String.format("%.8f",t01);
                        String result2 = String.format("%.8f",t02);
                        String result3 = String.format("%.8f",t03);
                        System.out.println("т: " + i + "-aя " + result1);
                        System.out.println(result2);
                        System.out.println(result3);
                    }
                    else {
                        System.out.println(x01 + " " + x02 + " " + x03);
                        break;
                    }
                }

                FXMLLoader loader = new FXMLLoader(inputDateSeidelController.class.getResource("result_seidel.fxml"));
                Stage stage = new Stage();
                try {
                    stage.setScene(new Scene(loader.load()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                resultSeidelController resultSeidelController = loader.getController();
                resultSeidelController.transferDate(x01, x02, x03);
                stage.show();
                buttonСalculate.getScene().getWindow().hide();
            }
        });
    }
}