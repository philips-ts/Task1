package com.tarasenko.sorting_algorithms;


import java.util.Arrays;
import java.util.Random;

public class BucketSort {
    private int maxValue(int[] array)
    {
        int max_value = 0;
        for (int elem : array) {
            if (elem > max_value) {
                max_value = elem;
            }
        }
        return max_value;
    }

    public int[] sort(int[] array)
    {
        int max_value = maxValue(array);
        int[] bucket = new int[max_value + 1];
        int[] sorted_arr = new int[array.length];

        for (int k : array) bucket[k]++;

        int pos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                sorted_arr[pos++] = i;
            }
        }

        return sorted_arr;
    }

    public static final int ARRAY_MAX_NUMBER = 100;
    public static final int TEST_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] array = new int[TEST_ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(ARRAY_MAX_NUMBER);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        int[] sortedArray = bucketSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(sortedArray));
    }
}
