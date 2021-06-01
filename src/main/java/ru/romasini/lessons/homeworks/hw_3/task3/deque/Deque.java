package ru.romasini.lessons.homeworks.hw_3.task3.deque;

import ru.romasini.lessons.homeworks.hw_3.task1.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertFirst(E value);
    boolean insertLast(E value);
    E removeFirst();
    E removeLast();
    E peekFirst();
    E peekLast();
    int size();
    boolean isEmpty();
    boolean isFull();
}
