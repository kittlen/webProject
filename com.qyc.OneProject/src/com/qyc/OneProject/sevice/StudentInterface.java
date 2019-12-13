package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Student;

public interface StudentInterface {
	
	boolean insert(Student stu);
	boolean update(Student stu);
	boolean delete(String Stu_ID);
	List<Student> select(String Class_ID);
	Student login(Student stu);
	boolean UpdatePwd(Student stu);
	boolean UpdateIn(Student stu);
}
