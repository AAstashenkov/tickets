package org.asta.hashSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Asta
 */
public class HashSet {

    private final int ARRAY_SIZE = 100;
    private List<List<Integer>> buckets;

    public HashSet() {
        buckets = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        int index = getIndex(key);
        List<Integer> bucket = buckets.get(index);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        List<Integer> bucket = buckets.get(index);
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        List<Integer> bucket = buckets.get(index);
        return bucket.contains(key);
    }

    public void display() {
        for (List<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                System.out.println(bucket);
            }
        }
    }

    private int getIndex(int key) {
        return Math.abs(key % ARRAY_SIZE);
    }
}