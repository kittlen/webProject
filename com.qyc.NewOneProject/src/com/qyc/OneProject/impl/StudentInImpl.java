package com.qyc.OneProject.impl;


import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.StudentInterface;
import com.qyc.OneProject.util.util;

public class StudentInImpl implements StudentInterface {

	iHibernatedao hb=new Hibernatedao();
	
	/**
	 * 登录验证
	 */
	@Override
	public Student login(Student stu){
		try {
			stu.setPassword(util.UseMD5(stu.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student student=(Student) hb.getObj(Student.class, stu.getStu_ID());
		if(student!=null){
			if(student.getPassword().equals(stu.getPassword())){
				return student;
			}
		}
		return null;
	}
	
	/**
	 * 本人基本信息修改
	 */
	@Override
	public Student UpdateIn (Student stu){
		Student student=(Student) hb.getObj(Student.class, stu.getStu_ID());
		student.setSex(stu.getSex());
		student.setBirth(stu.getBirth());
		student.setFamily(stu.getFamily());
		student.setPhone(stu.getPhone());
		student.setRemark(stu.getRemark());
		if(hb.update(student)==1){
			return student;
		}
		return null;
		
	}
	
	/**
	 * 本人密码修改||密码重置
	 */
	@Override
	public boolean UpdatePwd(Student stu){
		Student student=(Student) hb.getObj(Student.class, stu.getStu_ID());
		try {
			student.setPassword(util.UseMD5(stu.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pd=hb.update(student);
		if(pd==1){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean insert(Student stu) {
		// TODO Auto-generated method stub
		try {
			stu.setPassword(util.UseMD5("123456"));
			stu.setPhoto(stu.getStu_ID());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pd=(String) hb.save(stu);
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	//bug无法进行正常修改操作
	@Override
	public boolean update(Student stu) {
		// TODO Auto-generated method stub
		Student student=(Student) hb.getObj(Student.class, stu.getStu_ID());
		stu.setPassword(student.getPassword());
		stu.setPhoto(student.getPhoto());
		hb.delete(student);
		if(hb.save(stu)!=null){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Student stu) {
		// TODO Auto-generated method stub
		int pd= hb.delete(stu);
		if(pd==1){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> select(String Class_ID) {
		// TODO Auto-generated method stub
		List<Student> list=new ArrayList<Student>();
		String HQL="from Student stu where stu.TClass.Class_ID=?";
		Object [] parmas={Class_ID};
		list=hb.select(HQL,parmas);
		return list;
	}

}
