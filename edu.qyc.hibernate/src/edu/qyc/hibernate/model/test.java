package edu.qyc.hibernate.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Session session=HibernateSessionFactory.getSession();*/
		/*Admin admin=(Admin)session.get(Admin.class, "1");
		System.out.println(admin.getAdminName());*/
		/*Transaction ts=session.beginTransaction();*/
		/*Admin admin=new Admin();
		admin.setID("11223");
		admin.setAdminName("ÕÅÈý");
		admin.setPassword("123456");
		admin.setRemark("¸Ä");
		try {
			session.save(admin);
			session.update(admin);
			session.delete(admin);
			session.flush();
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			ts.rollback();
		}finally{
			HibernateSessionFactory.closeSession();
		}*/
		/*Query query=session.createQuery("from Admin where ID>10 and ID<10000");
		try {
			List<Admin> list=query.list();
			for(Admin admin2:list){
				System.out.println(admin2.getID());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			HibernateSessionFactory.closeSession();
		}*/
		String HQL="from Admin admin where admin.ID>?and admin.Password=?";
		Object[] object={"1","100","123456"};
		Query query=s(HQL, object);
		@SuppressWarnings("unchecked")
		List<Admin> list=query.list();
		for(Admin admin:list){
			System.out.println(admin.getID());
		}
		HibernateSessionFactory.closeSession();
		
	}
	
	public static Query s(String HQL,Object object[]){
		Session session=HibernateSessionFactory.getSession();
		Query query=session.createQuery(HQL);
		for(int i=0;i<object.length;i++){
			query.setParameter(i, object[i]);
		}
		return query;
		
	}

}
