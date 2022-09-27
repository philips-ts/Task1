package com.tarasenko.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class CombSort {

    public void sort(int[] array) {
        int gap = array.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.247330950103979);
            }
            int i = 0;
            swapped = false;
            while (i + gap < array.length) {
                if (array[i] > array[i + gap]) {
                    int t = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = t;
                    swapped = true;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        CombSort combSort = new CombSort();
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        combSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
