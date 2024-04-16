package com.algorithms.course.arrayLists;


public class ArrayList<T> {

    public ArrayList() {
        // TODO implement a constructor with a default capacity of 5 elements
    }

    public ArrayList(int initCapacity) {
        //TODO implement a constructor with a provided capacity
    }

    public static <T> ArrayList<T> of(T... elements) {
        //TODO implement creation of an ArrayList with provided elements and return it
    }

    public void add(T element) {
        //TODO implement adding an element to the ArrayList
    }

    public void add(int index, T element) {
        //TODO implement adding an element to the provided index of the ArrayList
    }

    public T get(int index) {
        //TODO implement an element retrieval by an index from the ArrayList
    }

    public void set(int index, T element) {
        //TODO implement setting value by the index. Throw IndexOutOfBoundsException in case index is out of bounds
    }

    public T remove(int index) {
        //TODO implement removing of the value by the index. Throw IndexOutOfBoundsException in case index is out of bounds
    }

    public boolean contains(T element) {
        //TODO implement checking if element exists in the ArrayList
    }

    public boolean isEmpty() {
        //TODO implement checking if ArrayList is empty
    }

    public int size() {
        //TODO return amount of elements in the ArrayList
    }
}
