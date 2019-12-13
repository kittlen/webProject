package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Department;
import com.qyc.OneProject.Model.Profession;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.ProfessionInterface;

public class ProfessionInImpl implements ProfessionInterface {

	@Override
	public boolean insert(Profession pro) {
		// TODO Auto-generated method stub
		String SQL="insert into T_Profession values (?,?,?,?)";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={pro.getProfessionID(),pro.getProfessionName(),pro.getDepartment().getDepartmentID(),pro.getRemark()};
		int count=bd.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Profession pro) {
		// TODO Auto-generated method stub
		String SQL="update T_Profession set ProfessionName=?,Remark=? where ProfessionID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={pro.getProfessionName(),pro.getRemark(),pro.getProfessionID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String ProfessionID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_Profession where ProfessionID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={ProfessionID};
		int count=bd.delete(SQL,parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Profession> select(String DepartmentID) {
		// TODO Auto-generated method stub
		List<Profession> list=new ArrayList<Profession>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_Profession where DepartmentID=?";
		Object[] parmas={DepartmentID};
		ResultSet rs=bd.select(SQL, parmas);
		try {
			while (rs.next()) {
				Profession pro=new Profession();
				Department dep=new Department();
				dep.setDepartmentID(rs.getString("DepartmentID"));
				pro.setProfessionID(rs.getString("ProfessionID"));
				pro.setProfessionName(rs.getString("ProfessionName"));
				pro.setDepartment(dep);
				pro.setRemark(rs.getString("Remark"));
				list.add(pro);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
