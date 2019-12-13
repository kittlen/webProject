package com.qyc.OneProject.impl;

import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.College;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.CollegeInterface;

public class CollegeInImpl implements CollegeInterface{
	iHibernatedao hb=new Hibernatedao();

	@Override
	public boolean insert(College coll) {
		// TODO Auto-generated method stub
		String pd=(String) hb.save(coll);
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(College coll) {
		// TODO Auto-generated method stub
		int pd=hb.update(coll);
		if(pd==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(College coll) {
		// TODO Auto-generated method stub
		int pd= hb.delete(coll);
		if(pd==1){
			return true;
		}
		return false;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<College> select() {
		// TODO Auto-generated method stub
		List<College> list=new ArrayList<College>();
		String HQL="from College coll";
		list=hb.select(HQL);
		return list;
	}

}
