package ru.job4j.tracker;

public class Exit implements UserAction {
    public String name() {
        return "Exit";
    }

    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
