package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.College;
import com.qyc.OneProject.Model.Department;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.DepartmentInterface;

public class DepartmentInImpl implements DepartmentInterface {

	@Override
	public boolean insert(Department dep) {
		// TODO Auto-generated method stub
		String SQL="insert into T_Department values (?,?,?,?)";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={dep.getDepartmentID(),dep.getDepartmentName(),dep.getCollege().getCollegeID(),dep.getRemark()};
		int count=bd.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Department dep) {
		// TODO Auto-generated method stub
		String SQL="update T_Department set DepartmentName=?,Remark=? where DepartmentID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={dep.getDepartmentName(),dep.getRemark(),dep.getDepartmentID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String DepartmentID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_Department where DepartmentID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={DepartmentID};
		int count=bd.delete(SQL,parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Department> select(String CollegeID) {
		// TODO Auto-generated method stub
		List<Department> list=new ArrayList<Department>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_Department where CollegeID=?";
		Object[] parmas={CollegeID};
		ResultSet rs=bd.select(SQL, parmas);
		try {
			while (rs.next()) {
				Department dep=new Department();
				College col=new College();
				col.setCollegeID(rs.getString("CollegeID"));
				dep.setDepartmentID(rs.getString("DepartmentID"));
				dep.setDepartmentName(rs.getString("DepartmentName"));
				dep.setCollege(col);
				dep.setRemark(rs.getString("Remark"));
				list.add(dep);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
