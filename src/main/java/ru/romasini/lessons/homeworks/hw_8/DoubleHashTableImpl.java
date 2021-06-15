package ru.romasini.lessons.homeworks.hw_8;

public class DoubleHashTableImpl<K,V> extends HashTableImpl<K,V>{

    public static final int DOUBLE_HASH_CONST = 5;

    public DoubleHashTableImpl(int initialCapacity) {
        super(initialCapacity);
    }

    private int hashDoubleFunc(K key){
        return 5 - (key.hashCode() % DOUBLE_HASH_CONST);
    }

    @Override
    protected int getStep(K key) {
        return hashDoubleFunc(key);
    }
}
