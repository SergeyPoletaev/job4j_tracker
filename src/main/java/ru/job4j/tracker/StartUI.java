package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        this.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            this.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAllAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new FindItemByIdAction(output),
                new FindItemsByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
