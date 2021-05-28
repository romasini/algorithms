package ru.romasini.lessons.homeworks.hw_3.task3.deque;

public class TaskDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new DequeImpl<>(5);
        System.out.println(deque.insertLast(3));
        System.out.println(deque.insertLast(5));
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertLast(6));
        System.out.println(deque.insertLast(4));

        System.out.println("Deque peek: " + deque.peekFront());
        System.out.println("Deque size: " + deque.size());
        System.out.println("Deque is full: " + deque.isFull());

        //35126
        while (!deque.isEmpty()) {
            System.out.println(deque.remove());
        }

        Deque<Integer> dequeBack = new DequeImpl<>(5);
        System.out.println(dequeBack.insertFirst(3));
        System.out.println(dequeBack.insertFirst(5));
        System.out.println(dequeBack.insertFirst(1));
        System.out.println(dequeBack.insertFirst(2));
        System.out.println(dequeBack.insertFirst(6));
        System.out.println(dequeBack.insertFirst(4));

        System.out.println("Deque peek: " + dequeBack.peekFront());
        System.out.println("Deque size: " + dequeBack.size());
        System.out.println("Deque is full: " + dequeBack.isFull());

        //62153
        while (!dequeBack.isEmpty()) {
            System.out.println(dequeBack.remove());
        }

        Deque<Integer> dequeBackBack = new DequeImpl<>(5);
        System.out.println(dequeBackBack.insertFirst(3));
        System.out.println(dequeBackBack.insertFirst(5));
        System.out.println(dequeBackBack.insertFirst(1));
        System.out.println(dequeBackBack.insertFirst(2));
        System.out.println(dequeBackBack.insertFirst(6));
        System.out.println(dequeBackBack.insertFirst(4));

        System.out.println("Deque peek: " + dequeBackBack.peekFront());
        System.out.println("Deque size: " + dequeBackBack.size());
        System.out.println("Deque is full: " + dequeBackBack.isFull());

        //35126
        while (!dequeBackBack.isEmpty()) {
            System.out.println(dequeBackBack.removeLast());
        }

        Deque<Integer> deque1 = new DequeImpl<>(5);
        System.out.println(deque1.insertFirst(3));
        System.out.println(deque1.insertLast(5));
        System.out.println(deque1.insertFirst(1));
        System.out.println(deque1.insertLast(2));
        System.out.println(deque1.insertFirst(6));
        System.out.println(deque1.insertLast(4));

        System.out.println("Deque peek: " + deque1.peekFront());
        System.out.println("Deque size: " + deque1.size());
        System.out.println("Deque is full: " + deque1.isFull());

        //61352
        while (!deque1.isEmpty()) {
            System.out.println(deque1.remove());
        }

    }
}
