module com.example.slau {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.slau to javafx.fxml;
    exports com.example.slau;
}