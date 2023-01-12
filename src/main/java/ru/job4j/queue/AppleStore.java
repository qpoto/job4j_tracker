package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 1; i <= count; i++) {
            String name = queue.poll().name();
            if (i == count) {
                return name;
            }
        }
        return "";
    }

    public String getLastUpsetCustomer() {
        for (int i = 1; i <= count + 1; i++) {
            String name = queue.poll().name();
            if (i > count) {
                return name;
            }
        }
        return "";
    }
}
