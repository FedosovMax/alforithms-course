package com.algorithms.course.first.arrayLists;


import java.util.Arrays;
import java.util.Objects;

public class ArrayListReady<T> {

    private static final int DEFAULT_CAPACITY = 5;
    private Object[] data;
    private int size;

    public ArrayListReady() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListReady(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[initialCapacity];
    }

    public static <T> ArrayListReady<T> of(T... elements) {
        ArrayListReady<T> list = new ArrayListReady<>(elements.length);
        list.data = Arrays.copyOf(elements, elements.length);
        list.size = elements.length;
        return list;
    }

    public void add(T element) {
        if (data.length == size) {
            data = Arrays.copyOf(data, size * 2);
        }
        data[size] = element;
        size++;
    }

    public void add(int index, T element) {
        if (data.length == size) {
            data = Arrays.copyOf(data, size * 2);
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) data[index];
    }

    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        data[index] = element;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T deletedElement = (T) data[index];

        if (index < size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }

        data[size - 1] = null;
        size--;
        return deletedElement;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
