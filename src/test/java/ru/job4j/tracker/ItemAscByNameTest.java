package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.*;

public class ItemAscByNameTest {

    @Test
    public void compare() {
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
}