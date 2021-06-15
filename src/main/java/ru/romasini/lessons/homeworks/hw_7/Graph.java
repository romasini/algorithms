package ru.romasini.lessons.homeworks.hw_7;

import java.util.List;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);

    int getSize();

    void display();

    /**
     * Depth-first search
     * @param startLabel
     */
    void dfs(String startLabel);

    /**
     * Breadth-first search
     * @param startLabel
     */
    void bfs(String startLabel);

    List<Vertex> bfsShortWay(String startLabel, String endLabel);

}
