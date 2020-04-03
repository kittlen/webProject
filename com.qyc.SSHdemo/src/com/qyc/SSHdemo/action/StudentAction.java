package com.qyc.SSHdemo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.qyc.SSHdemo.mode.Student;
import com.qyc.SSHdemo.service.StudentService;

public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1379426937243073900L;
	private Student student;
	private StudentService studentService;
	
	public String insert(){
		studentService.save(student);
		return "success";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	
	
	
}
