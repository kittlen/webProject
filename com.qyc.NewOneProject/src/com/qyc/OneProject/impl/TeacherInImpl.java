package com.qyc.OneProject.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.TeacherInterface;
import com.qyc.OneProject.util.util;

public class TeacherInImpl implements TeacherInterface {
	
	iHibernatedao hb=new Hibernatedao();

	/**
	 * 登录验证
	 */
	@Override
	public Teacher login(Teacher tea){
		try {
			tea.setPassword(util.UseMD5(tea.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Teacher teacher=(Teacher) hb.getObj(Teacher.class, tea.getTeacherID());
		if(teacher!=null){
			if(teacher.getPassword().equals(tea.getPassword())){
				return teacher;
			}
		}
		return null;
	}
	
	/**
	 * 本人基本信息修改
	 */
	@Override
	public Teacher UpdateIn (Teacher tea){
		Teacher teacher=(Teacher) hb.getObj(Teacher.class, tea.getTeacherID());
		teacher.setSex(tea.getSex());
		teacher.setBirthday(tea.getBirthday());
		teacher.setKulture(tea.getKulture());
		teacher.setPhone(tea.getPhone());
		teacher.setHome(tea.getHome());
		teacher.setRemark(tea.getRemark());
		if(hb.update(teacher)==1){
			return teacher;
		}
		return null;
		
	}
	
	/**
	 * 本人密码修改 ||密码重置
	 */
	@Override
	public boolean UpdatePwd(Teacher tea){
		Teacher teacher=(Teacher) hb.getObj(Teacher.class, tea.getTeacherID());
		try {
			teacher.setPassword(util.UseMD5(tea.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hb.delete(teacher);
		if(hb.save(teacher)!=null){
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean insert(Teacher tea) {
		// TODO Auto-generated method stub
		try {
			tea.setPassword(util.UseMD5("123456"));
			tea.setPhoto(tea.getTeacherID());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pd=(String) hb.save(tea);
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Teacher tea) {
		// TODO Auto-generated method stub
		Teacher teacher=(Teacher) hb.getObj(Teacher.class, tea.getTeacherID());
		tea.setPassword(teacher.getPassword());
		tea.setPhoto(teacher.getPhoto());
		hb.delete(teacher);
		if(hb.save(tea)!=null){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Teacher tea) {
		// TODO Auto-generated method stub
		int pd= hb.delete(tea);
		if(pd==1){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> select(String CollegeID) {
		// TODO Auto-generated method stub
		List<Teacher> list=new ArrayList<Teacher>();
		String HQL="from Teacher tea where tea.College.CollegeID=?";
		Object [] parmas={CollegeID};
		list=hb.select(HQL,parmas);
		return list;
	}



}
