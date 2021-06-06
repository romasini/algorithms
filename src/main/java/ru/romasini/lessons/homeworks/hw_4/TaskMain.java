package ru.romasini.lessons.homeworks.hw_4;

import ru.romasini.lessons.homeworks.hw_3.task3.deque.Deque;

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
        Deque<Integer> deque = new DequeLinkedListImpl<>();
        System.out.println(deque.insertLast(3));
        System.out.println(deque.insertLast(5));
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertLast(6));
        System.out.println(deque.insertLast(4));

        System.out.println("Deque peek: " + deque.peekFront());
        System.out.println("Deque size: " + deque.size());

        //35126
        while (!deque.isEmpty()) {
            System.out.println(deque.remove());
        }

        Deque<Integer> dequeBack = new DequeLinkedListImpl<>();
        System.out.println(dequeBack.insertFirst(3));
        System.out.println(dequeBack.insertFirst(5));
        System.out.println(dequeBack.insertFirst(1));
        System.out.println(dequeBack.insertFirst(2));
        System.out.println(dequeBack.insertFirst(6));

        System.out.println("Deque peek: " + dequeBack.peekFront());
        System.out.println("Deque size: " + dequeBack.size());

        //62153
        while (!dequeBack.isEmpty()) {
            System.out.println(dequeBack.remove());
        }

        Deque<Integer> dequeBackBack = new DequeLinkedListImpl<>();
        System.out.println(dequeBackBack.insertFirst(3));
        System.out.println(dequeBackBack.insertFirst(5));
        System.out.println(dequeBackBack.insertFirst(1));
        System.out.println(dequeBackBack.insertFirst(2));
        System.out.println(dequeBackBack.insertFirst(6));

        System.out.println("Deque peek: " + dequeBackBack.peekFront());
        System.out.println("Deque size: " + dequeBackBack.size());

        //35126
        while (!dequeBackBack.isEmpty()) {
            System.out.println(dequeBackBack.removeLast());
        }

        Deque<Integer> deque1 = new DequeLinkedListImpl<>();
        System.out.println(deque1.insertFirst(3));
        System.out.println(deque1.insertLast(5));
        System.out.println(deque1.insertFirst(1));
        System.out.println(deque1.insertLast(2));
        System.out.println(deque1.insertFirst(6));

        System.out.println("Deque peek: " + deque1.peekFront());
        System.out.println("Deque size: " + deque1.size());

        //61352
        while (!deque1.isEmpty()) {
            System.out.println(deque1.remove());
        }


    }
}
