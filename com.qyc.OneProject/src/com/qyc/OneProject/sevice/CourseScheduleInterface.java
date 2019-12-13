package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.CourseSchedule;
import com.qyc.OneProject.Model.VCourseSchedule;

public interface CourseScheduleInterface {
	List<VCourseSchedule> select(String ProfessionID);
	boolean insert(CourseSchedule courseSchedule);
	boolean Cselect(CourseSchedule courseSchedule);
	boolean update(CourseSchedule courseSchedule);
	List<VCourseSchedule> Tselect(String TeacherID,String CourseID);
	boolean delete(String scheduleID);
	List<VCourseSchedule> TTselect(String teacherID);
}
