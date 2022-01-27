package ru.job4j.tracker.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                rsl.add(cell);
            }
        }
        return rsl;
    }
}
