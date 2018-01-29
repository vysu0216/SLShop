package com.shop.solution.store.model.DAOImpl;

import com.shop.solution.store.model.DAO.CategoryDAO;
import com.shop.solution.store.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CategoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addCategory(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(category);
        transaction.commit();
    }

    public Category getCategoryById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Category category = (Category) session.get(Category.class, id);
        transaction.commit();
        return category;
    }

    public List<Category> getAllCategories(){
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Category> allCategories = session.createQuery("from Category").list();
        transaction.commit();
        return allCategories;
    }

    public List<Category> getRootCategories() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Category> cats = session.createQuery("from Category as cat where cat.isTopLevel = true").list();
        transaction.commit();
        return cats;
    }

    public Category getCategory(Category category) {
        return (Category) getCurrentSession().get(Category.class,category);
    }

    public void saveCategory(Category category) {
        getCurrentSession().update(category);
    }
}