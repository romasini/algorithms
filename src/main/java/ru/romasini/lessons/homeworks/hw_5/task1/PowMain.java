package ru.romasini.lessons.homeworks.hw_5.task1;

/**
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 */

public class PowMain {

    public static void main(String[] args) {
        System.out.println(pow(2,3));
    }

    public static long pow(long base, int exp){

        if(exp < 1){
            return 1;
        }

        return base * pow(base, --exp);

    }

}
