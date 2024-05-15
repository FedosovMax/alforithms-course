package com.algorithms.course.forth.hashmap;

import java.util.HashSet;
import java.util.Hashtable;

public class Test {

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        new HashSet<>();
        map.put("100", "Spongebob");
        map.put("123", "Patrick");
        map.put("321", "Sandy");
        map.put("555", "Squidward");
        map.put("777", "Gary");

        System.out.println(map.get("100"));
        System.out.println(map.get("123"));
        System.out.println(map.get("321"));
        System.out.println(map.get("555"));
        System.out.println(map.get("777"));
    }
}
