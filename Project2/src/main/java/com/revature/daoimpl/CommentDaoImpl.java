package com.revature.daoimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Comment;
import com.revature.beans.Joke;
import com.revature.beans.User;
import com.revature.dao.CommentDao;
import com.revature.util.ConnectionFactory;

public class CommentDaoImpl implements CommentDao {

    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = null;
        Session s = null;

        try {
            s = ConnectionFactory.getSession();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
            Root<Comment> r = cq.from(Comment.class);
            cq.select(r);
            Query<Comment> q = s.createQuery(cq);
            comments = q.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally{
            s.close();
        }
        return comments;
    }

    @Override
    public Comment getCommentById(int id) {
        Comment c = null;
        Session s = null;

        try{
            s = ConnectionFactory.getSession();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
            Root<Comment> r = cq.from(Comment.class);
            cq.select(r).where(cb.equal(r.get("id"), id));
            Query<Comment> q = s.createQuery(cq);
            c = q.uniqueResult();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally{
            s.close();
        }
        return c;
    }

    @Override
    public List<Comment> getCommentsByJoke(Joke j) {
        List<Comment> comments = null;
        Session s = null;

        try{
            s = ConnectionFactory.getSession();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
            Root<Comment> r = cq.from(Comment.class);
            cq.select(r).where(cb.equal(r.get("jokeId"), j.getId()));
            Query<Comment> q = s.createQuery(cq);
            comments = q.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally{
            s.close();
        }
        return comments;
    }

    @Override
    public List<Comment> getCommentsByUser(User u) {
        List<Comment> comments = null;
        Session s = null;

        try{
            s = ConnectionFactory.getSession();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
            Root<Comment> r = cq.from(Comment.class);
            cq.select(r).where(cb.equal(r.get("userId"), u.getId()));
            Query<Comment> q = s.createQuery(cq);
            comments = q.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally{
            s.close();
        }

        return comments;
    }

    @Override
    public List<Comment> getCommentsByDate(Date d) {
        List<Comment> comments = null;
        Session s = null;

        try{
            s = ConnectionFactory.getSession();
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Comment> cq = cb.createQuery(Comment.class);
            Root<Comment> r = cq.from(Comment.class);
            cq.select(r).where(cb.equal(r.get("date"), d));
            Query<Comment> q = s.createQuery(cq);
            comments = q.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally{
            s.close();
        }

        return comments;
    }

    @Override
    public void insertComment(Comment c) {
        Session s = null;
        Transaction t = null;

        try{
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

    @Override
    public void updateComment(Comment c) {
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

    @Override
    public void deleteComment(Comment c) {
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