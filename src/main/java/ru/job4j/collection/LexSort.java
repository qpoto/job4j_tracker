package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftNumber = left.split("\\.");
        int leftNum = Integer.parseInt(leftNumber[0]);
        String[] rightNumber = right.split("\\.");
        int rightNum = Integer.parseInt(rightNumber[0]);
        return Integer.compare(leftNum, rightNum);
    }
}