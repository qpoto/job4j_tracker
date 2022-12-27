package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, "Second"));
        items.add(new Item(3, "Third"));
        items.add(new Item(1, "First"));
        items.sort(new ItemAscByName());
        System.out.println(items);

        List<Item> expected = new ArrayList<>();
        items.add(new Item(1, "First"));
        items.add(new Item(2, "Second"));
        items.add(new Item(3, "Third"));
        assertThat(items).isEquaTo(expected);
    }
}