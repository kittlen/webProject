package com.qyc.OneProject.impl;

import java.util.List;

import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.VTeachTask;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.TeachTaskInterface;

public class TeachTaskInImpl implements TeachTaskInterface {
	iHibernatedao hb=new Hibernatedao();

	@Override
	public boolean insert(TeachTask task) {
		// TODO Auto-generated method stub
		String pd=String.valueOf( hb.save(task));
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean delete(TeachTask task) {
		// TODO Auto-generated method stub
		String HQL="from TeachTask tt where tt.teacher.TeacherID=? and tt.course.CourseID=?";
		Object [] parmas={task.getTeacher().getTeacherID(),task.getCourse().getCourseID()};
		List<TeachTask> list=hb.select(HQL, parmas);
		TeachTask thisTask=null;
		for(int i=0;i<list.size();i++){
			thisTask=list.get(i);
		}
		int pd= hb.delete(thisTask);
		if(pd==1){
			return true;
		}
		return false;
	}
	
	//ø™øŒ≤È—Ø
	@SuppressWarnings("unchecked")
	@Override
	public List<VTeachTask> select(TeachTask teachtask){
		String HQL="from VTeachTask vt where vt.Curricula like ? and vt.TeacherID=?";
		Object [] parmas={teachtask.getCurricula(),teachtask.getTeacher().getTeacherID()};
		List<VTeachTask> list=hb.select(HQL, parmas);
		return list;
	}

	//øŒ±Ì≈‰÷√
	@SuppressWarnings("unchecked")
	@Override
	public List<VTeachTask> ArrangeSelect(TeachTask teachtask) {
		// TODO Auto-generated method stub
		String HQL="from VTeachTask vt where vt.Curricula=? and vt.TeacherID=? and vt.Auditing=?";
		Object [] parmas={teachtask.getCurricula(),teachtask.getTeacher().getTeacherID(),teachtask.getAuditing()};
		List<VTeachTask> list=hb.select(HQL, parmas);
		return list;
	}

}
