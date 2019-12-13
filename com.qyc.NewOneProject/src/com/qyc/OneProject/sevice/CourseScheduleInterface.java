package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.CourseSchedule;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.Model.VCourseSchedule;

public interface CourseScheduleInterface {
	List<VCourseSchedule> select(VCourseSchedule vCS);
	boolean insert(VCourseSchedule vCS, Student student);
	boolean update(CourseSchedule cSchedule);
	List<VCourseSchedule> TTselect(Teacher teacher);
	List<VCourseSchedule> Tselect(VCourseSchedule vCS);
}
