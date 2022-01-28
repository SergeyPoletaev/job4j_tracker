package ru.job4j.tracker.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConvert {

    public Map<String, Order> process(List<Order> orders) {
        Map<String, Order> rsl = new HashMap<>();
        for (Order order : orders) {
            rsl.put(order.getNumber(), order);
        }
        return rsl;
    }
}
