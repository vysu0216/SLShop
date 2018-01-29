package com.shop.solution.store.model.DAO;

import com.shop.solution.store.model.entity.Category;

import java.util.List;

public interface CategoryDAO {

    void addCategory(Category category);

    Category getCategoryById(Long id);

    void saveCategory(Category category);

    List<Category> getAllCategories();

    List<Category> getRootCategories();

}
