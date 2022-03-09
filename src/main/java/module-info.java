module com.example.slau {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires org.junit.jupiter.api;


    opens com.example.slau to javafx.fxml;
    exports com.example.slau;
}