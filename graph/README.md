## Graph

Graph is a data structure to storing connected data like a network.

A graph consists of vertices and edges.
A vertex eventually is an entity that contains the data and an edge represents the connections between vertices.

## Graph Structure

```
           Vertex1
         /         \
        /           \
       /             \
      /               \
Vertex2 --- Vertex3 --- Vertex4
      \               /
       \             /
        \           /
         \         /
           Vertex5
```

There are five vertices and six edges in this graph.

Edges:
1.
    * 1 - 2
    * 2 - 1
2.
    * 1 - 4
    * 4 - 1
3.
    * 2 - 3
    * 3 - 2
4.
    * 3 - 4
    * 4 - 3
5. 
    * 5 - 2
    * 2 - 5
6.
    * 5 - 4
    * 4 - 5

## Directed Graph

The edges have direction in a directed graph.
An edge can point to a vertex from an other one and vice versa.
However the edges can be bi-directional as well.

```
             Vertex1
          /           /\
         /             \
        /               \
       \/                \
Vertex2 <--- Vertex3 <--- Vertex4
       \                 /
        \               /
         \             /
         \/           \/
             Vertex5
```

## Weighted Graph

Wighting the edges give a relative meanings to them.

             Vertex1
          /          \
         1           0.75
        /              \
       /                \
Vertex2 -0.5 Vertex3 0.5- Vertex4
       \                /
        \              /
        0.75          1
          \          /
             Vertex5
            
## Graph representations

### matrix

A graph can be represented in many different form, for example in an adjacency matrix or adjacency list.

|     |  1  |  2  |  3  |  4  |  5  |
| --- | --- | --- | --- | --- | --- |
|  1  |  0  |  1  |  0  |  1  |  0  |
|  2  |  1  |  0  |  1  |  0  |  1  |
|  3  |  0  |  1  |  0  |  1  |  0  |
|  4  |  1  |  0  |  1  |  0  |  1  |
|  5  |  0  |  1  |  0  |  1  |  0  |

### Adjacency list

The size of adjacency list that represents the graph matches with the numbers of vertices.

| List | Content |
| ---- | ------- |
|    1 | 2, 4    |
|    2 | 1, 3, 5 |
|    3 | 2, 4    |
|    4 | 1, 3, 5 |
|    5 | 2, 4    |

## Graph sample in Java

Java doesn't provide any graph implementation but this data structure can be represented by Java Collections.

## Entity representation.

```java
public class Vertex<T> {
    private T label;
    public Vertex(T label) {
        this.label = label;
    }
    // ... getters, setters, equals, hashCode
}
```

This vertex represents an entity.
You have to override equals and hashCode method in order to doing operations on the graph data structure;

### Adjacency list representation

```java
public class Graph<T> {
    private Map<T, List<T>> Vertices;
    
    // standard constructor, getters, setters
}
```

### Graph Mutation Operations
```java
public class Graph<T> {
    private Map<T, List<T>> adjacencyVertices;
    
    public void addVertex(T label) {
        adjacencyVertices.putIfAbsent(new Vertex(label), new ArrayList<>());        
    }
    
    public void removeVertex(T label) {
        Vertex v = new Vertex(label);
        adjacencyVertices
            .values()
            .stram()
            .map(e -> e.remove(v))
            .collect(Colelctors.toList());
        adjacencyVertices.remove(v);
    }
    
    public void addEdge(T fromLabel, T toLabel) {
        Vertex from = new Vertex(fromLabel);
        Vertex to = new Vertex(toLabel);
        adjacencyVertices.get(from).add(to);
        adjacencyVertices.get(to).add(from);
    }
    
    public void removeEdge(T fromLabel, T toLabel) {
        Vertex from = new Vertex(fromLabel);
        Vertex to = new Vertex(toLabel);
        adjacencyVertices.get(from).remove(to);
        adjacencyVertices.get(to).remove(from);
    }
    
    List<Vertex<T>> getAdjacencyVertices(T label) {
        return adjacencyVertices.get(new Vertex(label));
    }
}
```

