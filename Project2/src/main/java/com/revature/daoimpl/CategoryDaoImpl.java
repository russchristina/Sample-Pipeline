package com.revature.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.sql.Connection;
import java.util.ArrayList;
import com.revature.dao.CategoryDao;
import com.revature.util.ConnectionFactory;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Category;

public class CategoryDaoImpl implements CategoryDao {

    public List<Category> getAllCategories(){
        List<Category> categories = null;
        Session s = null;

        try{
            s = ConnectionFactory.getSession();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
            Root<Category> r = cq.from(Category.class);
            cq.select(r);
            Query<Category> q = s.createQuery(cq);
            categories = q.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally{
            s.close();
        }
        return categories;
    }

    public Category getCategoryById(int id){
        Session s = null;
        Category c = new Category();

        try{
            s = ConnectionFactory.getSession();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
            Root<Category> r = cq.from(Category.class);
            cq.select(r).where(cb.equal(r.get("id"), id));
            Query<Category> q = s.createQuery(cq);
            c = q.uniqueResult();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally{
            s.close();
        }
        return c;
    }

    public void insertCategory(Category c){
        Session s = null;
        Transaction t = null;

        try {
            s = ConnectionFactory.getSession();
            t = s.beginTransaction();
            s.save(c);
            t.commit();
        } catch(HibernateException e){
            e.printStackTrace();
            t.rollback();
        } finally{
            s.close();
        }
    }

    public void updateCategory(Category c){
        Session s = null;
        Transaction t = null;

        try{
            s = ConnectionFactory.getSession();
            t = s.beginTransaction();
            s.merge(c);
            t.commit();
        } catch(HibernateException e){
            e.printStackTrace();
            t.rollback();
        } finally{
            s.close();
        }
    }

    public void deleteCategory(Category c){
        Session s = null;
        Transaction t = null;

        try{
            s = ConnectionFactory.getSession();
            t = s.beginTransaction();
            s.delete(c);
            t.commit();
        } catch(HibernateException e){
            e.printStackTrace();
            t.rollback();
        } finally{
            s.close();
        }
    }

}