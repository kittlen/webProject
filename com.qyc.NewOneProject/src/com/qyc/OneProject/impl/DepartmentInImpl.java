package com.qyc.OneProject.impl;

import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Department;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.DepartmentInterface;

public class DepartmentInImpl implements DepartmentInterface {
	
	iHibernatedao hb=new Hibernatedao();
	
	@Override
	public boolean insert(Department dep) {
		// TODO Auto-generated method stub
		String pd=(String) hb.save(dep);
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Department dep) {
		// TODO Auto-generated method stub
		int pd=hb.update(dep);
		if(pd==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Department dep) {
		// TODO Auto-generated method stub
		int pd= hb.delete(dep);
		if(pd==1){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> select(String CollegeID) {
		// TODO Auto-generated method stub
		List<Department> list=new ArrayList<Department>();
		String HQL="from Department dep where dep.college.CollegeID=?";
		Object [] parmas={CollegeID};
		list=hb.select(HQL,parmas);
		return list;
	}

	

}
