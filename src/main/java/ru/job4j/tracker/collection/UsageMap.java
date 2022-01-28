package ru.job4j.tracker.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a@mai.ru", "Ivanov Ivan Ivanovich");
        map.put("b@mail.ru", "Petrov Petr Petrovich");
        map.put("c@mail.ru", "Sidorova Anna Sergeevna");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
