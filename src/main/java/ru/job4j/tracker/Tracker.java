package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<Item>();
    }

    public List<Item> findByName(String key) {
        List<Item> items1 = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                items1.add(item);
            }
        }
        return items1;
    }

    public Item findById(int id) {
        int index = items.indexOf(items.get(id));
        return index != -1 ? items.get(id) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = item.getId();
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}