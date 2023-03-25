package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private static final String FROM_ITEM = "from Item";
    private static final String FROM_ITEM_WHERE_NAME = "from Item where name = :key";
    private static final String FROM_ITEM_WHERE_ID = "from Item where id = :id";
    private static final String DELETE_FROM_ITEM = "delete from Item where id = :id";
    private static final String UPDATE_ITEM = "update Item set name = :name, created = :created where id = :id";
    private final SessionFactory sf;

    public HbmTracker(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            item.setId(id);
            session.update(item);
            rsl = session.createQuery(UPDATE_ITEM)
                    .setParameter("name", item.getName())
                    .setParameter("created", item.getCreated())
                    .setParameter("id", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            rsl = session.createQuery(DELETE_FROM_ITEM)
                    .setParameter("id", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> rsl = session.createQuery(FROM_ITEM, Item.class).list();
        session.close();
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> rsl = session.createQuery(FROM_ITEM_WHERE_NAME, Item.class)
                .setParameter("key", key)
                .list();
        session.close();
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item item = session.createQuery(FROM_ITEM_WHERE_ID, Item.class)
                .setParameter("id", id)
                .uniqueResult();
        session.close();
        return item;
    }

    @Override
    public void close() {
        sf.close();
    }
}
