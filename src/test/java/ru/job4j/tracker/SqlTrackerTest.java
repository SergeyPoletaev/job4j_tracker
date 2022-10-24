package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SqlTrackerTest {
    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenTestFindById() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item rsl = tracker.findById(item.getId());
        assertThat(rsl.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        Store tracker = new SqlTracker(connection);
        Item first = new Item("item1");
        Item second = new Item("item2");
        tracker.add(first);
        tracker.add(second);
        assertThat(tracker.findAll(), is(List.of(first, second)));
    }

    @Test
    public void whenTestFindByName() {
        Store tracker = new SqlTracker(connection);
        tracker.add(new Item("item1"));
        Item second = new Item("item2");
        Item third = new Item("item2");
        tracker.add(second);
        tracker.add(third);
        assertThat(tracker.findByName("item2"), is(List.of(second, third)));
    }

    @Test
    public void whenReplace() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item newItem = new Item("item2");
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()).getName(), is(newItem.getName()));
    }

    @Test
    public void whenDelete() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}