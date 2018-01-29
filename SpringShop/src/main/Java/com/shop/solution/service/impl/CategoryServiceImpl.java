package com.shop.solution.service.impl;

import com.shop.solution.service.CategoryService;
import com.shop.solution.store.model.DAO.CategoryDAO;
import com.shop.solution.store.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;

    public void addNewCategory(Category category) {
        categoryDAO.addCategory(category);
    }
    public Category getCategoryById(Long id){
        return categoryDAO.getCategoryById(id);
    }
}
