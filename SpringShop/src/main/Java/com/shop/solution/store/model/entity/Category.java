package com.shop.solution.store.model.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema="public", name = "CATEGORY")
public class Category implements Serializable {
    private Long categoryId;
    private Category parentCategory;
    private Boolean isTopLevel;
    private String name;
    private Set<Product> products = new HashSet<Product>();
    private List<Category> subCategories;

    public Category() {
    }

    @Id
    @Column(name = "CATEGORY_ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq_gen")
    @SequenceGenerator(name="cat_seq_gen", sequenceName="PRODUCT_SEQUENCE", allocationSize=1)
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(String name){
        this.name = name;
    }

    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Column(name = "IS_TOP_LEVEL")
    public Boolean getIsTopLevel() {
        return isTopLevel;
    }

    public void setIsTopLevel(Boolean isTopLevel) {
        this.isTopLevel = isTopLevel;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category", fetch=FetchType.EAGER)
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProductToCategory(Product product){
        product.setCategory(this);
        this.products.add(product);
    }

}
