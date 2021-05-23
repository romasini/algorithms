package ru.romasini.grok.binary;

import java.util.Scanner;

public class Binary {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи число");
        int num = sc.nextInt();
        System.out.println(num);
        System.out.println(binarySearch(arr, num));


    }

    public static int binarySearch(int[] arr, int num){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        if (num > arr[high] || num < arr[low]) return -1;

        while (low <= high){
            mid = (high + low)/2;
            if(num == arr[mid]){
                return mid;
            }else if(num > arr[mid]){
                low = mid+1;
            }else if(num < arr[mid]){
                high = mid-1;
            }
        }

        return mid;
    }

}
