package ru.job4j.tracker.ex;

public class FactRec {

    public static int fact(int n) {
        return n != 0 && n != 1 ? n * fact(n - 1) : 1;
    }

    public static void main(String[] args) {
        int rsl = fact(3);
        System.out.println(rsl);
    }
}
