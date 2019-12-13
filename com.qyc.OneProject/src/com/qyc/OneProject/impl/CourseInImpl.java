package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Course;
import com.qyc.OneProject.Model.Profession;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.CourseInterface;

public class CourseInImpl implements CourseInterface {

	@Override
	public boolean insert(Course cou) {
		// TODO Auto-generated method stub
		String SQL="insert into T_Course values (?,?,?,?,?,?,?)";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={cou.getCourseID(),cou.getCourse(),cou.getProfession().getProfessionID(),
				cou.getStudyTime(),cou.getCrediy(),cou.getCurriculumTime(),cou.getRemark()};
		int count=bd.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Course cou) {
		// TODO Auto-generated method stub
		String SQL="update T_Course set Course=?,StudyTime=?,Crediy=?,CurriculumTime=?,Remark=? where CourseID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={cou.getCourse(),cou.getStudyTime(),cou.getCrediy(),cou.getCurriculumTime(),
				cou.getRemark(),cou.getCourseID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String CourseID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_Course where CourseID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={CourseID};
		int count=bd.delete(SQL,parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Course> select(String ProfessionID) {
		// TODO Auto-generated method stub
		List<Course> list=new ArrayList<Course>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_Course where ProfessionID=?";
		Object[] parmas={ProfessionID};
		ResultSet rs=bd.select(SQL, parmas);
		try {
			while (rs.next()) {
				Course cou=new Course();
				Profession pro=new Profession();
				pro.setProfessionID(rs.getString("ProfessionID"));
				cou.setCourseID(rs.getString("CourseID"));
				cou.setCourse(rs.getString("Course"));
				cou.setProfession(pro);
				cou.setStudyTime(rs.getInt("StudyTime"));
				cou.setCrediy(rs.getFloat("Crediy"));
				cou.setCurriculumTime(rs.getString("CurriculumTime"));
				cou.setRemark(rs.getString("Remark"));
				list.add(cou);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Course> TCselect(String ProfessionID,String TeacherID) {
		// TODO Auto-generated method stub
		List<Course> list=new ArrayList<Course>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_Course where ProfessionID=?";
		Object[] parmas={ProfessionID};
		ResultSet rs=bd.select(SQL, parmas);
		try {
			while (rs.next()) {
				Course cou=new Course();
				Profession pro=new Profession();
				pro.setProfessionID(rs.getString("ProfessionID"));
				cou.setCourseID(rs.getString("CourseID"));
				cou.setCourse(rs.getString("Course"));
				cou.setProfession(pro);
				cou.setStudyTime(rs.getInt("StudyTime"));
				cou.setCrediy(rs.getFloat("Crediy"));
				cou.setCurriculumTime(rs.getString("CurriculumTime"));
				cou.setRemark(rs.getString("Remark"));
				if(TeachTaskSelect(TeacherID, rs.getString("CourseID"))>0){
					cou.setState("ÒÑ¿ª¿Î");
				}else {
					cou.setState("Î´¿ª¿Î");
				}
				list.add(cou);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int TeachTaskSelect(String TeacherID,String CourseID){
		String SQL="select * from T_TeachTask where TeacherID=? and CourseID=?";
		BaseDAO baseDAO=new BaseDAO();
		Object[] parmas={TeacherID,CourseID};
		ResultSet rs=baseDAO.select(SQL,parmas);
		int count=0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
