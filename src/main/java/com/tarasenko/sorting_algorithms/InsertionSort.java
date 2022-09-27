package com.tarasenko.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort{
    public void sort(int[] array) {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }


    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        insertionSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
