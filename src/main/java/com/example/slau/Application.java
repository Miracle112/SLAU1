package com.example.slau;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Math solver");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    static public void openAnotherWindow(String name) throws IOException {
        // устанавливает загрузщик
        Parent root = FXMLLoader.load(Application.class.getResource(name));
        // рисует сцену
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    static public boolean inputValidation(TextField num){
        String text1 = num.getText().trim();
        boolean noNum = false;
        try {
            Float.parseFloat(text1);
        } catch (Exception e) {
            noNum = true;
        }

        if(!text1.matches("-?\\d*.?\\d*") || text1 == "" ) {
            noNum = true;
        }
        return noNum;
    }

    static public float data_recording(TextField text){
        String text1 = text.getText();
        float text2 = Float.parseFloat(text1);
        return text2;
    }


    public static void main(String[] args) {
        launch();
    }
}