package com.qyc.OneProject.impl;

import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Profession;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.ProfessionInterface;

public class ProfessionInImpl implements ProfessionInterface {

	iHibernatedao hb=new Hibernatedao();
	
	@Override
	public boolean insert(Profession pro) {
		// TODO Auto-generated method stub
		String pd=(String) hb.save(pro);
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Profession pro) {
		// TODO Auto-generated method stub
		int pd=hb.update(pro);
		if(pd==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Profession pro) {
		// TODO Auto-generated method stub
		int pd= hb.delete(pro);
		if(pd==1){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profession> select(String DepartmentID) {
		// TODO Auto-generated method stub
		List<Profession> list=new ArrayList<Profession>();
		String HQL="from Profession pro where pro.department.DepartmentID=?";
		Object [] parmas={DepartmentID};
		list=hb.select(HQL,parmas);
		return list;
	}

}
