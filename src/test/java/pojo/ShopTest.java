package pojo;

import org.junit.Assert;
import org.junit.Test;

public class ShopTest {

    @Test
    public void whenNull1ThenIndexOfNull1() {
        Product[] products = {new Product("Milk", 1), null, new Product("Water", 4)};
        int rsl = Shop.indexOfNull(products);
        int exp = 1;
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenNullFirstThenIndexOfNull0() {
        Product[] products = {null, new Product("Milk", 1), new Product("Water", 4)};
        int rsl = Shop.indexOfNull(products);
        int exp = 0;
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenNullLastThenIndexOfNull2() {
        Product[] products = {new Product("Milk", 1), new Product("Water", 4), null};
        int rsl = Shop.indexOfNull(products);
        int exp = 2;
        Assert.assertEquals(exp, rsl);
    }

    @Test
    public void whenNotNullThenIndexOfNullMinus1() {
        Product[] products = {new Product("Milk", 1), new Product("Water", 4)};
        int rsl = Shop.indexOfNull(products);
        int exp = -1;
        Assert.assertEquals(exp, rsl);
    }
}