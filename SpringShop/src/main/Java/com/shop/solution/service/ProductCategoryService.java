package com.shop.solution.service;

import com.shop.solution.store.model.entity.Category;

import java.util.List;

public interface ProductCategoryService {

    void saveProductCategory(String name, Category parentCat, Boolean isTopLevelCat);

    Category getProductCategoryById(Long id);

    Category getProductCategoriesByName(String name);

    List<Category> getAllCategoriesAsList();

    List<Category> getRootCategoriesAsList();
}
