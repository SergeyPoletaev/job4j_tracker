package ru.job4j.tracker.oop;

public class Max {

    public int max(int first, int second) {
        return first >= second ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(third, max(first, second));
    }

    public int max(int first, int second, int third, int four) {
        return max(first, max(second, third, four));
    }
}
