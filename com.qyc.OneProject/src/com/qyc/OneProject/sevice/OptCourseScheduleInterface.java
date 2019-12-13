package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.VOptCourseSchedule;

public interface OptCourseScheduleInterface {

	List<VOptCourseSchedule> select(String Stu_ID);

	boolean delete(String CourseScheduleID);

	List<VOptCourseSchedule> Tselect(String teacherID, String course);

	List<VOptCourseSchedule> Sselect(String Stu_ID);

	List<VOptCourseSchedule> TSselect(String Stu_ID);

}
