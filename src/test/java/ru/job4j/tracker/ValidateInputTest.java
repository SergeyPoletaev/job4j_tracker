package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenValidMultiInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2", "3", "4"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selectedFirst = input.askInt("Enter menu:");
        int selectedSecond = input.askInt("Enter menu:");
        int selectedThird = input.askInt("Enter menu:");
        assertThat(selectedFirst, is(2));
        assertThat(selectedSecond, is(3));
        assertThat(selectedThird, is(4));
    }

    @Test
    public void whenValidAsNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-2"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }
}