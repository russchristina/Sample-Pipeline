package com.revature.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Category;
import com.revature.beans.Joke;
import com.revature.beans.Status;
import com.revature.beans.User;
import com.revature.dao.JokeDao;
import com.revature.util.ConnectionFactory;

public class JokeDaoImpl implements JokeDao{

	@Override
	public List<Joke> getAllJokes() {
		List<Joke> jokes = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Joke> cq = cb.createQuery(Joke.class);
			Root<Joke> r = cq.from(Joke.class);
			cq.select(r);
			Query<Joke> q = s.createQuery(cq);
			jokes = q.getResultList();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return jokes;
	}

	@Override
	public Joke getJokeById(int id) {
		Joke j = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Joke> cq = cb.createQuery(Joke.class);
			Root<Joke> r = cq.from(Joke.class);
			cq.select(r).where(cb.equal(r.get("id"), id));
			Query<Joke> q = s.createQuery(cq);
			j = q.getSingleResult();
			
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return j;
	}

	@Override
	public List<Joke> getJokesByCategory(Category c) {
		List<Joke> jokes = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Joke> cq = cb.createQuery(Joke.class);
			Root<Joke> r = cq.from(Joke.class);
			cq.select(r).where(cb.equal(r.get("category"), c.getId()));
			Query<Joke> q = s.createQuery(cq);
			jokes = q.getResultList();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return jokes;
	}

	@Override
	public List<Joke> getJokesByUser(User u) {
		List<Joke> jokes = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Joke> cq = cb.createQuery(Joke.class);
			Root<Joke> r = cq.from(Joke.class);
			cq.select(r).where(cb.equal(r.get("user"), u.getId()));
			Query<Joke> q = s.createQuery(cq);
			jokes = q.getResultList();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return jokes;
	}

	@Override
	public List<Joke> getJokesByStatus(Status s) {
		List<Joke> jokes = null;
		Session session = null;
		
		try {
			session = ConnectionFactory.getSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Joke> cq = cb.createQuery(Joke.class);
			Root<Joke> r = cq.from(Joke.class);
			cq.select(r).where(cb.equal(r.get("status"), s.getId()));
			Query<Joke> q = session.createQuery(cq);
			jokes = q.getResultList();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return jokes;
	}

	@Override
	public void insertJoke(Joke j) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.save(j);
			t.commit();
			
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public void updateJoke(Joke j) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.merge(j);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public void deleteJoke(Joke j) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.delete(j);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
	}

}
