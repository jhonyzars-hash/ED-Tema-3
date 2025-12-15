package com.jhonysystems.estructuraslineales.funciones;

import java.util.ArrayList;

public class Lista {

    private ArrayList<String> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public Lista(ArrayList<String> lista) {
        this.lista = lista;
    }

    public ArrayList<String> getLista() {
        return lista;
    }

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }

    public void agregar(String valor) {
        lista.add(valor);
    }

    public void eliminar(String valor) {
        lista.remove(valor);
    }

    public String mostrar() {
        return lista.toString();
    }

    public String toString() {
        return "Lista" + lista;
    }
}
