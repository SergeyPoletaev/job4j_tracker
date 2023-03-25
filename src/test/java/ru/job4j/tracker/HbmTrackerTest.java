package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.*;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HbmTrackerTest {
    private static SessionFactory sf;

    @BeforeClass
    public static void init() {
        sf = new HibernateConfig().getSessionFactory();
    }

    @AfterClass
    public static void close() {
        sf.close();
    }

    @After
    public void cleanDb() {
        Transaction tx = null;
        try (Session session = sf.openSession()) {
            tx = session.beginTransaction();
            session.createQuery("delete from Item").executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }

    @Test
    public void whenAddSomeItemThenInDbFindThisItem() {
        var tracker = new HbmTracker(sf);
        var item = new Item("test");
        tracker.add(item);
        var itemDb = tracker.findById(item.getId());
        assertThat(itemDb.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceItemThenInDbFindModifiedItem() {
        var tracker = new HbmTracker(sf);
        var item = new Item("test");
        tracker.add(item);
        var newItem = new Item("test1");
        var rsl = tracker.replace(item.getId(), newItem);
        var itemDb = tracker.findById(item.getId());
        Assert.assertTrue(rsl);
        assertThat(itemDb.getName(), is(newItem.getName()));
    }

    @Test
    public void whenDeleteItemThenInDbNotFound() {
        var tracker = new HbmTracker(sf);
        var item = new Item("test");
        tracker.add(item);
        Assert.assertTrue(tracker.delete(item.getId()));
        Assert.assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindAllItemsThenAllItemsFound() {
        var tracker = new HbmTracker(sf);
        var items = List.of(new Item(), new Item());
        items.forEach(tracker::add);
        var itemsDb = tracker.findAll();
        assertThat(itemsDb, is(items));
    }

    @Test
    public void whenFindItemByCorrectIdThenItemFound() {
        var tracker = new HbmTracker(sf);
        var item = new Item("test");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()).getName(), is(item.getName()));
    }

    @Test
    public void whenFindItemByIncorrectIdThenItemNotFound() {
        var tracker = new HbmTracker(sf);
        var item = new Item("test");
        tracker.add(item);
        Assert.assertNull(tracker.findById(2));
    }

    @Test
    public void whenFindItemByCorrectNameThenItemFound() {
        var tracker = new HbmTracker(sf);
        var item = new Item("test");
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is(item.getName()));
    }

    @Test
    public void whenFindItemByIncorrectNameThenItemNotFound() {
        var tracker = new HbmTracker(sf);
        var item = new Item("test");
        tracker.add(item);
        assertThat(tracker.findByName("test1"), is(Collections.EMPTY_LIST));
    }
}
