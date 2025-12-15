package com.jhonysiystem.estructurasnolineales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/jhonysiystem/estructurasnolineales/bienvenida-view.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
        stage.setTitle("Estructuras No Lineales");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
