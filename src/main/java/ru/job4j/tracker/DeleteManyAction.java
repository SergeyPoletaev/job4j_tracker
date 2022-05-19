package ru.job4j.tracker;

public class DeleteManyAction implements UserAction {
    private final Output out;

    public DeleteManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        this.out.println("=== Delete many items ===");
        for (int i = 1; i <= 7000; i++) {
            if (tracker.delete(i)) {
                this.out.println("Заявка удалена успешно");
            } else {
                this.out.println("Ошибка удаления заявки");
            }
        }
        return true;
    }
}
