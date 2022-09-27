package com.tarasenko.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    public void sort(int[] my_arr) {
        int arr_len = my_arr.length;
        for (int gap = arr_len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr_len; i += 1) {
                int temp = my_arr[i];
                int j;
                for (j = i; j >= gap && my_arr[j - gap] > temp; j -= gap) {
                    my_arr[j] = my_arr[j - gap];
                }
                my_arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        shellSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
