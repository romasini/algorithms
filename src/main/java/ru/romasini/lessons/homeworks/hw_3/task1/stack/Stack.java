package ru.romasini.lessons.homeworks.hw_3.task1.stack;

public interface Stack<E> {
    void push(E value);
    E pop();
    E peek();
    int size();
    boolean isEmpty();
    void display();
    boolean isFull();
}
