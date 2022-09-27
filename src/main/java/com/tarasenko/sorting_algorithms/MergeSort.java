package com.tarasenko.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class MergeSort{
    private void merge(int[] arr, int left, int middle, int right) {
        int sizeOfFirstSubarray = middle - left + 1;
        int sizeOfSecondSubarray = right - middle;

        int[] tempL = new int[sizeOfFirstSubarray];
        int[] tempR = new int[sizeOfSecondSubarray];

        System.arraycopy(arr, left + 0, tempL, 0, sizeOfFirstSubarray);
        System.arraycopy(arr, middle + 1, tempR, 0, sizeOfSecondSubarray);

        int i = 0, j = 0;
        int indexOfMergedArray = left;
        while (i < sizeOfFirstSubarray && j < sizeOfSecondSubarray) {
            if (tempL[i] <= tempR[j]) {
                arr[indexOfMergedArray] = tempL[i];
                i++;
            } else {
                arr[indexOfMergedArray] = tempR[j];
                j++;
            }
            indexOfMergedArray++;
        }

        while (i < sizeOfFirstSubarray) {
            arr[indexOfMergedArray] = tempL[i];
            i++;
            indexOfMergedArray++;
        }

        while (j < sizeOfSecondSubarray) {
            arr[indexOfMergedArray] = tempR[j];
            j++;
            indexOfMergedArray++;
        }
    }

    private void recursiveMergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middleElement = left + (right - left) / 2;
            recursiveMergeSort(arr, left, middleElement);
            recursiveMergeSort(arr, middleElement + 1, right);
            merge(arr, left, middleElement, right);
        }
    }

    public void sort(int[] array) {
        if (array == null) {
            return;
        }
        recursiveMergeSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Before sorting: " + Arrays.toString(array));

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }
}
