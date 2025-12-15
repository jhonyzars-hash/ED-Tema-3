package com.jhonysystems.estructuraslineales.funciones;

public class Arreglo {

    private String[] arreglo;
    private int contador;

    public Arreglo() {
        arreglo = new String[5];
        contador = 0;
    }

    public Arreglo(String[] arreglo) {
        this.arreglo = arreglo;
    }

    public String[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(String[] arreglo) {
        this.arreglo = arreglo;
    }

    public void insertar(String valor) {
        if (contador < arreglo.length) {
            arreglo[contador] = valor;
            contador++;
        }
    }

    public String mostrar() {
        String resultado = "";
        for (int i = 0; i < contador; i++) {
            resultado += arreglo[i] + " ";
        }
        return resultado;
    }

    public String toString() {
        return "Arreglo";
    }
}
