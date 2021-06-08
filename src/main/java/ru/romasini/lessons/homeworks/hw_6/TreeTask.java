package ru.romasini.lessons.homeworks.hw_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 1. Создать и запустить программу для построения двоичного дерева.
 * В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 */

public class TreeTask {
    public static void main(String[] args) {

        int maxCount = 20;
        int maxLevel = 4;
        int maxSize = (int) (Math.pow(2, maxLevel) - 1);
        int maxBound = 25;
        Random random = new Random();
        List<Tree<Integer>> treeList = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            Tree<Integer> temp = new TreeImpl<>(maxLevel);
            treeList.add(temp);
            for (int j = 0; j < maxSize; j++) {
                temp.add(random.nextInt(2 * maxBound) - maxBound);
            }
        }

        int balancedCount = 0;
        for (Tree<Integer> tree : treeList) {
            if (tree.isBalanced()) {
                balancedCount++;
                System.out.println("BINGO");
            }
            tree.display();
        }

        System.out.println("Balanced trees: " + balancedCount + "/" + maxCount);
        System.out.println("Balanced trees, %: " + 100*balancedCount/maxCount );

    }
}
