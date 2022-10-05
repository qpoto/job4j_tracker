package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class EditActionTest {

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Tracker tracker = new Tracker();
        Item one = new Item("test1");
        tracker.add(one);
        Output out = new StubOutput();
        UserAction[] actions = {new EditAction(out), new Exit()};
        String replaceName = "New Test Name";
        String ln = System.lineSeparator();
        Input input = new StubInput(new String[] {"0", String.valueOf(one.getId()), replaceName, "1"});
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln));
    }

}