package ru.romasini.lessons.homeworks.hw_3.task2;

import ru.romasini.lessons.homeworks.hw_3.task1.stack.Stack;
import ru.romasini.lessons.homeworks.hw_3.task1.stack.StackImpl;

import java.util.Deque;

public class Task2 {
    public static void main(String[] args) {
        String str = "123456";
        System.out.println(flipString(str));
    }

    public static String flipString(String str){
        Stack<Character> stack = new StackImpl<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
