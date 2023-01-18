package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left.equals(right)) {
            return 0;
        } else if (left.length() > right.length()) {
            return -1;
        } else {
            return 1;
        }
    }
}
