package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class OrderConvertTest {

    @Test
    public void whenSingleElementList() {
        OrderConvert orderConvert = new OrderConvert();
        Order order = new Order("123", "test1");
        List<Order> orders = List.of(order);
        Map<String, Order> exp = Map.of(order.getNumber(), order);
        Map<String, Order> rsl = orderConvert.process(orders);
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenWithDuplicateElementsList() {
        OrderConvert orderConvert = new OrderConvert();
        Order order1 = new Order("123", "test1");
        Order order2 = new Order("124", "test2");
        Order order3 = new Order("123", "test3");
        List<Order> orders = List.of(order1, order2);
        Map<String, Order> exp = Map.of(
                order1.getNumber(), order3,
                order2.getNumber(), order2
        );
        Map<String, Order> rsl = orderConvert.process(orders);
        Assert.assertEquals(exp, rsl);
    }
}