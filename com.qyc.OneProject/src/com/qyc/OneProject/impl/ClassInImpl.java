package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Class;
import com.qyc.OneProject.Model.Profession;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.ClassInterface;

public class ClassInImpl implements ClassInterface{

	@Override
	public boolean insert(Class cla) {
		// TODO Auto-generated method stub
		String SQL="insert into T_Class values (?,?,?,?,?)";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={cla.getClass_ID(),cla.getGradeName(),cla.getYearName(),cla.getProfession().getProfessionID(),cla.getRemark()};
		int count=bd.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Class cla) {
		// TODO Auto-generated method stub
		String SQL="update T_Class set GradeName=?,YearName=?,Remark=? where Class_ID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={cla.getGradeName(),cla.getYearName(),cla.getRemark(),cla.getClass_ID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String Class_ID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_Class where Class_ID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={Class_ID};
		int count=bd.delete(SQL,parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Class> select(String ProfessionID) {
		// TODO Auto-generated method stub
		List<Class> list=new ArrayList<Class>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_Class where ProfessionID=?";
		Object[] parmas={ProfessionID};
		ResultSet rs=bd.select(SQL, parmas);
		try {
			while (rs.next()) {
				Class cla=new Class();
				Profession pro=new Profession();
				pro.setProfessionID(rs.getString("ProfessionID"));
				cla.setClass_ID(rs.getString("Class_ID"));
				cla.setGradeName(rs.getString("GradeName"));
				cla.setYearName(rs.getString("YearName"));
				cla.setProfession(pro);
				cla.setRemark(rs.getString("Remark"));
				list.add(cla);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
