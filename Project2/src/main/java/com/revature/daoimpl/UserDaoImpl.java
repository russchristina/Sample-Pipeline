package com.revature.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Role;
import com.revature.beans.User;
import com.revature.dao.UserDao;
import com.revature.util.ConnectionFactory;

public class UserDaoImpl implements UserDao{

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			Query<User> q = s.createQuery("FROM User", User.class);
			users = q.getResultList();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return users;
	}

	@Override
	public User getUserById(int id) {
		User u = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("id"), id));
			Query<User> q = s.createQuery(cq);
			u = q.getSingleResult();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}
	
	@Override
	public User getUserByUsername(String username) {
		User u = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("username"), username));
			Query<User> q = s.createQuery(cq);
			u = q.getSingleResult();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return u;
	}

	@Override
	public List<User> getUsersByRole(Role r) {
		List<User> users = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			cq.select(root).where(cb.equal(root.get("id"), r.getId()));
			Query<User> q = s.createQuery(cq);
			users = q.getResultList();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return users;
	}

	@Override
	public void insertUser(User u) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.save(u);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public void updateUser(User u) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.merge(u);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public void deleteUser(User u) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.delete(u);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
	}

}
