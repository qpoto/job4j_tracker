package ru.job4j.tracker;

public class FindActionById implements UserAction {
    private final Output out;

    public FindActionById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item.getId() > 0) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
