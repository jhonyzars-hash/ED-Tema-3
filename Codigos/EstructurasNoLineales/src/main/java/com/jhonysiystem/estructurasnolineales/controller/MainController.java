package com.jhonysiystem.estructurasnolineales.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public void onArboles(ActionEvent event) throws IOException {
        cambiarVista(event, "menu-arboles-view.fxml", "Menú de Árboles");
    }

    public void onGrafos(ActionEvent event) throws IOException {
        cambiarVista(event, "menu-grafos-view.fxml", "Menú de Grafos");
    }

    public void onRegresar(ActionEvent event) throws IOException {
        cambiarVista(event, "bienvenida-view.fxml", "Estructuras No Lineales");
    }

    private void cambiarVista(ActionEvent event, String fxml, String titulo) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/com/jhonysiystem/estructurasnolineales/" + fxml
        ));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
    }
}
