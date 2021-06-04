package ru.romasini.lessons.homeworks.hw_5.task2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 */

public class BagTask {

    public static final int BAG_WEIGHT = 6;
    private int maxCost;
    private ArrayList<Item> resultList;
    private ArrayList<Item> items;

    public static void main(String[] args) {

        BagTask bt = new BagTask();
        bt.items = new ArrayList<>(Arrays.asList(
                new Item("Книга", 600,  1),
                new Item("Бинокль", 5000, 2),
                new Item("Аптечка", 1500, 3),
                new Item("Ноутбук", 40000, 3),
                new Item("Котелок", 500, 1))
        );
        bt.resultList = new ArrayList<>();
        ArrayList<Item> newItems = bt.getOptimal();

        System.out.println("Result:");
        System.out.println(newItems);
        System.out.println("Cost: " + getCost(newItems));
        System.out.println("Weight: " + getWeight(newItems));

    }

    public ArrayList<Item> getOptimal(){
        find(items.size());
        return resultList;
    }

    private void find(int size) {

        if (size == 1) {
            return;
        }

        Item temp;
        ArrayList<Item> tempList;

        for (int i = 0; i < size; i++) {
            find(size - 1);
            tempList = new ArrayList<>();
            for (int j = items.size() - 1; j >= 0; j--) {
                temp = items.get(j);
                if (getWeight(tempList) + temp.weight <= BAG_WEIGHT) {
                    tempList.add(temp);
                    if (getCost(tempList) > maxCost) {
                        maxCost = getCost(tempList);
                        resultList = tempList;
                    }
                } else {
                    break;
                }
            }
            if (tempList.size() != size) {
                rotate(size);
            }else {
                break;
            }
        }

    }

    private void rotate(int size) {
        int pos = items.size() - size;
        Item temp = items.get(pos);

        for (int i = pos + 1; i < items.size(); i++) {
            items.set(i - 1, items.get(i));
        }

        items.set(items.size() - 1, temp);
    }

    public static int getWeight(ArrayList<Item> items){
        return items.stream().mapToInt(o->o.weight).sum();
    }

    public static int getCost(ArrayList<Item> items){
        return items.stream().mapToInt(o->o.cost).sum();
    }

    private static class Item{

        final String title;
        final int cost;
        final int weight;

        public Item(String title, int cost, int weight) {
            this.title = title;
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return title + " {cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }
    }

}
