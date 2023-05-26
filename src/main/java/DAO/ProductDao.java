package DAO;

import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao {
    public void save(Product product) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    public List<Product> getAll() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        List<Product> products = session.createQuery("from Product ", Product.class).list();
        session.close();
        sessionFactory.close();
        return products;
    }

    public Product get(int id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Product Product = session.get(Product.class, id);
        session.close();
        sessionFactory.close();
        return Product;
    }

    public void update(Product Product) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(Product);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    public void delete(int id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product Product = session.get(Product.class, id);
        session.remove(Product);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
