package org.asta.arrayList;

/**
 * @author Asta
 */
public class ArrayList<T> {

    private static final int INITIAL_CAPACITY = 10;
    private T[] array;
    private int size = 0;

    public ArrayList() {
        array = (T[]) new Object[INITIAL_CAPACITY];
    }

    public void put(T element) {
        array[size] = element;
        size++;
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public T getByIndex(int index) {
        return array[index];
    }

    public int getSize() {
        return size;
    }

}
