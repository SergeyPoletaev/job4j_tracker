package ru.job4j.tracker;

public class CreateManyAction implements UserAction {
    private final Output out;

    public CreateManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        this.out.println("=== Create new Items ===");
        for (int i = 0; i < 7000; i++) {
            Item item = new Item("test" + i);
            tracker.add(item);
            this.out.println("Добавленная заявка " + item);
        }
        return true;
    }
}
