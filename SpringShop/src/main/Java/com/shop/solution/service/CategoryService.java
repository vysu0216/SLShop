package com.shop.solution.service;

import com.shop.solution.store.model.entity.Category;

public interface CategoryService {

    void addNewCategory(Category category);

    Category getCategoryById(Long id);

}
