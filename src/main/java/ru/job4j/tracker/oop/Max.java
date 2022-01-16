package ru.job4j.tracker.oop;

public class Max {

    public int max(int first, int second) {
        return first >= second ? first : second;
    }

    public int max(int first, int second, int third) {
        return third >= max(first, second) ? third : max(first, second);
    }

    public int max(int first, int second, int third, int four) {
        return max(first, second) >= max(third, four) ? max(first, second) : max(third, four);
    }
}
