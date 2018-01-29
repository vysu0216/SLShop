package com.shop.solution.store.model.DAO;

import com.shop.solution.store.model.entity.Product;

public interface ProductDAO {

    void addProduct(Product product);

    Product getProductById(long id);

    void saveProduct(Product product);
}