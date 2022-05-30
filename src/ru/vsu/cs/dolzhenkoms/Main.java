package ru.vsu.cs.dolzhenkoms;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String startPoint = readStartOrEndPoint("стартовую");
        String endPoint = readStartOrEndPoint("конечную");

        Graph graph = new Graph(startPoint, endPoint);
        String[] details = readDetails();
        while(details.length > 1) {
            graph.addEdge(details[0], details[1], Integer.parseInt(details[2]));
            details = readDetails();
        }
        System.out.println("Все отсортированные по длине пути графа от " + startPoint + " до " + endPoint + ":");

        LinkedList<String> visited = new LinkedList();
        visited.add(startPoint);
        graph.depthFirst(visited);
        graph.printPaths();
    }

    private static String readStartOrEndPoint(String text) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Введите " + text + " точку графа: ");

        return scn.next();
    }

    private static String[] readDetails() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Введите связь между вершинами графа");
        System.out.println("В формате Точка1:Точка2:Расстояние - ");

        return scn.next().split(":");
    }

    private static void some() {
        Graph graph = new Graph("A", "D");
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 3);
        graph.addEdge("B", "E", 3);
        graph.addEdge("C", "D", 5);
        graph.addEdge("E", "D", 4);
        LinkedList<String> visited = new LinkedList();
        visited.add("A");
        graph.depthFirst(visited);

        graph.printPaths();
    }
}
