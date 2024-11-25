package org.asta;

import org.asta.arrayList.ArrayList;
import org.asta.hashSet.HashSet;

/**
 * @author Asta
 */
public class Application {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("ArrayList: ");
        arrayList.put("One");
        arrayList.put("Two");
        arrayList.put("Three");

        showArrayList(arrayList);

        arrayList.delete(1);
        System.out.println("ArrayList: ");
        showArrayList(arrayList);

        System.out.println("Get by index: " + arrayList.getByIndex(0));

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        System.out.println("HashSet:");
        hashSet.display();
    }

    public static void showArrayList(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.getSize(); i++) {
            System.out.println(arrayList.getByIndex(i));
        }
    }
}