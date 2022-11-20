package com.tarasenko.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            int saveValue = array[minPosition];
            array[minPosition] = array[i];
            array[i] = saveValue;
        }
    }

    public static final int ARRAY_MAX_NUMBER = 100;
    public static final int TEST_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = new int[TEST_ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(ARRAY_MAX_NUMBER);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        selectionSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
