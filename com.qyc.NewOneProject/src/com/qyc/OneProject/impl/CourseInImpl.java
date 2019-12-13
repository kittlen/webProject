package com.qyc.OneProject.impl;

import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Course;
import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.CourseInterface;

public class CourseInImpl implements CourseInterface {

	iHibernatedao hb=new Hibernatedao();
	
	@Override
	public boolean insert(Course cou) {
		// TODO Auto-generated method stub
		String pd=String.valueOf( hb.save(cou));
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Course cou) {
		// TODO Auto-generated method stub
		int pd=hb.update(cou);
		if(pd==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Course cou) {
		// TODO Auto-generated method stub
		int pd= hb.delete(cou);
		if(pd==1){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> select(String ProfessionID) {
		// TODO Auto-generated method stub
		List<Course> list=new ArrayList<Course>();
		String HQL="from Course cou where cou.profession.ProfessionID=?";
		Object [] parmas={ProfessionID};
		list=hb.select(HQL,parmas);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> TCselect(Course course,String TeacherID) {
		// TODO Auto-generated method stub
		List<Course> list=new ArrayList<Course>();
		String HQL="from Course cou where cou.profession.ProfessionID=?";
		Object [] parmas={course.getProfession().getProfessionID()};
		list=hb.select(HQL,parmas);
		for (int i = 0; i < list.size(); i++) {
			String CourseID=list.get(i).getCourseID();
			list.get(i).setState(TeachTaskSelect(TeacherID, CourseID));
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public String  TeachTaskSelect(String TeacherID,String CourseID){
		String State="Î´¿ª¿Î";
		String HQL="from TeachTask tt where tt.teacher.TeacherID=? and tt.course.CourseID=?";
		Object[] parmas={TeacherID,CourseID};
		List<TeachTask> list=hb.select(HQL, parmas);
		for(int i=0;i<list.size();i++){
			State="ÒÑ¿ª¿Î";
		}
		return State;
	}
}
