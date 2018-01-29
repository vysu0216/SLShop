package com.shop.solution.controller;

import com.shop.solution.service.CategoryService;
import com.shop.solution.service.ProductCategoryService;
import com.shop.solution.store.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    ProductCategoryService productCategoryService;
    CategoryService categoryService;

    @ModelAttribute
    public void addCategoriesToModel(Map<String, Object> model) {
        model.put("categories", productCategoryService.getAllCategoriesAsList());
        model.put("category", new Category());
    }

    @Autowired
    public CategoryController(ProductCategoryService productCategoryService, CategoryService categoryService) {
        this.productCategoryService = productCategoryService;
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showCategories(Map<String, Object> model) {
        return "testpage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@RequestParam("set_parent") String parent,
                         @ModelAttribute("category") Category category,
                         BindingResult result, Model model) {
        System.out.println(parent);
        if (!parent.equals("")) {
            category.setIsTopLevel(false);
            Category parentCategory = categoryService.getCategoryById(new Long(parent));
            category.setParentCategory(parentCategory);
        } else category.setIsTopLevel(true);
        categoryService.addNewCategory(category);
        return "redirect:/categories";
    }

}
