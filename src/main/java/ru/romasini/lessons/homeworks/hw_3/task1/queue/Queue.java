package ru.romasini.lessons.homeworks.hw_3.task1.queue;

public interface Queue<E> {

    boolean insert(E value);
    E remove();
    E peekFront();
    int size();
    boolean isEmpty();
    boolean isFull();

}
