package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Class;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.StudentInterface;

public class StudentInImpl implements StudentInterface {

	/**
	 * 登录验证
	 */
	@Override
	public Student login(Student stu){
		String SQL="select * from T_Student where Stu_ID=? and Password=?";
		Object [] parmas={stu.getStu_ID(),stu.getPassword()};
		BaseDAO baseDAO=new BaseDAO();
		ResultSet rs=baseDAO.select(SQL, parmas);
		Student student=new Student();
		try {
			while (rs.next()) {
				Class cla=new Class();
				cla.setClass_ID(rs.getString("Class_ID"));
				student.setStu_ID(rs.getString("Stu_ID"));
				student.setName(rs.getString("Name"));
				student.setSex(rs.getString("Sex"));
				student.setBirth(rs.getString("Birth"));
				SQL="select * from T_Class where Class_ID="+cla.getClass_ID();
				ResultSet rsc=baseDAO.select(SQL);
				while (rsc.next()) {
					cla.setGradeName(rsc.getString("GradeName"));
					cla.setYearName(rsc.getString("YearName"));
				}
				student.setTClass(cla);
				student.setPhone(rs.getString("Phone"));
				student.setFamily(rs.getString("Family"));
				student.setPhoto(rs.getString("Photo"));
				student.setPassword(rs.getString("Password"));
				student.setRemark(rs.getString("Remark"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	/**
	 * 本人基本信息修改
	 */
	@Override
	public boolean UpdateIn (Student stu){
		String SQL="update T_Student set Name=?,Sex=?,Birth=?,"
				+ "Phone=?,Family=?,Remark=? where Stu_ID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={stu.getName(),stu.getSex(),stu.getBirth(),stu.getPhone(),stu.getFamily(),
				stu.getRemark(),stu.getStu_ID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
		
	}
	
	/**
	 * 本人密码修改||密码重置
	 */
	@Override
	public boolean UpdatePwd(Student stu){
		String SQL="update T_Student set Password=? where Stu_ID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={stu.getPassword(),stu.getStu_ID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(Student stu) {
		// TODO Auto-generated method stub
		String SQL="insert into T_Student values (?,?,?,?,?,?,?,?,?,?)";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={stu.getStu_ID(),stu.getName(),stu.getSex(),stu.getBirth(),stu.getTClass().getClass_ID(),
				stu.getPhone(),stu.getFamily(),stu.getPhoto(),stu.getPassword(),stu.getRemark()};
		int count=bd.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Student stu) {
		// TODO Auto-generated method stub
		String SQL="update T_Student set Name=?,Sex=?,Birth=?"
				+ ",Phone=?,Family=?,Remark=? where Stu_ID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={stu.getName(),stu.getSex(),stu.getBirth(),stu.getPhone(),stu.getFamily(),
				stu.getRemark(),stu.getStu_ID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String Stu_ID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_Student where Stu_ID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={Stu_ID};
		int count=bd.delete(SQL,parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Student> select(String Class_ID) {
		// TODO Auto-generated method stub
		List<Student> list=new ArrayList<Student>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_Student where Class_ID=?";
		Object[] parmas={Class_ID};
		ResultSet rs=bd.select(SQL, parmas);
		try {
			while (rs.next()) {
				Student stu=new Student();
				Class cla=new Class();
				cla.setClass_ID(rs.getString("Class_ID"));
				stu.setStu_ID(rs.getString("Stu_ID"));
				stu.setName(rs.getString("Name"));
				stu.setSex(rs.getString("Sex"));
				stu.setBirth(rs.getString("Birth"));
				stu.setTClass(cla);
				stu.setPhone(rs.getString("Phone"));
				stu.setFamily(rs.getString("Family"));
				stu.setRemark(rs.getString("Remark"));
				list.add(stu);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
