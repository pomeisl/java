package com.java.graph;

import java.util.*;
import java.util.stream.Collectors;

public class GraphImpl<E> implements Graph<E> {

    private Map<E, List<E>> adjacencyVertices = new HashMap<>();

    public void add(E e) {
        adjacencyVertices.put(e, new ArrayList<>());
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

    @Override
    public Collection<E> depthFirstTraversal(E root) {
        Collection<E> visited = new ArrayList<>();
        Stack<E> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            E vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (E adjacencyVertex : adjacencyVertices.get(vertex)) {
                    stack.push(adjacencyVertex);
                }
            }
        }
        return visited;
    }

    @Override
    public Collection<E> breadthFirstTraversal(E root) {
        Collection<E> visited = new ArrayList<>();
        Queue<E> queue = new LinkedList<>();

        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            E vertex = queue.poll();

            for (E adjacencyVertex : adjacencyVertices.get(vertex)) {
                if (!visited.contains(adjacencyVertex)) {
                    visited.add(adjacencyVertex);
                    queue.add(adjacencyVertex);
                }
            }
        }

        return visited;
    }

    private boolean hasVertex(E e1) {
        return adjacencyVertices.containsKey(e1);
    }

}
