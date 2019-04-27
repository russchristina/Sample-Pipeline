package com.revature.serviceimpl;

import java.util.List;

import com.revature.beans.Category;
import com.revature.daoimpl.CategoryDaoImpl;
import com.revature.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> getAllCategories() {
        return new CategoryDaoImpl().getAllCategories();
    }

    @Override
    public Category getCategoryById(int id) {
        return new CategoryDaoImpl().getCategoryById(id);
    }

    @Override
    public void insertCategory(Category c) {
        new CategoryDaoImpl().insertCategory(c);
    }

    @Override
    public void updateCategory(Category c) {
        new CategoryDaoImpl().updateCategory(c);
    }

    @Override
    public void deleteCategory(Category c) {
        new CategoryDaoImpl().deleteCategory(c);
    }

}