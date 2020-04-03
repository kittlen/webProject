package com.qyc.SSHdemo.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateDaoImpl<T> implements BaseDao<T> {

	private SessionFactory sessionFactory;
	
	@Override
	public Serializable save(T object) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().save(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getObj(Class<T> cla, Serializable id) {
		// TODO Auto-generated method stub
		return (T) sessionFactory.getCurrentSession().get(cla, id);
	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(object);

	}

	@Override
	public void delete(Class<T> cla, Serializable id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getObj(cla, id));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> select(String HQL) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(HQL);
		return (List<T>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> select(String HQL, Object[] parmas) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(HQL);
		for(int i=0;i<parmas.length;i++){
			query.setParameter(i, parmas[i]);
		}
		return (List<T>)query.list();
	}

	@Override
	public Object seleceValue(String HQL) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(HQL);
		return query.uniqueResult();
	}

	@Override
	public Object seleceValue(String HQL, Object[] parmas) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(HQL);
		for(int i=0;i<parmas.length;i++){
			query.setParameter(i, parmas[i]);
		}
		return query.uniqueResult();
	}

	@Override
	public Long getPageCount(String HQL, int perCount) {
		// TODO Auto-generated method stub
		String SHQL = "select count(*) " + HQL;
		Object oCount = seleceValue(SHQL);
		long lCount = (Long) oCount;
		long pageCount = 0;
		if (lCount % perCount == 0) {
			pageCount = lCount / perCount;
		} else {
			pageCount = lCount / perCount + 1;
		}
		return pageCount;
	}

	@Override
	public Long getPageCount(String HQL, Object[] parmas, int perCount) {
		// TODO Auto-generated method stub
		String SHQL = "select count(*) " + HQL;
		Object oCount = seleceValue(SHQL, parmas);
		long lCount = (Long) oCount;
		long pageCount = 0;
		if (lCount % perCount == 0) {
			pageCount = lCount / perCount;
		} else {
			pageCount = lCount / perCount + 1;
		}
		return pageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectPage(String HQL, int perCount, int index) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(HQL);
		query.setFirstResult((index - 1) * perCount);
		query.setMaxResults(perCount);
		return (List<T>)query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectPage(String HQL, Object[] parmas, int perCount,
			int index) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(HQL);
		query.setFirstResult((index - 1) * perCount);
		query.setMaxResults(perCount);
		for (int i = 0; i < parmas.length; i++) {
			query.setParameter(i, parmas[i]);
		}
		return (List<T>)query.list();
	}

	/*******************Seter/Geter*****************************/
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
