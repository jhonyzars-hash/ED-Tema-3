package com.jhonysystems.estructuraslineales.funciones;

import java.util.Vector;

public class VectorEstructura {

    private Vector<String> vector;

    public VectorEstructura() {
        vector = new Vector<>();
    }

    public VectorEstructura(Vector<String> vector) {
        this.vector = vector;
    }

    public Vector<String> getVector() {
        return vector;
    }

    public void setVector(Vector<String> vector) {
        this.vector = vector;
    }

    public void agregar(String valor) {
        vector.add(valor);
    }

    public void eliminar(String valor) {
        vector.remove(valor);
    }

    public String mostrar() {
        return vector.toString();
    }

    public String toString() {
        return "Vector" + vector;
    }
}
