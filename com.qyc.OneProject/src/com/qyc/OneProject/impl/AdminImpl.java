package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.AdminInterface;

public class AdminImpl implements AdminInterface {

	/**
	 * 用于判断登录的账号是否正确
	 */
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		String SQL="select * from T_Admin where AdminID=? and Password=?";
		BaseDAO baseDAO=new BaseDAO();
		Object[] parmas={admin.getAdminID(),admin.getPassword()};
		ResultSet rs=baseDAO.select(SQL, parmas);
		Admin adm=new Admin();
		try {
			while (rs.next()) {
				adm.setAdminID(rs.getString("AdminID"));
				adm.setAdminName(rs.getString("AdminName"));
				adm.setPassword(rs.getString("Password"));
				adm.setPhoto(rs.getString("Photo"));
				adm.setPower(rs.getString("power"));
				adm.setRemark(rs.getString("Remark"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adm;
	}

	@Override
	public boolean insert(Admin admin){
		// TODO Auto-generated method stub
		String SQL="insert into T_Admin values (?,?,?,?,?,?)";
		BaseDAO baseDAO=new BaseDAO();
		Object[] parmas={admin.getAdminID(),admin.getAdminName(),admin.getPassword(),admin.getPower(),admin.getPhoto(),admin.getRemark()};
		int count=baseDAO.insert(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
		
	}
	/**
	 * 修改基本信息(姓名,备注)
	 */
	@Override
	public boolean UpdateIn(Admin admin){
		String SQL="update T_Admin set AdminName=?,Remark=? where AdminID=?";
		BaseDAO baseDAO=new BaseDAO();
		Object[] parmas={admin.getAdminName(),admin.getRemark(),admin.getAdminID()};
		int count=baseDAO.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}
	@Override
	public boolean update(Admin admin) {
		// TODO Auto-generated method stub
		String SQL="update T_Admin set AdminName=?,Power=?,Remark=? where AdminID=?";
		BaseDAO baseDAO=new BaseDAO();
		Object[] parmas={admin.getAdminName(),admin.getPower(),admin.getRemark(),admin.getAdminID()};
		int count=baseDAO.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Admin admin) {
		// TODO Auto-generated method stub
		if(admin.getAdminID().equals("admin")){
			return false;
		}
		String SQL="delete from T_Admin where AdminID=?";
		BaseDAO baseDAO=new BaseDAO();
		Object[] parmas={admin.getAdminID()};
		int count=baseDAO.delete(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Admin> select() {
		// TODO Auto-generated method stub
		String SQL="select * from T_Admin";
		BaseDAO baseDAO=new BaseDAO();
		ResultSet rs=baseDAO.select(SQL);
		List<Admin> list=new ArrayList<Admin>();
		try {
			while(rs.next()){
				Admin admin=new Admin();
				admin.setAdminID(rs.getString("AdminID"));
				admin.setAdminName(rs.getString("AdminName"));
				admin.setPassword(rs.getString("Password"));
				admin.setPhoto(rs.getString("Photo"));
				admin.setPower(rs.getString("Power"));
				admin.setRemark(rs.getString("Remark"));
				list.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 修改账号密码 ||密码重置
	 */
	@Override
	public boolean ResetPwd(Admin admin){
		String SQL="update T_Admin set Password=? where AdminID=?";
		Object[] parmas={admin.getPassword(),admin.getAdminID()};
		BaseDAO baseDAO=new BaseDAO();
		int count=baseDAO.update(SQL, parmas);
		if(count>0){
			return true;
		}
		return false;
		
	}

	/*public static void main(String[] args) {
		Admin admin=new Admin();
		admin.setAdminID("admin");
		admin.setPassword("123456");
		try {
			new AdminImpl().insert(admin);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
