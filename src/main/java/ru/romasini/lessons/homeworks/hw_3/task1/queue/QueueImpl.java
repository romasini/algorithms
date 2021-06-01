package ru.romasini.lessons.homeworks.hw_3.task1.queue;

public class QueueImpl<E> implements Queue<E> {

    private final E[] data;
    private int size;

    private int tail;
    private int head;

    private static final int HEAD_DEFAULT = 0;
    private static final int TAIL_DEFAULT = -1;


    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insert(E value) {
        if(isFull()){
            return false;
        }

        if(tail == data.length - 1){
            tail = TAIL_DEFAULT;
        }

        data[++tail] = value;
        size++;

        return true;

    }

    @Override
    public E remove() {
        if(isEmpty()){
            return null;
        }

        if (head == data.length){
            head = HEAD_DEFAULT;
        }

        E value = data[head++];
        size--;

        return value;
    }

    @Override
    public E peekFront() {
        return data[head];
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
    public boolean isFull() {
        return size == data.length;
    }
}
