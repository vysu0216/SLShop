package com.shop.solution.store.model.DAOImpl;

import com.shop.solution.store.model.DAO.ProductDAO;
import com.shop.solution.store.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addProduct(Product product) {
        sessionFactory.openSession();
        getCurrentSession().save(product);
    }

    public Product getProductById(long id) {
        return (Product) getCurrentSession().get(Product.class, id);
    }

    public void saveProduct(Product product) {
        getCurrentSession().update(product);
    }
}
