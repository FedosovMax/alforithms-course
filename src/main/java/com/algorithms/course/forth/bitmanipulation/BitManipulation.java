package com.algorithms.course.forth.bitmanipulation;

public class BitManipulation {

    public static void main(String[] args) {

        // & = AND          BOTH should 1
        // | = OR           AT LEAST ONE should be 1
        // ^ = XOR          ONLY ONE should be 1
        // << left shift
        // >> right shift

        int x = 6;  // 00000110
        int y = 12; // 00001100
        int z = 0;  // 00000110

        z = y >> 2;
        System.out.println(z);
    }

}
