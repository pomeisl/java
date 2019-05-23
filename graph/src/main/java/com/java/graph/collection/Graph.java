package com.java.graph.collection;

import java.util.Collection;

public interface Graph<E> {
    void add(E e);

    void remove(E e);

    void addEdge(E e1, E e2);

    void removeEdge(E e1, E e2);

    Collection<E> getAdjacencyVertices(E e);
}
