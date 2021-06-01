package ru.romasini.lessons.homeworks.hw_3.task3.deque;

public class DequeImpl<E> implements Deque<E> {

    private final E[] data;
    private int size;

    private int tail;
    private int head;

    private static final int HEAD_DEFAULT = 0;
    private static final int TAIL_DEFAULT = -1;

    @SuppressWarnings("unchecked")
    public DequeImpl(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.head = HEAD_DEFAULT;
        this.tail = TAIL_DEFAULT;
    }

    @Override
    public boolean insertFirst(E value) {
        if(isFull()){
            return false;
        }

        if(isEmpty()){
            head = HEAD_DEFAULT;
        }else{
            head--;
            if(head < HEAD_DEFAULT){
                head = data.length - 1;
            }
        }

        if (tail == TAIL_DEFAULT) {
            tail = HEAD_DEFAULT;
        }

        data[head] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertLast(E value) {

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
    public E removeFirst() {
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
    public E removeLast() {

        if(isEmpty()){
            return null;
        }

        E value = data[tail];

        if(tail < head){
            if(tail == HEAD_DEFAULT){
                tail = data.length -1;
            }else {
                tail--;
            }
        }else if(tail > head){
            tail--;
        }else {
            //удаляем последний элемент, установим стандартное положение
            head = HEAD_DEFAULT;
            tail = TAIL_DEFAULT;
        }

        size--;

        return value;
    }

    @Override
    public E peekFirst() {
        return data[head];
    }

    @Override
    public E peekLast() {
        return data[tail];
    }

    @Override
    public boolean insert(E value) {
        return insertLast(value);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E peekFront() {
        return peekFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
