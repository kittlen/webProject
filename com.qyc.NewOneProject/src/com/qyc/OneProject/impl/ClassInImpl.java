package com.qyc.OneProject.impl;


import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Class;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.ClassInterface;

public class ClassInImpl implements ClassInterface{

	iHibernatedao hb=new Hibernatedao();
	
	@Override
	public boolean insert(Class cla) {
		// TODO Auto-generated method stub
		String pd=(String) hb.save(cla);
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Class cla) {
		// TODO Auto-generated method stub
		int pd=hb.update(cla);
		if(pd==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Class cla) {
		// TODO Auto-generated method stub
		int pd= hb.delete(cla);
		if(pd==1){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Class> select(String ProfessionID) {
		// TODO Auto-generated method stub
		List<Class> list=new ArrayList<Class>();
		String HQL="from Class cla where cla.profession.ProfessionID=?";
		Object [] parmas={ProfessionID};
		list=hb.select(HQL,parmas);
		return list;
	}

}
