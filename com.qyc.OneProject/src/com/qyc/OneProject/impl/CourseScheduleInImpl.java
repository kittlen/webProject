package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.CourseSchedule;
import com.qyc.OneProject.Model.VCourseSchedule;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.CourseScheduleInterface;
import com.qyc.OneProject.util.util;

public class CourseScheduleInImpl implements CourseScheduleInterface {

	// 学生选课
	@Override
	public List<VCourseSchedule> select(String ProfessionID) {
		String SQL = "select * from V_CourseSchedule where ProfessionID=? and Curricula=?";
		Object[] parmas = { ProfessionID, util.getNewSemester() };
		ResultSet rs = new BaseDAO().select(SQL, parmas);
		List<VCourseSchedule> list = new ArrayList<VCourseSchedule>();
		try {
			while (rs.next()) {
				VCourseSchedule vc = new VCourseSchedule();
				vc.setCourse(rs.getString("Course"));
				vc.setName(rs.getString("Name"));
				vc.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				vc.setClassRoomName(rs.getString("ClassRoomName"));
				vc.setProfessionName(rs.getString("ProfessionName"));
				vc.setClassfestival(rs.getString("Classfestival"));
				vc.setClassTime(rs.getString("ClassTime"));
				vc.setStudyTime(rs.getInt("StudyTime"));
				vc.setCrediy(rs.getDouble("Crediy"));
				vc.setCurriculumTime(rs.getString("CurriculumTime"));
				vc.setCurricula(rs.getString("Curricula"));
				vc.setTeacherID(rs.getString("TeacherID"));
				vc.setTeachTaskID(rs.getInt("TeachTaskID"));
				vc.setClassRoomID(rs.getString("ClassRoomID"));
				vc.setScheduleID(Integer.parseInt(rs.getString("ScheduleID")));
				vc.setCourseID(rs.getString("CourseID"));
				vc.setProfessionID(rs.getString("ProfessionID"));
				vc.setRemark(rs.getString("Remark"));
				list.add(vc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insert(CourseSchedule courseSchedule) {
		// TODO Auto-generated method stub
		String SQL = "insert into T_CourseSchedule (Stu_ID,ScheduleID) values (?,?)";
		Object[] parmas = { courseSchedule.getStudent().getStu_ID(),
				courseSchedule.getSchedule().getID() };
		int count = new BaseDAO().insert(SQL, parmas);
		if (count > 0) {
			return true;
		}
		return false;
	}

	// 防止重复数据
	@Override
	public boolean Cselect(CourseSchedule courseSchedule) {
		String SQL = "select * from T_CourseSchedule where Stu_ID=? and ScheduleID=?";
		Object[] parmas = { courseSchedule.getStudent().getStu_ID(),
				courseSchedule.getSchedule().getID() };
		ResultSet rs = new BaseDAO().select(SQL, parmas);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
			if (count > 0) {
				return false;
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//学生学分修改
	@Override
	public boolean update(CourseSchedule courseSchedule) {
		// TODO Auto-generated method stub
		String SQL="update T_CourseSchedule set ScoreOne=?,ScoreTwo=?,ScoreThree=?,TotalScore=? where ID=?";
		Object [] parmas={courseSchedule.getScoreOne(),courseSchedule.getScoreTwo(),courseSchedule.getScoreThree()
				,courseSchedule.getTotalScore(),courseSchedule.getID()};
		int count=new BaseDAO().update(SQL, parmas);
		if(count>0){
			return true;
		}else {
			return false;
		}
	}

	//对应教师的对应课程
	@Override
	public List<VCourseSchedule> Tselect(String TeacherID,String CourseID) {
		// TODO Auto-generated method stub
		List<VCourseSchedule> list=new ArrayList<VCourseSchedule>();
		String SQL="select * from V_CourseSchedule where TeacherID=? and CourseID=?";
		Object[] parmas={TeacherID,CourseID};
		ResultSet rs=new BaseDAO().select(SQL, parmas);
		try {
			while (rs.next()) {
				VCourseSchedule vc = new VCourseSchedule();
				vc.setCourse(rs.getString("Course"));
				vc.setName(rs.getString("Name"));
				vc.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				vc.setClassRoomName(rs.getString("ClassRoomName"));
				vc.setProfessionName(rs.getString("ProfessionName"));
				vc.setClassfestival(rs.getString("Classfestival"));
				vc.setClassTime(rs.getString("ClassTime"));
				vc.setStudyTime(rs.getInt("StudyTime"));
				vc.setCrediy(rs.getDouble("Crediy"));
				vc.setCurriculumTime(rs.getString("CurriculumTime"));
				vc.setCurricula(rs.getString("Curricula"));
				vc.setTeacherID(rs.getString("TeacherID"));
				vc.setTeachTaskID(rs.getInt("TeachTaskID"));
				vc.setClassRoomID(rs.getString("ClassRoomID"));
				vc.setScheduleID(Integer.parseInt(rs.getString("ScheduleID")));
				vc.setCourseID(rs.getString("CourseID"));
				vc.setProfessionID(rs.getString("ProfessionID"));
				vc.setRemark(rs.getString("Remark"));
				list.add(vc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//删除某配置课程
	@Override
	public boolean delete(String scheduleID) {
		String SQL="delete from T_Schedule where id=?";
		Object[] parmas={scheduleID};
		int count=new BaseDAO().delete(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	//教师课程表
	@Override
	public List<VCourseSchedule> TTselect(String teacherID) {
		// TODO Auto-generated method stub
		List<VCourseSchedule> list=new ArrayList<VCourseSchedule>();
		String SQL="select * from V_CourseSchedule where TeacherID=? and Curricula=?";
		Object[] parmas={teacherID,util.getNewSemester()};
		ResultSet rs=new BaseDAO().select(SQL, parmas);
		try {
			while (rs.next()) {
				VCourseSchedule vc = new VCourseSchedule();
				vc.setCourse(rs.getString("Course"));
				vc.setName(rs.getString("Name"));
				vc.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				vc.setClassRoomName(rs.getString("ClassRoomName"));
				vc.setProfessionName(rs.getString("ProfessionName"));
				vc.setClassfestival(rs.getString("Classfestival"));
				vc.setClassTime(rs.getString("ClassTime"));
				vc.setStudyTime(rs.getInt("StudyTime"));
				vc.setCrediy(rs.getDouble("Crediy"));
				vc.setCurriculumTime(rs.getString("CurriculumTime"));
				vc.setCurricula(rs.getString("Curricula"));
				vc.setTeacherID(rs.getString("TeacherID"));
				vc.setTeachTaskID(rs.getInt("TeachTaskID"));
				vc.setClassRoomID(rs.getString("ClassRoomID"));
				vc.setScheduleID(Integer.parseInt(rs.getString("ScheduleID")));
				vc.setCourseID(rs.getString("CourseID"));
				vc.setProfessionID(rs.getString("ProfessionID"));
				vc.setRemark(rs.getString("Remark"));
				list.add(vc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
