package com.tarasenko.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class CountingSort{
    public void sort(int[] array, int maxNumber) {
        int[] freq = new int[maxNumber + 1];
        for (int i: array) {
            freq[i]++;
        }
        int index = 0;
        for (int i = 0; i < maxNumber; i++)
        {
            while (freq[i]-- > 0) {
                array[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] array = new int[10];
        Random random = new Random();

        int maxNumber = 100;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maxNumber);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        countingSort.sort(array, maxNumber);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
