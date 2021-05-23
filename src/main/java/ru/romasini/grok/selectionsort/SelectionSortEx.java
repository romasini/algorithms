package ru.romasini.grok.selectionsort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortEx {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int[] arrNew = selectionSort(arr);
        System.out.println(Arrays.toString(arrNew));
    }

    public static int smallest(int[] arr){
        int small = arr[0];
        int id = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<small){
                small = arr[i];
                id = i;
            }
        }
        return id;
    }

    public static int[] selectionSort(int[] arr){
        int[] arrNew = new int[arr.length];
//        ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(arr));
//        int small;
//        for (int i = 0; i < arrayList.size(); i++) {
//            small = smallest(arr);
//            arrNew[i] = arr[small];
//        }
        return arrNew;
    }
}
