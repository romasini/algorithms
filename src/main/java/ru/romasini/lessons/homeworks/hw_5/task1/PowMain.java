package ru.romasini.lessons.homeworks.hw_5.task1;

/**
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 */

public class PowMain {

    public static void main(String[] args) {
        System.out.println(pow(2,3));
        System.out.println(powTail(2,3));
    }

    public static long pow(long base, int exp){

        if(exp < 1){
            return 1;
        }

        return base * pow(base, --exp);

    }

    public static long powTail(long base, int exp){
        return pow(base, exp, 1);
    }

    public static long pow(long base, int exp, long acc){

        if(exp < 1){
            return acc;
        }

        return pow(base, --exp, acc * base);

    }

}
