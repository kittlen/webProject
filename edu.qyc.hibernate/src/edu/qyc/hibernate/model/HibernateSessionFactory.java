package edu.qyc.hibernate.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateSessionFactory {

	//���ڱ���ĳ���̹߳������(sessionԼ��)
	private static final ThreadLocal<Session> THREAD_LOCAL=new ThreadLocal<Session>();
	
	//SessionFactory����
	private static SessionFactory sessionFactory=null;
	
	//�����Ự����
	static {
		try {
			Configuration cfg=new Configuration().configure();//����Hibernate�����ļ�
			sessionFactory=cfg.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����Ự����ʧ��");
			e.printStackTrace();
		}
	};
	
	//��ȡSession
	public static Session getSession(){
		Session session=(Session)THREAD_LOCAL.get();//��ȡ��ǰ�̵߳ı���
		if(session==null||!session.isOpen()){//sessionΪ�ջ�ռ��
			if(sessionFactory==null){
				rebuildSessionFactory();
			}
			session=sessionFactory.openSession();//���¿���һ���̴߳���Session����Ҫ�ֶ��ر�Session
			THREAD_LOCAL.set(session);//Ϊsession����߳�Լ��
		}
		return session;
	}
	/**
	 * �ؽ��Ự����
	 */
	public static void rebuildSessionFactory(){
		try {
			Configuration cfg=new Configuration().configure();//����Hibernate�����ļ�
			sessionFactory=cfg.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����Ự����ʧ��");
			e.printStackTrace();
		}
	}
	
	//��ȡSessionFactory����
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//�ر�Session
	public static void closeSession(){
		Session session=(Session)THREAD_LOCAL.get();
		THREAD_LOCAL.set(null);
		if(session!=null){
			session.close();//�ر�session;
		}
	}
	
}
