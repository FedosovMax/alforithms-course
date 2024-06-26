package com.algorithms.course.second.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] input = {14, 8, 2, 12, 33, 0, 11, 17};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sortArray(input);
        Arrays.stream(input).forEach(System.out::println);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    private void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;
        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(inputArray, leftHalf, rightHalf);
    }

    private void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

}
