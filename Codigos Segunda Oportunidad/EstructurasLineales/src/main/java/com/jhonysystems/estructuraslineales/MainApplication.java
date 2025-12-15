package com.jhonysystems.estructuraslineales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                MainApplication.class.getResource("Main-view.fxml")
        );
        Scene scene = new Scene(loader.load(), 600, 400);
        stage.setTitle("Estructuras Lineales");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
