package com.revature.service;

import com.revature.beans.Category;
import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public Category getCategoryById(int id);
    public void insertCategory(Category c);
    public void updateCategory(Category c);
    public void deleteCategory(Category c);
}