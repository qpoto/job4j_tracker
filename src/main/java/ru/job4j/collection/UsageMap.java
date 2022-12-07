package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> dictonary = new HashMap<>();
        dictonary.put("qpoto@yandex.ru", "Stanislav Kondratev");
        dictonary.put("o.markova@yandex.ru", "Olga Markova");
        dictonary.put("a.ageev@yandex.ru", "Anton Ageev");
        for (String key : dictonary.keySet()) {
            System.out.println(key);
        }
    }
}
