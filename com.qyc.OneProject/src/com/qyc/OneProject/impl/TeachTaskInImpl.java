package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.VTeachTask;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.TeachTaskInterface;

public class TeachTaskInImpl implements TeachTaskInterface {

	@Override
	public boolean insert(TeachTask task) {
		// TODO Auto-generated method stub
		String SQL="insert into T_TeachTask (TeacherID,CourseID,Curricula,Auditing) values (?,?,?,?)";
		Object[] parmas={task.getTeacher().getTeacherID(),task.getCourse().getCourseID(),task.getCurricula(),task.getAuditing()};
		BaseDAO baseDAO=new BaseDAO();
		int count=baseDAO.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(TeachTask task) {
		// TODO Auto-generated method stub
		String SQL="delete from T_TeachTask where TeacherID=? and CourseID=?";
		Object [] parmas={task.getTeacher().getTeacherID(),task.getCourse().getCourseID()};
		BaseDAO baseDAO=new BaseDAO();
		int count=baseDAO.delete(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public List<VTeachTask> select(String Curricula,String TeacherID){
		String SQL="select * from V_teachTask where Curricula like ? and TeacherID=?";
		Object[] parmas={Curricula,TeacherID};
		ResultSet rs=new BaseDAO().select(SQL,parmas);
		List<VTeachTask> list=new ArrayList<VTeachTask>();
		try {
			while (rs.next()) {
				VTeachTask vt=new VTeachTask();
				vt.setCourse(rs.getString("Course"));
				vt.setProfessionName(rs.getString("ProfessionName"));
				vt.setStudyTime(rs.getInt("StudyTime"));
				vt.setCrediy(rs.getDouble("Crediy"));
				vt.setCurriculumTime(rs.getString("CurriculumTime"));
				vt.setName(rs.getString("Name"));
				vt.setCurricula(rs.getString("Curricula"));
				vt.setAuditing(rs.getString("Auditing"));
				vt.setTeacherID(rs.getString("TeacherID"));
				vt.setProfessionID(rs.getString("ProfessionID"));
				vt.setCourseID(rs.getString("CourseID"));
				vt.setTeachTaskID(rs.getInt("ID"));
				vt.setRemark(rs.getString("Remark"));
				list.add(vt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<VTeachTask> ArrangeSelect(String Curricula, String TeacherID) {
		// TODO Auto-generated method stub
		String SQL="select * from V_teachTask where Curricula =? and TeacherID=? and Auditing='ÉóºËÍ¨¹ý'";
		Object[] parmas={Curricula,TeacherID};
		ResultSet rs=new BaseDAO().select(SQL,parmas);
		List<VTeachTask> list=new ArrayList<VTeachTask>();
		try {
			while (rs.next()) {
				VTeachTask vt=new VTeachTask();
				vt.setCourse(rs.getString("Course"));
				vt.setProfessionName(rs.getString("ProfessionName"));
				vt.setStudyTime(rs.getInt("StudyTime"));
				vt.setCrediy(rs.getDouble("Crediy"));
				vt.setCurriculumTime(rs.getString("CurriculumTime"));
				vt.setName(rs.getString("Name"));
				vt.setCurricula(rs.getString("Curricula"));
				vt.setAuditing(rs.getString("Auditing"));
				vt.setTeacherID(rs.getString("TeacherID"));
				vt.setProfessionID(rs.getString("ProfessionID"));
				vt.setCourseID(rs.getString("CourseID"));
				vt.setTeachTaskID(rs.getInt("ID"));
				vt.setRemark(rs.getString("Remark"));
				list.add(vt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
