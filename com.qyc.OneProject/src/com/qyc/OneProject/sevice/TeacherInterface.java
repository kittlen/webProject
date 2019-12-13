package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Teacher;

public interface TeacherInterface {
	
	boolean insert(Teacher tea);
	boolean update(Teacher tea);
	boolean delete(String TeacherID);
	List<Teacher> select(String CollegeID);
	Teacher login(Teacher tea);
	boolean RevisePwd(Teacher tea);
	boolean UpdateIn(Teacher tea);

}
