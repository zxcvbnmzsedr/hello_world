package com.ztianzeng.learn.collection;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RandomIt implements Iterable<Integer> {

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return new Random().nextInt(10);
            }
        };
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        Integer[] strings = a.toArray(Integer[]::new);

        final RandomIt integers = new RandomIt();
        final Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < 100; i++) {
            if (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}
