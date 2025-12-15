package com.jhonysiystem.estructurasnolineales.funciones;

public class ArbolBST {

    private NodoArbol raiz;

    public boolean estaVacio() {
        return raiz == null;
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoArbol insertarRec(NodoArbol actual, int valor) {
        if (actual == null) return new NodoArbol(valor);

        if (valor < actual.valor) {
            actual.izquierda = insertarRec(actual.izquierda, valor);
        } else if (valor > actual.valor) {
            actual.derecha = insertarRec(actual.derecha, valor);
        }
        return actual;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NodoArbol actual, int valor) {
        if (actual == null) return false;
        if (actual.valor == valor) return true;

        if (valor < actual.valor) return buscarRec(actual.izquierda, valor);
        return buscarRec(actual.derecha, valor);
    }

    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void inordenRec(NodoArbol actual, StringBuilder sb) {
        if (actual == null) return;
        inordenRec(actual.izquierda, sb);
        sb.append(actual.valor).append(" ");
        inordenRec(actual.derecha, sb);
    }

    public String preorden() {
        StringBuilder sb = new StringBuilder();
        preordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void preordenRec(NodoArbol actual, StringBuilder sb) {
        if (actual == null) return;
        sb.append(actual.valor).append(" ");
        preordenRec(actual.izquierda, sb);
        preordenRec(actual.derecha, sb);
    }

    public String postorden() {
        StringBuilder sb = new StringBuilder();
        postordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void postordenRec(NodoArbol actual, StringBuilder sb) {
        if (actual == null) return;
        postordenRec(actual.izquierda, sb);
        postordenRec(actual.derecha, sb);
        sb.append(actual.valor).append(" ");
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoArbol actual) {
        if (actual == null) return 0;
        int izq = alturaRec(actual.izquierda);
        int der = alturaRec(actual.derecha);
        return 1 + Math.max(izq, der);
    }

    public int contarNodos() {
        return contarNodosRec(raiz);
    }

    private int contarNodosRec(NodoArbol actual) {
        if (actual == null) return 0;
        return 1 + contarNodosRec(actual.izquierda) + contarNodosRec(actual.derecha);
    }

    public int contarHojas() {
        return contarHojasRec(raiz);
    }

    private int contarHojasRec(NodoArbol actual) {
        if (actual == null) return 0;
        if (actual.izquierda == null && actual.derecha == null) return 1;
        return contarHojasRec(actual.izquierda) + contarHojasRec(actual.derecha);
    }
}
