package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.VOptCourseSchedule;

public interface OptCourseScheduleInterface {

	List<VOptCourseSchedule> select(Student student);

	boolean delete(VOptCourseSchedule vOpC);

	List<VOptCourseSchedule> TSselect(Student student);

	List<VOptCourseSchedule> Tselect(VOptCourseSchedule vOpC);

}
