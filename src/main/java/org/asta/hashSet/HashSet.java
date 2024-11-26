package org.asta.hashSet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Asta
 */
public class HashSet<T> {

    private static final int ARRAY_SIZE = 100;
    private List<List<T>> buckets;

    public HashSet() {
        buckets = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public void add(T key) {
        int index = getIndex(key);
        List<T> bucket = buckets.get(index);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(T key) {
        int index = getIndex(key);
        List<T> bucket = buckets.get(index);
        bucket.remove(key);
    }

    public boolean contains(T key) {
        int index = getIndex(key);
        List<T> bucket = buckets.get(index);
        return bucket.contains(key);
    }

    public void display() {
        for (List<T> bucket : buckets) {
            if (!bucket.isEmpty()) {
                System.out.println(bucket);
            }
        }
    }

    private int getIndex(T key) {
        return Math.abs(key.hashCode() % ARRAY_SIZE);
    }
}

