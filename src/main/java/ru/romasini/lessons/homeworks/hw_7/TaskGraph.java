package ru.romasini.lessons.homeworks.hw_7;

/**
 * 1. Реализовать программу, в которой задается граф из 10 вершин.
 * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 */

public class TaskGraph {
    public static void main(String[] args) {
        Graph cityGraph = new GraphImpl(10);
        cityGraph.addVertex("Москва");
        cityGraph.addVertex("Тула");
        cityGraph.addVertex("Рязань");
        cityGraph.addVertex("Калуга");
        cityGraph.addVertex("Липецк");
        cityGraph.addVertex("Тамбов");
        cityGraph.addVertex("Орел");
        cityGraph.addVertex("Воронеж");
        cityGraph.addVertex("Саратов");
        cityGraph.addVertex("Курск");

        cityGraph.addEdge("Москва", "Тула", "Рязань", "Калуга");
        cityGraph.addEdge("Тула", "Липецк");
        cityGraph.addEdge("Липецк", "Воронеж");
        cityGraph.addEdge("Рязань", "Тамбов");
        cityGraph.addEdge("Тамбов", "Саратов");
        cityGraph.addEdge("Саратов", "Воронеж");
        cityGraph.addEdge("Калуга", "Орел");
        cityGraph.addEdge("Орел", "Курск");
        cityGraph.addEdge("Курск", "Воронеж");

        System.out.println(cityGraph.bfsShortWay("Москва", "Воронеж"));

    }

}
