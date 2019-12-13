package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.College;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.CollegeInterface;

public class CollegeInImpl implements CollegeInterface{


	@Override
	public boolean insert(College coll) {
		// TODO Auto-generated method stub
		String SQL="insert into T_College values (?,?,?)";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={coll.getCollegeID(),coll.getCollegeName(),coll.getRemark()};
		int count=bd.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(College coll) {
		// TODO Auto-generated method stub
		String SQL="update T_College set CollegeName=?,Remark=? where CollegeID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={coll.getCollegeName(),coll.getRemark(),coll.getCollegeID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String collegeID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_College where CollegeID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={collegeID};
		int count=bd.delete(SQL,parmas);
		if(count>0){
			return true;
		}
		return false;
	}
	
	@Override
	public List<College> select() {
		// TODO Auto-generated method stub
		List<College> list=new ArrayList<College>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_College";
		ResultSet rs=bd.select(SQL);
		try {
			while (rs.next()) {
				College college=new College();
				college.setCollegeID(rs.getString("CollegeID"));
				college.setCollegeName(rs.getString("CollegeName"));
				college.setRemark(rs.getString("Remark"));
				list.add(college);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
