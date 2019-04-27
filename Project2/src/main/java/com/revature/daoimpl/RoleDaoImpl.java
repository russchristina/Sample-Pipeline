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

import com.revature.beans.Role;
import com.revature.dao.RoleDao;
import com.revature.util.ConnectionFactory;

public class RoleDaoImpl implements RoleDao{

	@Override
	public List<Role> getAllRoles() {
		List<Role> roles = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			Query<Role> q = s.createQuery("FROM Role", Role.class);
			roles = q.getResultList();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		return roles;
	}

	@Override
	public Role getRoleById(int id) {
		Role r = null;
		Session s = null;
		
		try {
			s = ConnectionFactory.getSession();
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Role> cq = cb.createQuery(Role.class);
			Root<Role> root = cq.from(Role.class);
			cq.select(root).where(cb.equal(root.get("id"), id));
			Query<Role> q = s.createQuery(cq);
			r = q.getSingleResult();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return r;
	}

	@Override
	public void insertRole(Role r) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.save(r);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
	}

	@Override
	public void updateRole(Role r) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.merge(r);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
	}

	@Override
	public void deleteRole(Role r) {
		Session s = null;
		Transaction t = null;
		
		try {
			s = ConnectionFactory.getSession();
			t = s.beginTransaction();
			s.delete(r);
			t.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			s.close();
		}
		
	}

}
