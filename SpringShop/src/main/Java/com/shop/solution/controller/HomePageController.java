package com.shop.solution.controller;

import com.shop.solution.service.CategoryService;
import com.shop.solution.service.ProductCategoryService;
import com.shop.solution.store.model.DAOImpl.CategoryDAOImpl;
import com.shop.solution.store.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@Controller
public class HomePageController {

    ProductCategoryService productCategoryService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute
    public void addCategoriesToModel(Map<String, Object> model) {
        model.put("categories", productCategoryService.getAllCategoriesAsList());
        model.put("category",new Category());
    }

    @Autowired
    public HomePageController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @RequestMapping({"/","/home","/testpage"})
    public String showHomePage(Map<String, Object> model) {
        return "testpage";
    }

}
