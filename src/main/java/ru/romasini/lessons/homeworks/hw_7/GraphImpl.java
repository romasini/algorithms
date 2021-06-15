package ru.romasini.lessons.homeworks.hw_7;

import java.util.*;

public class GraphImpl implements Graph{

    private List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public GraphImpl(int maxVertex) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertex][maxVertex];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String another : others) {
            result &= addEdge(startLabel, another);
        }
        return result;
    }

    private boolean addEdge(String startLabel, String endLabel){
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;

        return true;
    }

    private int indexOf(String label){
        for (int i = 0; i < vertexList.size(); i++) {
            Vertex v = vertexList.get(i);
            if (v.getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label:" + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex v: vertexList) {
            v.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex current) {
        int currentIndex = vertexList.indexOf(current);
        for (int i = 0; i < getSize(); i++) {
            if(adjMat[currentIndex][i] && !vertexList.get(i).isVisited()){
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertexShort(Queue<Vertex> queue, Vertex vertex) {
        if (!queue.isEmpty()) {
            vertex.setPrev(queue.peek());
        }
        queue.add(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.println(vertex);
        stack.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label:" + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    @Override
    public List<Vertex> bfsShortWay(String startLabel, String endLabel) {
        LinkedList<Vertex> shortWay = new LinkedList<>();

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label:" + startLabel);
        }
        if (endIndex == -1) {
            throw new IllegalArgumentException("Invalid end label:" + endLabel);
        }
        if (endIndex == startIndex) {
            throw new IllegalArgumentException("Invalid start and end label:" + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        Vertex endVertex = vertexList.get(endIndex);

        visitVertexShort(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertexShort(queue, vertex);
                if (vertex == endVertex) {
                    break;
                }
            } else {
                queue.remove();
            }
        }

        while (vertex != null) {
            shortWay.addFirst(vertex);
            vertex = vertex.getPrev();
        }

        resetVertexStatePrev();

        return shortWay;
    }

    private void resetVertexStatePrev() {
        for (Vertex v : vertexList) {
            v.setVisited(false);
            v.setPrev(null);
        }
    }
}
