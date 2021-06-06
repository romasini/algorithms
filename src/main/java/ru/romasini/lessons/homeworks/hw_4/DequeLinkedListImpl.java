package ru.romasini.lessons.homeworks.hw_4;

import ru.romasini.lessons.homeworks.hw_3.task3.deque.Deque;

public class DequeLinkedListImpl<E> implements Deque<E> {

    private TwoSideLinkedList<E> data;

    public DequeLinkedListImpl() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insert(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return data.removeFirst();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public boolean insertFirst(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertLast(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeFirst() {
        return data.removeFirst();
    }

    @Override
    public E removeLast() {
        return data.removeLast();
    }

    @Override
    public E peekFirst() {
        return data.getFirst();
    }

    @Override
    public E peekLast() {
        return data.getLast();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }


}
