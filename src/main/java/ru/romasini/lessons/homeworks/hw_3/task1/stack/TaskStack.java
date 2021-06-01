package ru.romasini.lessons.homeworks.hw_3.task1.stack;

public class TaskStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>(5);
        for (int i = 1; i <= 6 ; i++) {
            System.out.println(String.format("Add value %d: %b", i, addToStack(stack, i)));
        }
        System.out.println(stack);
        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack pop:" + removeFromStack(stack));
        System.out.println(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    private static Integer removeFromStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            return stack.pop();
        }
        return null;
    }

    private static boolean addToStack(Stack<Integer> stack, Integer value){
        if(!stack.isFull()){
            stack.push(value);
            return true;
        }
        return false;
    }
}
