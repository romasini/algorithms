package ru.romasini.grok.sum;

import java.util.ArrayList;
import java.util.Random;

public class SumEx {

    public static void main(String[] args) {

        int n = 2;
        ArrayList<Integer> arrayList = new ArrayList<>(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arrayList.add(random.nextInt(100));
        }
        System.out.println(arrayList);
        //System.out.println(sum(arrayList));
        //System.out.println(count(arrayList));
        System.out.println(max(arrayList));


    }

    public static int sum(ArrayList<Integer> arr){

        if(arr.isEmpty()){
            return 0;
        }else {
            return arr.remove(0) + sum(arr);
        }

    }

    public static int count(ArrayList<Integer> arr){
        if(arr.isEmpty()){
            return 0;
        }else {
            arr.remove(0);
            return 1 + count(arr);
        }
    }

    public static Integer max(ArrayList<Integer> arr){
        if(arr.size() == 1){
            return arr.remove(0);
        }else {
            Integer max = arr.remove(0);
            Integer temp = max(arr);
            return max.compareTo(temp)>0 ? max : temp;
        }
    }
}
