package com.qyc.OneProject.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.Model.Audit;
import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.VTeachTask;
import com.qyc.OneProject.basedao.HibernateSessionFactory;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.AuditInterface;
import com.qyc.OneProject.util.util;

public class AuditImpl implements AuditInterface {
	iHibernatedao hb=new Hibernatedao();

	//π‹¿Ì‘±…Û∫À
	@Override
	public boolean update(TeachTask teachTask,Admin admin) {
		// TODO Auto-generated method stub
		TeachTask thisTask=(TeachTask) hb.getObj(TeachTask.class, teachTask.getID());
		thisTask.setAuditing(teachTask.getAuditing());
		Audit audit=new Audit();
		audit.setAdmin(admin);
		audit.setAuditDate(util.getNowDetailedTime());
		audit.setTeachTask(thisTask);
		audit.setRemark("");
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.update(thisTask);
			session.save(audit);
			session.flush();
			ts.commit();
			HibernateSessionFactory.closeSession();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			ts.rollback();
			HibernateSessionFactory.closeSession();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VTeachTask> select(TeachTask teachTask) {
		String HQL="from VTeachTask vt where Curricula=?";
		Object[] parmas = { teachTask.getCurricula() };
		List<VTeachTask> list = hb.select(HQL, parmas);
		return list;
	}

}
