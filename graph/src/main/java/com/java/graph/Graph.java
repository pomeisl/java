package com.java.graph;

import java.util.Collection;

public interface Graph<E> {
    void add(E e);

    void remove(E e);

    void addEdge(E e1, E e2);

    void removeEdge(E e1, E e2);

    Collection<E> getAdjacencyVertices(E e);

    Collection<E> depthFirstTraversal(E root);

    Collection<E> breadthTraversal(E root);
}
