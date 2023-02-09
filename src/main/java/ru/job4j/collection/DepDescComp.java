package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
            String[] splitO1 = o1.split("/");
            String[] splitO2 = o2.split("/");
            int rst = splitO2[0].compareTo(splitO1[0]);
            return rst != 0 ? rst : o1.compareTo(o2);
    }
}