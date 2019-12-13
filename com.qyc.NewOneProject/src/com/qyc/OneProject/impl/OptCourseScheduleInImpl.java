package com.qyc.OneProject.impl;

import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.CourseSchedule;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.VOptCourseSchedule;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.OptCourseScheduleInterface;
import com.qyc.OneProject.util.util;

public class OptCourseScheduleInImpl implements OptCourseScheduleInterface {
	iHibernatedao hb = new Hibernatedao();

	/**
	 * 获取本学期学生所选课内容
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<VOptCourseSchedule> select(Student student) {
		// TODO Auto-generated method stub
		List<VOptCourseSchedule> list = new ArrayList<VOptCourseSchedule>();
		String HQL = "from VOptCourseSchedule vop where vop.Stu_ID=? and vop.Curricula=?";
		Object[] parmas = { student.getStu_ID(), util.getNewSemester() };
		list = hb.select(HQL, parmas);
		return list;
	}

	@Override
	public boolean delete(VOptCourseSchedule VOCS) {
		// TODO Auto-generated method stub
		int pd = hb.delete(CourseSchedule.class, VOCS.getCourseScheduleID());
		if (pd == 1) {
			return true;
		}
		return false;
	}

	// 教师成绩录入
	@SuppressWarnings("unchecked")
	@Override
	public List<VOptCourseSchedule> Tselect(VOptCourseSchedule vOpC) {
		// TODO Auto-generated method stub
		String HQL = "from VOptCourseSchedule vOCS where vOCS.TeacherID=? and vOCS.CourseID=?";
		Object[] parmas = { vOpC.getTeacherID(), vOpC.getCourseID() };
		List<VOptCourseSchedule> list = hb.select(HQL, parmas);
		return list;
	}

	// 学生课程表&成绩查询
	@SuppressWarnings("unchecked")
	@Override
	public List<VOptCourseSchedule> TSselect(Student student) {
		// TODO Auto-generated method stub
		String HQL = "from VOptCourseSchedule vOCS where vOCS.Stu_ID=? and vOCS.Curricula=?";
		Object[] parmas = { student.getStu_ID(), util.getNewSemester() };
		List<VOptCourseSchedule> list = hb.select(HQL, parmas);
		return list;
	}

}
