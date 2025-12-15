package com.jhonysiystem.estructurasnolineales.funciones;

import java.util.*;

public class Grafo {

      private final Map<String, List<String>> ady = new HashMap<>();

    public void agregarVertice(String v) {
        ady.putIfAbsent(v, new ArrayList<>());
    }

    public void agregarArista(String a, String b) {
        agregarVertice(a);
        agregarVertice(b);

        if (!ady.get(a).contains(b)) ady.get(a).add(b);
        if (!ady.get(b).contains(a)) ady.get(b).add(a);
    }

    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        for (String v : ady.keySet()) {
            sb.append(v).append(" -> ").append(ady.get(v)).append("\n");
        }
        return sb.toString();
    }

    public String bfs(String inicio) {
        if (!ady.containsKey(inicio)) return "(no existe el vértice)";

        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        visitados.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            sb.append(actual).append(" ");

            for (String vecino : ady.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }

        return sb.toString().trim();
    }

    public String dfs(String inicio) {
        if (!ady.containsKey(inicio)) return "(no existe el vértice)";

        Set<String> visitados = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfsRec(inicio, visitados, sb);
        return sb.toString().trim();
    }

    private void dfsRec(String actual, Set<String> visitados, StringBuilder sb) {
        visitados.add(actual);
        sb.append(actual).append(" ");

        for (String vecino : ady.get(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRec(vecino, visitados, sb);
            }
        }
    }
}
