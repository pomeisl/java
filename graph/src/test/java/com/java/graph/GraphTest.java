package com.java.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTest {

    private Graph<String> graph;

    @Before
    public void setup() {
        graph = new GraphImpl<>();
        graph.add("node1");
        graph.add("node2");
        graph.add("node3");
        graph.add("node4");
        graph.addEdge("node1", "node2");
        graph.addEdge("node1", "node4");
        graph.addEdge("node2", "node3");
        graph.addEdge("node2", "node4");

    }

    @Test
    public void givenGraph_AddVertex_Contains() {
        Collection<String> vertices = graph.getAdjacencyVertices("node1");

        assertThat(vertices).containsOnly("node2", "node4");
    }

    @Test
    public void givenGraph_Add_EdgeExists() {
        graph.add("node5");
        graph.addEdge("node4", "node5");

        Collection<String> vertices1 = graph.getAdjacencyVertices("node4");
        Collection<String> vertices2 = graph.getAdjacencyVertices("node5");

        assertThat(vertices1).contains("node5");
        assertThat(vertices2).contains("node4");
    }

    @Test
    public void givenGraph_RemoveVertex_NotFound() {
        graph.remove("node1");

        Collection<String> vertices = graph.getAdjacencyVertices("node1");

        assertThat(vertices).isNull();
    }

    @Test
    public void givenGraph_RemoveVertex_EdgeDoesntExist() {
        graph.remove("node1");
        // was related to 2, 4
        Collection<String> vertices1 = graph.getAdjacencyVertices("node2");
        Collection<String> vertices2 = graph.getAdjacencyVertices("node3");

        assertThat(vertices1).doesNotContain("node1");
        assertThat(vertices2).doesNotContain("node1");
    }

    @Test
    public void givenGraph_RemoveEdge_EdgeDoesntExist() {
        graph.removeEdge("node1", "node2");

        Collection<String> vertices1 = graph.getAdjacencyVertices("node1");
        Collection<String> vertices2 = graph.getAdjacencyVertices("node2");

        assertThat(vertices1).doesNotContain("node2");
        assertThat(vertices2).doesNotContain("node1");
    }

}
