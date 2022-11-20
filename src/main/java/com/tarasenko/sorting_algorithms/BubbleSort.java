package com.tarasenko.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = array.length - 1; j > i; j--) {
                if ( array[j-1] > array[j] ) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static final int ARRAY_MAX_NUMBER = 100;
    public static final int TEST_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[TEST_ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(ARRAY_MAX_NUMBER);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        bubbleSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
