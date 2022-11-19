package ru.job4j.tracker;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Output out = new ConsoleOutput();
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        Output out = new ConsoleOutput();
        List<UserAction> actions = List.of(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        Output out = new ConsoleOutput();
        List<UserAction> actions = List.of(
                new DeleteAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
                        + "=== Exit program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenEditItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = List.of(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно" + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit program ===" + ln
        ));
    }

    @Test
    public void whenEditItemTestOutputIsFailure() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", "1", replaceName, "1"}
        );
        List<UserAction> actions = List.of(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Edit item ===" + ln
                        + "Ошибка замены заявки" + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit program ===" + ln
        ));
    }

    @Test
    public void whenShowAllTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test"));
        String[] answers = {"0", "1"};
        Input input = new StubInput(answers);
        List<UserAction> actions = List.of(
                new ShowAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit program ===" + ln
        ));
    }

    @Test
    public void whenShowAllTestOutputIsFailure() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String[] answers = {"0", "1"};
        Input input = new StubInput(answers);
        List<UserAction> actions = List.of(
                new ShowAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test"));
        String searchingName = "test";
        String[] answer = {"0", searchingName, "1"};
        Input input = new StubInput(answer);
        List<UserAction> actions = List.of(
                new FindItemsByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit program ===" + ln
        ));
    }

    @Test
    public void whenFindByNameTestOutputIsFailure() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String searchingName = "test";
        String[] answer = {"0", searchingName, "1"};
        Input input = new StubInput(answer);
        List<UserAction> actions = List.of(
                new FindItemsByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Заявки с именем: " + searchingName + " не найдены" + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test"));
        String searchingId = String.valueOf(one.getId());
        String[] answer = {"0", searchingId, "1"};
        Input input = new StubInput(answer);
        List<UserAction> actions = List.of(
                new FindItemByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit program ===" + ln
        ));
    }

    @Test
    public void whenFindByIdTestOutputIsFailure() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String searchingId = "1";
        String[] answer = {"0", searchingId, "1"};
        Input input = new StubInput(answer);
        List<UserAction> actions = List.of(
                new FindItemByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Заявка с id: " + searchingId + " не найдена" + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "=== Exit program ===" + ln
        ));
    }

    @Test
    public void whenInvalidNumberExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"7", "0"}
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu." + ln
                                + "0. Exit Program" + ln
                                + "Wrong input, you can select: 0 .. 0" + ln
                                + "Menu." + ln
                                + "0. Exit Program" + ln
                                + "=== Exit program ===" + ln
                )
        );
    }

    @Test
    public void whenExecuteEditActionSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        UserAction action = new EditAction(out);
        Input in = mock(Input.class);
        when(in.askInt(any(String.class))).thenReturn(1);
        when(in.askStr(any(String.class))).thenReturn(replacedName);
        action.execute(in, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Заявка изменена успешно" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenExecuteEditActionFail() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String replacedName = "Replaced item";
        tracker.add(new Item(replacedName));
        UserAction action = new EditAction(out);
        Input in = mock(Input.class);
        action.execute(in, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Ошибка замены заявки" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenExecuteDeleteActionSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted Item"));
        UserAction action = new DeleteAction(out);
        Input in = mock(Input.class);
        when(in.askInt(any(String.class))).thenReturn(1);
        action.execute(in, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Заявка удалена успешно" + ln));
        assertThat(tracker.findAll(), is(Collections.EMPTY_LIST));
    }

    @Test
    public void whenExecuteDeleteActionFail() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Deleted Item"));
        UserAction action = new DeleteAction(out);
        Input in = mock(Input.class);
        action.execute(in, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ===" + ln + "Ошибка удаления заявки" + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Deleted Item"));
    }

    @Test
    public void whenExecuteFindItemByIdActionSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("new Item");
        tracker.add(item);
        UserAction action = new FindItemByIdAction(out);
        Input in = mock(Input.class);
        when(in.askInt(any(String.class))).thenReturn(1);
        action.execute(in, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + item + ln));
        assertThat(tracker.findById(1).getName(), is("new Item"));
    }

    @Test
    public void whenExecuteFindItemByIdActionFail() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("new Item");
        tracker.add(item);
        UserAction action = new FindItemByIdAction(out);
        Input in = mock(Input.class);
        action.execute(in, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ===" + ln + "Заявка с id: 0 не найдена" + ln));
        assertThat(tracker.findById(0), is(nullValue()));
    }

    @Test
    public void whenExecuteFindItemByNameActionSuccess() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("new Item");
        tracker.add(item);
        UserAction action = new FindItemsByNameAction(out);
        Input in = mock(Input.class);
        when(in.askStr(any(String.class))).thenReturn(item.getName());
        action.execute(in, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + item + ln));
        assertThat(tracker.findByName(item.getName()), is(List.of(item)));
    }

    @Test
    public void whenExecuteFindItemByNameActionFail() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("new Item");
        tracker.add(item);
        UserAction action = new FindItemsByNameAction(out);
        Input in = mock(Input.class);
        String searchName = "Item";
        when(in.askStr(any(String.class))).thenReturn(searchName);
        action.execute(in, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + "Заявки с именем: " + searchName + " не найдены" + ln));
        assertThat(tracker.findByName(searchName), is(Collections.EMPTY_LIST));
    }
}