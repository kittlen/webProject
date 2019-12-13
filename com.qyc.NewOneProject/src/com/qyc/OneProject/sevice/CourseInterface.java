package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Course;

public interface CourseInterface {

	boolean insert(Course cou);

	boolean update(Course cou);

	boolean delete(Course cou);

	List<Course> select(String ProfessionID);

	List<Course> TCselect(Course course, String TeacherID);

}
