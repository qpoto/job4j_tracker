package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {
    @Test
    public void sortByUpName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, "Second"));
        items.add(new Item(3, "Third"));
        items.add(new Item(1, "First"));
        Collections.sort(items, new ItemAscByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1, "First"));
        expected.add(new Item(2, "Second"));
        expected.add(new Item(3, "Third"));
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void sortByDownName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, "Second"));
        items.add(new Item(3, "Third"));
        items.add(new Item(1, "First"));
        Collections.sort(items, new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item(3, "Third"));
        expected.add(new Item(2, "Second"));
        expected.add(new Item(1, "First"));
        assertThat(items).isEqualTo(expected);
    }
}