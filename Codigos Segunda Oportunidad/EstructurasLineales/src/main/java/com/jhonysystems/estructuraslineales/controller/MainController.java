package com.jhonysystems.estructuraslineales.controller;

import com.jhonysystems.estructuraslineales.funciones.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class    MainController {

    private void abrir(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/jhonysystems/estructuraslineales/" + fxml)
            );
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 600, 400));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML private void abrirPilas() { abrir("pilas-view.fxml"); }
    @FXML private void abrirColas() { abrir("colas-view.fxml"); }
    @FXML private void abrirListas() { abrir("listas-view.fxml"); }
    @FXML private void abrirArreglos() { abrir("arreglos-view.fxml"); }
    @FXML private void abrirVectores() { abrir("vectores-view.fxml"); }

    @FXML private TextField txtPilas;
    @FXML private TextArea areaPilas;
    private Pila pila = new Pila();

    @FXML
    private void apilar() {
        pila.apilar(txtPilas.getText());
        areaPilas.setText(pila.mostrar());
        txtPilas.clear();
    }

    @FXML
    private void desapilar() {
        pila.desapilar();
        areaPilas.setText(pila.mostrar());
    }

    @FXML private TextField txtColas;
    @FXML private TextArea areaColas;
    private Cola cola = new Cola();

    @FXML
    private void encolar() {
        cola.encolar(txtColas.getText());
        areaColas.setText(cola.mostrar());
        txtColas.clear();
    }

    @FXML
    private void desencolar() {
        cola.desencolar();
        areaColas.setText(cola.mostrar());
    }

    @FXML private TextField txtListas;
    @FXML private TextArea areaListas;
    private Lista lista = new Lista();

    @FXML
    private void agregarLista() {
        lista.agregar(txtListas.getText());
        areaListas.setText(lista.mostrar());
        txtListas.clear();
    }

    @FXML private TextField txtArreglos;
    @FXML private TextArea areaArreglos;
    private Arreglo arreglo = new Arreglo();

    @FXML
    private void insertarArreglo() {
        arreglo.insertar(txtArreglos.getText());
        areaArreglos.setText(arreglo.mostrar());
        txtArreglos.clear();
    }

    @FXML private TextField txtVectores;
    @FXML private TextArea areaVectores;
    private VectorEstructura vector = new VectorEstructura();

    @FXML
    private void agregarVector() {
        vector.agregar(txtVectores.getText());
        areaVectores.setText(vector.mostrar());
        txtVectores.clear();
    }

    @FXML
    private void eliminarVector() {
        vector.eliminar(txtVectores.getText());
        areaVectores.setText(vector.mostrar());
    }
}
