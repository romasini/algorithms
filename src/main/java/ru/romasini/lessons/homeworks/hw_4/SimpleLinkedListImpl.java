package ru.romasini.lessons.homeworks.hw_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = firstElement.next;

        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        } else if (current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null){
            if (current.item.equals(value)){
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(Node<E> node){
        return node != null ? node.item : null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{

        int cursor;
        Node<E> current;

        public LinkedListIterator() {
            this.current = firstElement;
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            E value = (E) getValue(current);
            current = current.next;
            cursor++;
            return value;
        }
    }

}
