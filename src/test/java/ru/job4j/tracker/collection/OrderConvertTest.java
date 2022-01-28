package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class OrderConvertTest {

    @Test
    public void process() {
        OrderConvert orderConvert = new OrderConvert();
        Order order = new Order("123", "test1");
        List<Order> orders = List.of(order);
        Map<String, Order> exp = Map.of(order.getNumber(), order);
        Map<String, Order> rsl = orderConvert.process(orders);
        Assert.assertEquals(exp, rsl);
    }
}