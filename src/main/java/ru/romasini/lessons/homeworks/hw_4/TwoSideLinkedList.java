package ru.romasini.lessons.homeworks.hw_4;

public interface TwoSideLinkedList<E> extends LinkedList<E>{
    void insertLast(E value);
    E removeLast();
}
