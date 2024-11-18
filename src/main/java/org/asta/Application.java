package org.asta;

import org.asta.arrayList.ArrayList;
import org.asta.hashSet.HashSet;

/**
 * @author Asta
 */

public class Application {

    private static ArrayList arrayList = new ArrayList();

    public static void main(String[] args) {

        System.out.println("Array list:");
        arrayList.put("One");
        arrayList.put("Two");
        arrayList.put("Three");

        showArrayList();

        arrayList.delete(1);
        System.out.println("Custom array list after deletions: ");

        showArrayList();

        System.out.println("Get by index: " + arrayList.getByIndex(2));

        System.out.println("Creating a customHashSet:");
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        System.out.println("Displaying custom hashset");
        hashSet.display();
    }

    public static void showArrayList() {
        for(int i = 0; i < arrayList.getSize(); i++) {
            System.out.println(arrayList.getByIndex(i));
        }
    }
}