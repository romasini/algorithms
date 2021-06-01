package ru.romasini.lessons.homeworks.hw_4;

import java.util.ArrayList;

/**
 * 1. Реализовать интерфейс Iterable для LinkedList, чтобы работал foreach
 * 2. Доработать Двусторонний список с возможностью получить предыдущий элемент.
 * Реализовать Deque на основе этого списка.
 */

public class TaskMain {
    public static void main(String[] args) {

        //Односторонний список
        System.out.println("Односторонний список");
        LinkedList<Integer> simpleLinkedList = new SimpleLinkedListImpl<>();
        simpleLinkedList.insertFirst(1);
        simpleLinkedList.insertFirst(2);
        simpleLinkedList.insertFirst(3);
        simpleLinkedList.display();

        //foreach для LinkedList
        System.out.println("For-each для Одностороннего списка");
        for (Integer local:simpleLinkedList) {
            System.out.println(local);
        }

        //Двусторонний список
        System.out.println("Двусторонний список с реализацией prev");
        TwoSideLinkedList<Integer> twoSideLinkedList = new TwoSideLinkedListImpl<>();
        twoSideLinkedList.insertFirst(1);
        twoSideLinkedList.insertFirst(2);
        twoSideLinkedList.insertFirst(3);
        twoSideLinkedList.insertLast(4);
        twoSideLinkedList.display();

        System.out.println("Удаление последнего");
        twoSideLinkedList.removeLast();
        twoSideLinkedList.display();
        twoSideLinkedList.remove(2);
        twoSideLinkedList.display();

        //Двусторонняя очередь



    }
}
