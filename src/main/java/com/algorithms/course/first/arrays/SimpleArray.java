package com.algorithms.course.first.arrays;

import java.util.Arrays;

public class SimpleArray {

    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray();
        simpleArray.perform();
    }

    private void perform() {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(numbers));
    }
}
