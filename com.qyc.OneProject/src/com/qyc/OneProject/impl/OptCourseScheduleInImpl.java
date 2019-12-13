package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.VOptCourseSchedule;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.OptCourseScheduleInterface;
import com.qyc.OneProject.util.util;

public class OptCourseScheduleInImpl implements OptCourseScheduleInterface {

	@Override
	public List<VOptCourseSchedule> select(String Stu_ID) {
		// TODO Auto-generated method stub
		String SQL="select * from V_OptCourseSchedule where Stu_ID=?";
		Object [] parmas={Stu_ID};
		ResultSet rs=new BaseDAO().select(SQL,parmas);
		List<VOptCourseSchedule> list=new ArrayList<VOptCourseSchedule>();
		try {
			while (rs.next()) {
				VOptCourseSchedule vSchedule=new VOptCourseSchedule();
				vSchedule.setClass_ID(rs.getString("Class_ID"));
				vSchedule.setClassfestival(rs.getString("Classfestival"));
				vSchedule.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				vSchedule.setClassRoomID(rs.getString("ClassRoomID"));
				vSchedule.setClassRoomName(rs.getString("ClassRoomName"));
				vSchedule.setClassTime(rs.getString("ClassTime"));
				vSchedule.setCourse(rs.getString("Course"));
				vSchedule.setCourseID(rs.getString("CourseID"));
				vSchedule.setCourseScheduleID(rs.getInt("CourseScheduleID"));
				vSchedule.setCrediy(rs.getDouble("Crediy"));
				vSchedule.setCurricula(rs.getString("Curricula"));
				vSchedule.setCurriculumTime(rs.getString("CurriculumTime"));
				vSchedule.setGradeName(rs.getString("GradeName"));
				vSchedule.setProfessionID(rs.getString("ProfessionID"));
				vSchedule.setProfessionName(rs.getString("ProfessionName"));
				vSchedule.setRemark(rs.getString("Remark"));
				vSchedule.setScheduleID(rs.getInt("ScheduleID"));
				vSchedule.setScoreOne(rs.getDouble("ScoreOne"));
				vSchedule.setScoreThree(rs.getDouble("ScoreThree"));
				vSchedule.setScoreTwo(rs.getDouble("ScoreTwo"));
				vSchedule.setStu_ID(rs.getString("Stu_ID"));
				vSchedule.setStudentName(rs.getString("StudentName"));
				vSchedule.setStudyTime(rs.getInt("StudyTime"));
				vSchedule.setTeacherID(rs.getString("TeacherID"));
				vSchedule.setTeacherName(rs.getString("TeacherName"));
				vSchedule.setTeachTaskID(rs.getInt("TeachTaskID"));
				vSchedule.setTotalScore(rs.getDouble("TotalScore"));
				vSchedule.setYearName(rs.getString("YearName"));
				list.add(vSchedule);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean delete(String CourseScheduleID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_CourseSchedule where ID=?";
		Object [] parmas={CourseScheduleID};
		int count=new BaseDAO().delete(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<VOptCourseSchedule> Tselect(String teacherID, String CourseID) {
		// TODO Auto-generated method stub
		String SQL="select * from V_OptCourseSchedule where teacherID=? and CourseID=?";
		Object [] parmas={teacherID,CourseID};
		ResultSet rs=new BaseDAO().select(SQL,parmas);
		List<VOptCourseSchedule> list=new ArrayList<VOptCourseSchedule>();
		try {
			while (rs.next()) {
				VOptCourseSchedule vSchedule=new VOptCourseSchedule();
				vSchedule.setClass_ID(rs.getString("Class_ID"));
				vSchedule.setClassfestival(rs.getString("Classfestival"));
				vSchedule.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				vSchedule.setClassRoomID(rs.getString("ClassRoomID"));
				vSchedule.setClassRoomName(rs.getString("ClassRoomName"));
				vSchedule.setClassTime(rs.getString("ClassTime"));
				vSchedule.setCourse(rs.getString("Course"));
				vSchedule.setCourseID(rs.getString("CourseID"));
				vSchedule.setCourseScheduleID(rs.getInt("CourseScheduleID"));
				vSchedule.setCrediy(rs.getDouble("Crediy"));
				vSchedule.setCurricula(rs.getString("Curricula"));
				vSchedule.setCurriculumTime(rs.getString("CurriculumTime"));
				vSchedule.setGradeName(rs.getString("GradeName"));
				vSchedule.setProfessionID(rs.getString("ProfessionID"));
				vSchedule.setProfessionName(rs.getString("ProfessionName"));
				vSchedule.setRemark(rs.getString("Remark"));
				vSchedule.setScheduleID(rs.getInt("ScheduleID"));
				vSchedule.setScoreOne(rs.getDouble("ScoreOne"));
				vSchedule.setScoreThree(rs.getDouble("ScoreThree"));
				vSchedule.setScoreTwo(rs.getDouble("ScoreTwo"));
				vSchedule.setStu_ID(rs.getString("Stu_ID"));
				vSchedule.setStudentName(rs.getString("StudentName"));
				vSchedule.setStudyTime(rs.getInt("StudyTime"));
				vSchedule.setTeacherID(rs.getString("TeacherID"));
				vSchedule.setTeacherName(rs.getString("TeacherName"));
				vSchedule.setTeachTaskID(rs.getInt("TeachTaskID"));
				vSchedule.setTotalScore(rs.getDouble("TotalScore"));
				vSchedule.setYearName(rs.getString("YearName"));
				list.add(vSchedule);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<VOptCourseSchedule> TSselect(String Stu_ID) {
		// TODO Auto-generated method stub
		String SQL="select * from V_OptCourseSchedule where Stu_ID=? and Curricula=?";
		Object [] parmas={Stu_ID,util.getNewSemester()};
		ResultSet rs=new BaseDAO().select(SQL,parmas);
		List<VOptCourseSchedule> list=new ArrayList<VOptCourseSchedule>();
		try {
			while (rs.next()) {
				VOptCourseSchedule vSchedule=new VOptCourseSchedule();
				vSchedule.setClass_ID(rs.getString("Class_ID"));
				vSchedule.setClassfestival(rs.getString("Classfestival"));
				vSchedule.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				vSchedule.setClassRoomID(rs.getString("ClassRoomID"));
				vSchedule.setClassRoomName(rs.getString("ClassRoomName"));
				vSchedule.setClassTime(rs.getString("ClassTime"));
				vSchedule.setCourse(rs.getString("Course"));
				vSchedule.setCourseID(rs.getString("CourseID"));
				vSchedule.setCourseScheduleID(rs.getInt("CourseScheduleID"));
				vSchedule.setCrediy(rs.getDouble("Crediy"));
				vSchedule.setCurricula(rs.getString("Curricula"));
				vSchedule.setCurriculumTime(rs.getString("CurriculumTime"));
				vSchedule.setGradeName(rs.getString("GradeName"));
				vSchedule.setProfessionID(rs.getString("ProfessionID"));
				vSchedule.setProfessionName(rs.getString("ProfessionName"));
				vSchedule.setRemark(rs.getString("Remark"));
				vSchedule.setScheduleID(rs.getInt("ScheduleID"));
				vSchedule.setScoreOne(rs.getDouble("ScoreOne"));
				vSchedule.setScoreThree(rs.getDouble("ScoreThree"));
				vSchedule.setScoreTwo(rs.getDouble("ScoreTwo"));
				vSchedule.setStu_ID(rs.getString("Stu_ID"));
				vSchedule.setStudentName(rs.getString("StudentName"));
				vSchedule.setStudyTime(rs.getInt("StudyTime"));
				vSchedule.setTeacherID(rs.getString("TeacherID"));
				vSchedule.setTeacherName(rs.getString("TeacherName"));
				vSchedule.setTeachTaskID(rs.getInt("TeachTaskID"));
				vSchedule.setTotalScore(rs.getDouble("TotalScore"));
				vSchedule.setYearName(rs.getString("YearName"));
				list.add(vSchedule);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<VOptCourseSchedule> Sselect(String Stu_ID) {
		// TODO Auto-generated method stub
		String SQL="select * from V_OptCourseSchedule where Stu_ID=? and Curricula=?";
		Object [] parmas={Stu_ID,util.getNewSemester()};
		ResultSet rs=new BaseDAO().select(SQL,parmas);
		List<VOptCourseSchedule> list=new ArrayList<VOptCourseSchedule>();
		try {
			while (rs.next()) {
				VOptCourseSchedule vSchedule=new VOptCourseSchedule();
				vSchedule.setClass_ID(rs.getString("Class_ID"));
				vSchedule.setClassfestival(rs.getString("Classfestival"));
				vSchedule.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				vSchedule.setClassRoomID(rs.getString("ClassRoomID"));
				vSchedule.setClassRoomName(rs.getString("ClassRoomName"));
				vSchedule.setClassTime(rs.getString("ClassTime"));
				vSchedule.setCourse(rs.getString("Course"));
				vSchedule.setCourseID(rs.getString("CourseID"));
				vSchedule.setCourseScheduleID(rs.getInt("CourseScheduleID"));
				vSchedule.setCrediy(rs.getDouble("Crediy"));
				vSchedule.setCurricula(rs.getString("Curricula"));
				vSchedule.setCurriculumTime(rs.getString("CurriculumTime"));
				vSchedule.setGradeName(rs.getString("GradeName"));
				vSchedule.setProfessionID(rs.getString("ProfessionID"));
				vSchedule.setProfessionName(rs.getString("ProfessionName"));
				vSchedule.setRemark(rs.getString("Remark"));
				vSchedule.setScheduleID(rs.getInt("ScheduleID"));
				vSchedule.setScoreOne(rs.getDouble("ScoreOne"));
				vSchedule.setScoreThree(rs.getDouble("ScoreThree"));
				vSchedule.setScoreTwo(rs.getDouble("ScoreTwo"));
				vSchedule.setStu_ID(rs.getString("Stu_ID"));
				vSchedule.setStudentName(rs.getString("StudentName"));
				vSchedule.setStudyTime(rs.getInt("StudyTime"));
				vSchedule.setTeacherID(rs.getString("TeacherID"));
				vSchedule.setTeacherName(rs.getString("TeacherName"));
				vSchedule.setTeachTaskID(rs.getInt("TeachTaskID"));
				vSchedule.setTotalScore(rs.getDouble("TotalScore"));
				vSchedule.setYearName(rs.getString("YearName"));
				list.add(vSchedule);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
