package com.qyc.SSHdemo.service.impl;

import com.qyc.SSHdemo.dao.StudentDao;
import com.qyc.SSHdemo.mode.Student;
import com.qyc.SSHdemo.service.StudentService;

public class StudentServiceImpl implements StudentService{

	private  StudentDao studentDao;
	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDao.save(student);
	}
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
