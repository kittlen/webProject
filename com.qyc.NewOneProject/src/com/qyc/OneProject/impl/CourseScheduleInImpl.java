package com.qyc.OneProject.impl;


import java.util.List;

import com.qyc.OneProject.Model.CourseSchedule;
import com.qyc.OneProject.Model.Schedule;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.Model.VCourseSchedule;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.CourseScheduleInterface;
import com.qyc.OneProject.util.util;

public class CourseScheduleInImpl implements CourseScheduleInterface {
	iHibernatedao hb=new Hibernatedao();

	// ѧ��ѡ��
	@SuppressWarnings("unchecked")
	@Override
	public List<VCourseSchedule> select(VCourseSchedule vCS) {
		String HQL="from VCourseSchedule vCS where vCS.ProfessionID=? and vCS.Curricula=? order by vCS.Course asc,Name asc,ClassRoomName asc";
		Object[] parmas={vCS.getProfessionID(),vCS.getCurricula()};
		List<VCourseSchedule> list = hb.select(HQL, parmas);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean insert(VCourseSchedule vCS,Student student){
		String HQL="from CourseSchedule cs where cs.student.Stu_ID=? and cs.schedule.ID=?";
		Object [] parmas={student.getStu_ID(),vCS.getScheduleID()};
		List<CourseSchedule> list=hb.select(HQL, parmas);
		if(list.size()==0){
			Schedule schedule=new Schedule();
			schedule.setID(vCS.getScheduleID());
			CourseSchedule cSchedule=new CourseSchedule();
			cSchedule.setSchedule(schedule);
			cSchedule.setStudent(student);
			hb.save(cSchedule);
			return true;
		}
		return false;
	}


	//ѧ��ѧ���޸�
	@Override
	public boolean update(CourseSchedule cSchedule) {
		// TODO Auto-generated method stub
		CourseSchedule thisCS=(CourseSchedule) hb.getObj(CourseSchedule.class, cSchedule.getID());
		thisCS.setScoreOne(cSchedule.getScoreOne());
		thisCS.setScoreTwo(cSchedule.getScoreTwo());
		thisCS.setScoreThree(cSchedule.getScoreThree());
		thisCS.setTotalScore(cSchedule.getScoreOne()+cSchedule.getScoreTwo()+cSchedule.getScoreThree());
		if(hb.update(thisCS)==1){
			return true;
		}
		return false;
	}

	//��Ӧ��ʦ���Ѿ�������ɵĿγ�
	@SuppressWarnings("unchecked")
	@Override
	public List<VCourseSchedule> Tselect(VCourseSchedule vCS) {
		// TODO Auto-generated method stub
		String HQL="from VCourseSchedule vcs where vcs.TeacherID=? and vcs.CourseID=?";
		Object[] parmas={vCS.getTeacherID(),vCS.getCourseID()};
		List<VCourseSchedule> list=hb.select(HQL, parmas);
		return list;
	}

	

	//��ʦ�γ̱�
	@SuppressWarnings("unchecked")
	@Override
	public List<VCourseSchedule> TTselect(Teacher teacher) {
		// TODO Auto-generated method stub
		String HQL="from VCourseSchedule vCS where vCS.TeacherID=? and vCS.Curricula=?";
		Object[] parmas={teacher.getTeacherID(),util.getNewSemester()};
		List<VCourseSchedule> list=hb.select(HQL, parmas);
		return list;
	}

}
