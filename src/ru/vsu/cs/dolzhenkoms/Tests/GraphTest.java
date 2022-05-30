package ru.vsu.cs.dolzhenkoms.Tests;

import org.junit.jupiter.api.Assertions;
import ru.vsu.cs.dolzhenkoms.Graph;

import java.util.LinkedList;

public class GraphTest {

    @org.junit.jupiter.api.Test
    public void normalSituationTest() {
        Graph graph = new Graph("A", "D");
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 3);
        graph.addEdge("B", "E", 3);
        graph.addEdge("C", "D", 5);
        graph.addEdge("E", "D", 4);
        LinkedList<String> visited = new LinkedList();
        visited.add("A");
        graph.depthFirst(visited);

        Assertions.assertTrue(graph.getPaths().get(0).getDistance() == 8);
    }

    @org.junit.jupiter.api.Test
    public void twoPointsTest() {
        Graph graph = new Graph("A", "D");
        graph.addEdge("A", "D", 1);
        LinkedList<String> visited = new LinkedList();
        visited.add("A");
        graph.depthFirst(visited);

        Assertions.assertTrue(graph.getPaths().get(0).getDistance() == 1);
    }

    @org.junit.jupiter.api.Test
    public void emptyRelationsGraphTest() {
        Graph graph = new Graph("A", "D");
        LinkedList<String> visited = new LinkedList();
        visited.add("A");
        graph.depthFirst(visited);

        Assertions.assertTrue(graph.getPaths().size() == 0);
    }
}
