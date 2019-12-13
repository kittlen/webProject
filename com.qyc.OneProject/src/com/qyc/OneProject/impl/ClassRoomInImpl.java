package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.ClassRoom;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.ClassRoomInterface;

public class ClassRoomInImpl implements ClassRoomInterface {

	@Override
	public boolean insert(ClassRoom claRo) {
		// TODO Auto-generated method stub
		String SQL="insert into T_ClassRoom values (?,?,?,?)";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={claRo.getID(),claRo.getClassRoomName(),claRo.getClassRoomCategory(),claRo.getRemark()};
		int count=bd.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(ClassRoom claRo) {
		// TODO Auto-generated method stub
		String SQL="update T_ClassRoom set ClassRoomName=?,ClassRoomCategory=?,Remark=? where ID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={claRo.getClassRoomName(),claRo.getClassRoomCategory(),claRo.getRemark(),claRo.getID()};
		int count=bd.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(String ID) {
		// TODO Auto-generated method stub
		String SQL="delete from T_ClassRoom where ID=?";
		BaseDAO bd=new BaseDAO();
		Object[] parmas={ID};
		int count=bd.delete(SQL,parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<ClassRoom> select() {
		// TODO Auto-generated method stub
		List<ClassRoom> list=new ArrayList<ClassRoom>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_ClassRoom";
		ResultSet rs=bd.select(SQL);
		try {
			while (rs.next()) {
				ClassRoom claRoege=new ClassRoom();
				claRoege.setID(rs.getString("ID"));
				claRoege.setClassRoomName(rs.getString("ClassRoomName"));
				claRoege.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				claRoege.setRemark(rs.getString("Remark"));
				list.add(claRoege);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ClassRoom> Nameselect(String ClassRoomCategory) {
		// TODO Auto-generated method stub
		List<ClassRoom> list=new ArrayList<ClassRoom>();
		BaseDAO bd=new BaseDAO();
		String SQL="select * from T_ClassRoom where ClassRoomCategory=?";
		Object[] parmas={ClassRoomCategory};
		ResultSet rs=bd.select(SQL,parmas);
		try {
			while (rs.next()) {
				ClassRoom claRoege=new ClassRoom();
				claRoege.setID(rs.getString("ID"));
				claRoege.setClassRoomName(rs.getString("ClassRoomName"));
				claRoege.setClassRoomCategory(rs.getString("ClassRoomCategory"));
				claRoege.setRemark(rs.getString("Remark"));
				list.add(claRoege);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
