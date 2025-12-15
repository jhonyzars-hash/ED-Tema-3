package com.jhonysystems.estructuraslineales.funciones;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {

    private Queue<String> cola;

    public Cola() {
        cola = new LinkedList<>();
    }

    public Cola(Queue<String> cola) {
        this.cola = cola;
    }

    public Queue<String> getCola() {
        return cola;
    }

    public void setCola(Queue<String> cola) {
        this.cola = cola;
    }

    public void encolar(String valor) {
        cola.add(valor);
    }

    public String desencolar() {
        if (cola.isEmpty()) return "Cola vacía";
        return cola.poll();
    }

    public String mostrar() {
        return cola.toString();
    }

    public String toString() {
        return "Cola" + cola;
    }
}
