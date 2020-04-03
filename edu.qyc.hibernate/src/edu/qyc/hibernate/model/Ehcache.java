package edu.qyc.hibernate.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Ehcache {
	public static void main(String[] args) {
		
		try {
			Session session=HibernateSessionFactory.getSession();
			Session session2=HibernateSessionFactory.getSession();
			Transaction ts=session.beginTransaction();
			Admin admin=(Admin)session.get(Admin.class, "5");
			System.out.println("第一次装载对象");
			Admin admin2=(Admin)session2.get(Admin.class, "5");
			System.out.println("第二次装载对象");
			/*session.save(admin);
			session.flush();
			ts.commit();*/
		} catch (Exception e) {
			// TODO: handle exception
			/*ts.rollback();*/
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}

}
