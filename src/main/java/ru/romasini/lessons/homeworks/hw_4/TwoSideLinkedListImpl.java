package ru.romasini.lessons.homeworks.hw_4;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>{

    private Node<E> lastElement;

    @Override
    public void insertLast(E value) {
        Node<E> newNode = new Node<>(value, null, lastElement);
        if(isEmpty()){
           firstElement = newNode;
        }else {
            lastElement.next = newNode;
        }
        lastElement = newNode;
        size++;
    }

    @Override
    public void insertFirst(E value) {
        Node<E> newNode = new Node<>(value, firstElement, null);
        if (firstElement != null) {
            firstElement.prev = newNode;
        }

        firstElement = newNode;
        size++;

        if (size == 1){
            lastElement = firstElement;
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = firstElement.next;
        if (firstElement != null) {
            firstElement.prev = null;
        }

        removedNode.next = null;
        removedNode.prev = null;

        size--;
        if (isEmpty()){
            lastElement = null;
        }

        return removedNode.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()){
            return null;
        }
        Node<E> removedNode = lastElement;
        E value = getValue(removedNode);

        lastElement = removedNode.prev;

        if(lastElement != null){
            lastElement.next = null;
        }

        removedNode.next = null;
        removedNode.prev = null;
        size--;

        if (isEmpty()){
            firstElement = null;
        }

        return value;
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
        } else if (current == lastElement) {
            removeLast();
            return true;
        } else {
            previous.next = current.next;
            previous.next.prev = previous;
        }

        current.next = null;
        current.prev = null;

        size--;

        return true;
    }

    public E getLast() {
        return getValue(lastElement);
    }
}
