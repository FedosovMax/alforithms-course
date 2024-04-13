package com.algorithms.course.arrays;

import java.util.Arrays;

public class DoubleArray {

    public static void main(String[] args) {
        DoubleArray doubleArray = new DoubleArray();
//        doubleArray.printDoubleArray();
//        doubleArray.printTripleArray();
        doubleArray.printQuadroArray();
    }

    private void printDoubleArray() {
        int[][] numbers1 = new int[][]{{1, 2, 3, 4, 5, 6, 7}, {10, 11, 12, 13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(numbers1));
        System.out.println(numbers1[0][0]);
        System.out.println(numbers1[0][1]);
        System.out.println(numbers1[1][0]);
        System.out.println(numbers1[1][1]);
    }

    private void printTripleArray() {
        int[][] numbers = new int[][]{{1, 2, 3, 4, 5, 6, 7}, {10, 11, 12, 13, 14, 15, 16}, {21, 22, 23, 24, 25, 26, 27}};
        System.out.println(Arrays.deepToString(numbers));
        System.out.println(numbers[0][0]);
        System.out.println(numbers[0][1]);

        System.out.println(numbers[1][0]);
        System.out.println(numbers[1][1]);

        System.out.println(numbers[2][0]);
        System.out.println(numbers[2][1]);
    }

    private void printQuadroArray() {
        int[][][] numbers = new int[][][]{{{1, 2, 3, 4, 5, 6, 7}, {10, 11, 12, 13, 14, 15, 16}}, {{21, 22, 23, 24, 25, 26, 27}}};
        System.out.println(Arrays.deepToString(numbers));
        System.out.println(numbers[0][0][0]);
        System.out.println(numbers[0][1][0]);

        System.out.println(numbers[1][0][0]);
        System.out.println(numbers[1][0][1]);

        System.out.println(numbers[0][0][1]);
        System.out.println(numbers[0][1][2]);

        System.out.println(numbers[0][1][4]);
        System.out.println(numbers[0][0][5]);
    }


}
