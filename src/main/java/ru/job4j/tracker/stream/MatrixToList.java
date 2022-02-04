package ru.job4j.tracker.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {

    public static List<Integer> convert(Integer[][] numbers) {
        return Arrays.stream(numbers)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
