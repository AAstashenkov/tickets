package org.asta.arrayList;

/**
 * @author Asta
 */
public class ArrayList {

    private String[] array = new String[10];
    private int size = 0;

    public void put(String s) {
        array[size] = s;
        size++;
        if (size == array.length) {
            String[] newArray = new String[array.length * 2];
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
        size--;
    }

    public String getByIndex(int index) {
        return array[index];
    }


    public int getSize() {
        return size;
    }
}