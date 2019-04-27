package com.revature.dao;

import java.util.List;
import com.revature.beans.Category;

public interface CategoryDao {
    public List<Category> getAllCategories();
    public Category getCategoryById(int id);
    public void insertCategory(Category c);
    public void updateCategory(Category c);
    public void deleteCategory(Category c);
}