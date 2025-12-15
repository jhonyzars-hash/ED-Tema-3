package com.jhonysiystem.estructurasnolineales.controller;

import com.jhonysiystem.estructurasnolineales.funciones.ArbolBST;
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

public class MenuArbolesController {

    @FXML
    private TextField txtValores;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TextArea txtSalida;

    private final ArbolBST arbol = new ArbolBST();

    @FXML
    void onInsertar(ActionEvent event) {
        String valores = txtValores.getText();

        if (valores == null || valores.trim().isEmpty()) {
            mostrarError("Faltan valores", "Escribe números separados por coma.");
            return;
        }

        String[] partes = valores.split(",");
        int insertados = 0;

        for (String p : partes) {
            String t = p.trim();
            if (!t.isEmpty()) {
                try {
                    int n = Integer.parseInt(t);
                    arbol.insertar(n);
                    insertados++;
                } catch (NumberFormatException e) {
                               txtSalida.appendText("No se pudo insertar: " + t + "\n");
                }
            }
        }

        txtSalida.appendText("Insertados: " + insertados + " valores.\n");
    }

    @FXML
    void onRecorridos(ActionEvent event) {
        if (arbol.estaVacio()) {
            mostrarError("Árbol vacío", "Primero inserta valores.");
            return;
        }

        txtSalida.appendText("\n--- Recorridos ---\n");
        txtSalida.appendText("Inorden:  " + arbol.inorden() + "\n");
        txtSalida.appendText("Preorden: " + arbol.preorden() + "\n");
        txtSalida.appendText("Postorden:" + arbol.postorden() + "\n");
    }

    @FXML
    void onBuscar(ActionEvent event) {
        if (arbol.estaVacio()) {
            mostrarError("Árbol vacío", "Primero inserta valores.");
            return;
        }

        String valor = txtBuscar.getText();
        if (valor == null || valor.trim().isEmpty()) {
            mostrarError("Falta valor", "Escribe el valor a buscar.");
            return;
        }

        try {
            int n = Integer.parseInt(valor.trim());
            boolean existe = arbol.buscar(n);
            txtSalida.appendText("Buscar " + n + ": " + (existe ? "SI existe" : "NO existe") + "\n");
        } catch (NumberFormatException e) {
            mostrarError("Valor inválido", "Solo se aceptan números.");
        }
    }

    @FXML
    void onAltura(ActionEvent event) {
        if (arbol.estaVacio()) {
            mostrarError("Árbol vacío", "Primero inserta valores.");
            return;
        }

        txtSalida.appendText("\n--- Datos del árbol ---\n");
        txtSalida.appendText("Altura: " + arbol.altura() + "\n");
        txtSalida.appendText("Nodos: " + arbol.contarNodos() + "\n");
        txtSalida.appendText("Hojas: " + arbol.contarHojas() + "\n");
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
