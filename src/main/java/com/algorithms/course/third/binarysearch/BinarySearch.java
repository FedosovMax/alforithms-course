package com.algorithms.course.third.binarysearch;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int target = 35;
        List<Integer> integers = List.of(1, 2, 3, 5, 6, 8, 11, 20, 35, 45);

//        int index = Arrays.binarySearch(integers.toArray(), target);
        int index = binarySearch(integers, target);

        if (index == -1) {
            System.out.println(target + " not found");
        } else {
            System.out.println("Element found at: " + index);
        }

    }

    private static int binarySearch(List<Integer> input, int target) {
        int low = 0;
        int high = input.size() - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int value = input.get(middle);

            System.out.println("Middle value: " + middle);

            if (value < target) {
                low = middle + 1;
            } else if (value > target) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
