package com.tarasenko.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort{

    private void recursiveQuickSort(int[] array, int low, int high) {
        if (array.length < 2) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middleIndex = low + (high - low) / 2;
        int supportElement = array[middleIndex];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < supportElement) {
                i++;
            }
            while (array[j] > supportElement) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            recursiveQuickSort(array, low, j);
        }

        if (high > i) {
            recursiveQuickSort(array, i, high);
        }
    }


    public void sort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

    public static final int ARRAY_MAX_NUMBER = 100;
    public static final int TEST_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = new int[TEST_ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(ARRAY_MAX_NUMBER);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        quickSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

}
