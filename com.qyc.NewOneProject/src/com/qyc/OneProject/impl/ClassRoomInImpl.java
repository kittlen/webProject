package com.qyc.OneProject.impl;

import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.ClassRoom;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.ClassRoomInterface;

public class ClassRoomInImpl implements ClassRoomInterface {
	iHibernatedao hb=new Hibernatedao();

	
	@Override
	public boolean insert(ClassRoom claRo) {
		// TODO Auto-generated method stub
		String pd=(String) hb.save(claRo);
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(ClassRoom claRo) {
		// TODO Auto-generated method stub
		int pd=hb.update(claRo);
		if(pd==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(ClassRoom claRo) {
		// TODO Auto-generated method stub
		int pd= hb.delete(claRo);
		if(pd==1){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassRoom> select() {
		// TODO Auto-generated method stub
		String HQL="from ClassRoom cr order by cr.ClassRoomCategory asc";
		List<ClassRoom> list=hb.select(HQL);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClassRoom> Nameselect(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		String HQL="from ClassRoom  cr where cr.ClassRoomCategory=?";
		List<ClassRoom> list=new ArrayList<ClassRoom>();
		Object[] parmas={classRoom.getClassRoomCategory()};
		list=hb.select(HQL, parmas);
		return list;
	}

}
