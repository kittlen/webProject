package com.qyc.OneProject.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.AdminInterface;
import com.qyc.OneProject.util.util;



public class AdminImpl implements AdminInterface {
	iHibernatedao hb=new Hibernatedao();

	/**
	 * 用于判断登录的账号是否正确
	 */
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		try {
			admin.setPassword(util.UseMD5(admin.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin thisAdmin=(Admin) hb.getObj(Admin.class, admin.getAdminID());
		if(thisAdmin!=null){
			if(thisAdmin.getPassword().equals(admin.getPassword())){
				return thisAdmin;
			}
		}
		return null;
		
	}

	@Override
	public boolean insert(Admin admin){
		// TODO Auto-generated method stub
		try {
			admin.setPassword(util.UseMD5("123456"));
			admin.setPhoto(admin.getAdminID());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pd=(String) hb.save(admin);
		if(!pd.equals("0")){
			return true;
		}
		return false;
		
	}
	/**
	 * 修改基本信息(姓名,备注)
	 */
	@Override
	public Admin UpdateIn(Admin admin){
		Admin adm=(Admin) hb.getObj(Admin.class, admin.getAdminID());
		adm.setAdminName(admin.getAdminName());
		adm.setRemark(admin.getRemark());
		if(hb.update(adm)==1){
			return adm;
		}
		return null;
	}
	@Override
	public boolean update(Admin admin) {
		// TODO Auto-generated method stub
		Admin adm=(Admin) hb.getObj(Admin.class, admin.getAdminID());
		adm.setAdminName(admin.getAdminName());
		adm.setPower(admin.getPower());
		adm.setRemark(admin.getRemark());
		if(hb.update(adm)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Admin admin) {
		// TODO Auto-generated method stub
		int pd= hb.delete(admin);
		if(pd==1){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> select() {
		// TODO Auto-generated method stub
		List<Admin> list=new ArrayList<Admin>();
		String HQL="from Admin adm";
		list=hb.select(HQL);
		return list;
	}
	
	/**
	 * 修改账号密码 ||密码重置
	 */
	@Override
	public boolean UpdatePwd(Admin admin){
		Admin adm=(Admin) hb.getObj(Admin.class,admin.getAdminID());
		try {
			adm.setPassword(util.UseMD5(admin.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pd=hb.update(adm);
		if(pd==1){
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
