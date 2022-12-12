package ru.job4j.tracker.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.Item;

public class HQLUsage {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            /* start working with session */
            Item item = findById(session, 9);
            System.out.println(item);
            /* finish working with session */
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Item findById(Session session, int id) {
        Query<Item> query = session.createQuery("from Item as i where i.id = :fId", Item.class);
        query.setParameter("fId", id);
        return query.uniqueResult();
    }

    public static void update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery("update Item set name = :fName where id = :fId")
                    .setParameter("fName", "new name")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void delete(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery("delete Item where id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
