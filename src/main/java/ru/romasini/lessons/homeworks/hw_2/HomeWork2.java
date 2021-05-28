package ru.romasini.lessons.homeworks.hw_2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 1. Создать массив большого размера (миллион элементов).
 * 2. Написать методы удаления, добавления, поиска элемента массива.
 * 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
 */

public class HomeWork2 {

    public static void main(String[] args) {
        int n = 50000;
        Random random = new Random();

        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = random.nextInt(n);
        }

        long start, end;
        Array<Integer> arrBubble = new ArrayImpl<>(n);
        fillRandom(arrBubble, source);

        System.out.println("Сортировка: пузырьковая");
        arrBubble.display();

        start = System.nanoTime();
        arrBubble.sortBubble();
        end = System.nanoTime();

        arrBubble.display();
        System.out.println("Длительность:" + TimeUnit.NANOSECONDS.toMillis(end - start) + " мс");

        System.out.println();

        Array<Integer> arrSelect = new ArrayImpl<>(n);
        fillRandom(arrSelect, source);
        System.out.println("Сортировка: метод выбора");
        arrSelect.display();

        start = System.nanoTime();
        arrSelect.sortSelect();
        end = System.nanoTime();

        arrSelect.display();
        System.out.println("Длительность:" + TimeUnit.NANOSECONDS.toMillis(end - start) + " мс");

        System.out.println();

        Array<Integer> arrInsert = new ArrayImpl<>(n);
        fillRandom(arrInsert, source);

        System.out.println("Сортировка: метод вставки");
        arrInsert.display();

        start = System.nanoTime();
        arrInsert.sortInsert();
        end = System.nanoTime();

        arrInsert.display();
        System.out.println("Длительность:" + TimeUnit.NANOSECONDS.toMillis(end - start) + " мс");

    }


    public static void fillRandom(Array<Integer> array, int[] source){
        for (int i = 0; i < source.length; i++) {
            array.add(source[i]);
        }
    }


}
