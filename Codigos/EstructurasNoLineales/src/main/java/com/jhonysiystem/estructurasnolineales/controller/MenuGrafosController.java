package com.jhonysiystem.estructurasnolineales.controller;

import com.jhonysiystem.estructurasnolineales.funciones.Grafo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuGrafosController {

    @FXML
    private TextField txtVertice;

    @FXML
    private TextField txtOrigen;

    @FXML
    private TextField txtDestino;

    @FXML
    private TextField txtInicio;

    @FXML
    private TextArea txtSalida;

    private final Grafo grafo = new Grafo();

    @FXML
    void onAgregar(ActionEvent event) {
        String v = txtVertice.getText() != null ? txtVertice.getText().trim() : "";
        String o = txtOrigen.getText() != null ? txtOrigen.getText().trim() : "";
        String d = txtDestino.getText() != null ? txtDestino.getText().trim() : "";

        if (!v.isEmpty()) {
            grafo.agregarVertice(v);
            txtSalida.appendText("Vértice agregado: " + v + "\n");
        }

        if (!o.isEmpty() && !d.isEmpty()) {
            grafo.agregarArista(o, d);
            txtSalida.appendText("Arista agregada: " + o + " - " + d + "\n");
        }

        if (v.isEmpty() && (o.isEmpty() || d.isEmpty())) {
            mostrarError("Faltan datos", "Agrega un vértice o escribe origen y destino.");
        }
    }

    @FXML
    void onMostrar(ActionEvent event) {
        txtSalida.appendText("\n--- Lista de adyacencia ---\n");
        txtSalida.appendText(grafo.mostrar() + "\n");
    }

    @FXML
    void onBfs(ActionEvent event) {
        String inicio = txtInicio.getText() != null ? txtInicio.getText().trim() : "";
        if (inicio.isEmpty()) {
            mostrarError("Falta inicio", "Escribe el vértice de inicio.");
            return;
        }
        txtSalida.appendText("BFS desde " + inicio + ": " + grafo.bfs(inicio) + "\n");
    }

    @FXML
    void onDfs(ActionEvent event) {
        String inicio = txtInicio.getText() != null ? txtInicio.getText().trim() : "";
        if (inicio.isEmpty()) {
            mostrarError("Falta inicio", "Escribe el vértice de inicio.");
            return;
        }
        txtSalida.appendText("DFS desde " + inicio + ": " + grafo.dfs(inicio) + "\n");
    }

    @FXML
    void onLimpiar(ActionEvent event) {
        txtSalida.clear();
    }

    @FXML
    void onRegresar(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/com/jhonysiystem/estructurasnolineales/menu-view.fxml"
        ));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menú principal");
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
