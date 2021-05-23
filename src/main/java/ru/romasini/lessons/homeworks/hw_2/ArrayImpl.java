package ru.romasini.lessons.homeworks.hw_2;

import java.util.Arrays;
import java.util.Random;

public class ArrayImpl<E extends Comparable<? super E>> implements Array<E>{

    private static final int DEFAULT_CAPACITY = 8;
    private static final int DEFAULT_SHOW = 100;

    private E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    private void checkAndGrow() {
        if(data.length == size){
            data = Arrays.copyOf(data, calcNewLength());
        }
    }

    private int calcNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(String.format("Incorrect 'index': %d; max value = %d", index, size-1));
        }
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && remove(index) != null;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E removedValue = data[index];

        System.arraycopy(data, index + 1, data, index, size - index - 1);

        data[--size] = null;

        return removedValue;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if(value.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
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
    public void display() {
        System.out.println(this);
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size -1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if(data[j].compareTo(data[j+1]) > 0 ){
                    swap(j, j+1);
                }
            }
        }
    }

    private void swap(int indexA, int indexB) {
        E temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size -1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if(data[j].compareTo(data[minIndex])<0){
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in -1].compareTo(temp) >= 0){
                data[in] = data[in -1];
                in--;
            }
            data[in] = temp;
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        int currentSize = Math.min(size, DEFAULT_SHOW);

        for (int i = 0; i < currentSize - 1; i++) {
            sb.append(data[i]).append(", ");
        }

        if (currentSize > 0) {
            sb.append(data[currentSize - 1]);
        }

        if (currentSize < size){
            sb.append("... ");
        }
        sb.append("]");

        return sb.toString();
    }

}
