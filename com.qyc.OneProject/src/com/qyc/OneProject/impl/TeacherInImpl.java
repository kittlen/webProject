package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.College;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.TeacherInterface;

public class TeacherInImpl implements TeacherInterface {

	/**
	 * 登录验证
	 */
	@Override
	public Teacher login(Teacher tea){
		String SQL="select * from T_Teacher where TeacherID=? and Password=?";
		Object[] parmas={tea.getTeacherID(),tea.getPassword()};
		BaseDAO bd=new BaseDAO();
		ResultSet rs=bd.select(SQL, parmas);
		Teacher teacher=new Teacher();
		try {
			while (rs.next()) {
				College college=new College();
				teacher.setTeacherID(rs.getString("TeacherID"));
				teacher.setName(rs.getString("Name"));
				college.setCollegeID(rs.getString("CollegeID"));
				SQL="select * from T_College where CollegeID="+college.getCollegeID();
				ResultSet ret=bd.select(SQL);
				while (ret.next()) {
					college.setCollegeName(ret.getString("CollegeName"));
				}
				teacher.setCollege(college);
				teacher.setSex(rs.getString("Sex"));
				teacher.setBirthday(rs.getString("Birthday"));
				teacher.setKulture(rs.getString("Kulture"));
				teacher.setHome(rs.getString("Home"));
				teacher.setPhone(rs.getString("Phone"));
				teacher.setPhoto(rs.getString("Photo"));
				teacher.setPassword(rs.getString("Password"));
				teacher.setRemark(rs.getString("Remark"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}
	
	/**
	 * 本人基本信息修改
	 */
	@Override
	public boolean UpdateIn (Teacher tea){
		String SQL="update T_Teacher set Name=?,Sex=?,Birthday=?,Kulture=?,Phone=?,"
				+ "Home=?,Remark=? where TeacherID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={tea.getName(),tea.getSex(),tea.getBirthday(),tea.getKulture(),
				tea.getPhone(),tea.getHome(),tea.getRemark(),tea.getTeacherID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
		
	}
	
	/**
	 * 本人密码修改 ||密码重置
	 */
	@Override
	public boolean RevisePwd(Teacher tea){
		String SQL="update T_Teacher set Password=? where TeacherID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={tea.getPassword(),tea.getTeacherID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean insert(Teacher tea) {
		// TODO Auto-generated method stub
		String SQL="insert into T_Teacher values (?,?,?,?,?,?,?,?,?,?,?)";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={tea.getTeacherID(),tea.getName(),tea.getCollege().getCollegeID(),tea.getSex(),tea.getBirthday(),
				tea.getKulture(),tea.getPhone(),tea.getHome(),tea.getPhoto(),tea.getPassword(),tea.getRemark()};
		int count=bd.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Teacher tea) {
		// TODO Auto-generated method stub
		String SQL="update T_Teacher set Name=?,Sex=?,Birthday=?,Kulture=?,Phone=?,"
				+ "Home=?,Remark=? where TeacherID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={tea.getName(),tea.getSex(),tea.getBirthday(),tea.getKulture(),
				tea.getPhone(),tea.getHome(),tea.getRemark(),tea.getTeacherID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String TeacherID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_Teacher where TeacherID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={TeacherID};
		int count=bd.delete(SQL,parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Teacher> select(String CollegeID) {
		// TODO Auto-generated method stub
		List<Teacher> list=new ArrayList<Teacher>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_Teacher where CollegeID=?";
		Object[] parmas={CollegeID};
		ResultSet rs=bd.select(SQL, parmas);
		try {
			while (rs.next()) {
				Teacher tea=new Teacher();
				College college=new College();
				tea.setTeacherID(rs.getString("TeacherID"));
				tea.setName(rs.getString("Name"));
				college.setCollegeID(rs.getString("CollegeID"));
				tea.setCollege(college);
				tea.setSex(rs.getString("Sex"));
				tea.setBirthday(rs.getString("Birthday"));
				tea.setKulture(rs.getString("Kulture"));
				tea.setHome(rs.getString("Home"));
				tea.setPhone(rs.getString("Phone"));
				tea.setPassword(rs.getString("Password"));
				tea.setRemark(rs.getString("Remark"));
				list.add(tea);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
