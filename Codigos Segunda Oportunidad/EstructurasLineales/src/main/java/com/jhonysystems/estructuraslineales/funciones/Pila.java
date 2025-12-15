package com.jhonysystems.estructuraslineales.funciones;

import java.util.Stack;

public class Pila {

    private Stack<String> pila;

    public Pila() {
        pila = new Stack<>();
    }

    public Pila(Stack<String> pila) {
        this.pila = pila;
    }

    public Stack<String> getPila() {
        return pila;
    }

    public void setPila(Stack<String> pila) {
        this.pila = pila;
    }

    public void apilar(String valor) {
        pila.push(valor);
    }

    public String desapilar() {
        if (pila.isEmpty()) return "Pila vacía";
        return pila.pop();
    }

    public String mostrar() {
        return pila.toString();
    }

    public String toString() {
        return "Pila" + pila;
    }
}
