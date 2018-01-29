package com.shop.solution;

import com.shop.solution.store.model.DAOImpl.CategoryDAOImpl;
import com.shop.solution.store.model.entity.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}
