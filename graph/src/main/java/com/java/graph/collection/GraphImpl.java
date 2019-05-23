package com.java.graph.collection;

import java.util.*;
import java.util.stream.Collectors;

public class GraphImpl<E> implements Graph<E> {

    private Map<E, Set<E>> adjacencyVertices = new HashMap<>();

    public void add(E e) {
        adjacencyVertices.put(e, new HashSet<>());
    }

    public void remove(E e) {
        adjacencyVertices.values()
                .stream()
                .map(c -> c.remove(e))
                .collect(Collectors.toList());
        adjacencyVertices.remove(e);
    }

    public void addEdge(E e1, E e2) {
        adjacencyVertices.get(e1).add(e2);
        adjacencyVertices.get(e2).add(e1);
    }

    public void removeEdge(E e1, E e2) {
        adjacencyVertices.get(e1).remove(e2);
        adjacencyVertices.get(e2).remove(e1);
    }

    public Collection<E> getAdjacencyVertices(E e) {
        Collection<E> vertices = adjacencyVertices.get(e);
        return vertices;
    }

    private boolean hasVertex(E e1) {
        return adjacencyVertices.containsKey(e1);
    }

}
