package com.revature.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Status;
import com.revature.dao.StatusDao;
import com.revature.util.ConnectionFactory;

public class StatusDaoImpl implements StatusDao{

	@Override
	public List<Status> getAllStatuses() {
		List<Status> stati = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			Query<Status> q = s.createQuery("FROM Status", Status.class);
			stati = q.getResultList();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return stati;
	}

	@Override
	public Status getStatusById(int id) {
		Status stat = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Status> cq = cb.createQuery(Status.class);
			Root<Status> r = cq.from(Status.class);
			cq.select(r).where(cb.equal(r.get("id"), id));
			Query<Status> q = s.createQuery(cq);
			stat = q.getSingleResult();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return stat;
	}

	@Override
	public void insertStatus(Status s) {
		Session session = null;
		Transaction t = null;
		
		try {
			session = ConnectionFactory.getSession();
			t = session.beginTransaction();
			session.save(s);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateStatus(Status s) {
		Session session = null;
		Transaction t = null;
		
		try {
			session = ConnectionFactory.getSession();
			t = session.beginTransaction();
			session.merge(s);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteStatus(Status s) {
		Session session = null;
		Transaction t = null;
		
		try {
			session = ConnectionFactory.getSession();
			t = session.beginTransaction();
			session.delete(s);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			session.close();
		}
	}

}
