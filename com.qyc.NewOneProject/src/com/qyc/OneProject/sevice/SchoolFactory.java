package com.qyc.OneProject.sevice;

import com.qyc.OneProject.impl.ClassInImpl;
import com.qyc.OneProject.impl.ClassRoomInImpl;
import com.qyc.OneProject.impl.CollegeInImpl;
import com.qyc.OneProject.impl.CourseInImpl;
import com.qyc.OneProject.impl.CourseScheduleInImpl;
import com.qyc.OneProject.impl.DepartmentInImpl;
import com.qyc.OneProject.impl.NoticeInImpl;
import com.qyc.OneProject.impl.ProfessionInImpl;
import com.qyc.OneProject.impl.ScheduleInImpl;
import com.qyc.OneProject.impl.StudentInImpl;
import com.qyc.OneProject.impl.TeachTaskInImpl;
import com.qyc.OneProject.impl.TeacherInImpl;
import com.qyc.OneProject.impl.OptCourseScheduleInImpl;


public class SchoolFactory {

	public static CollegeInterface CollegeInterFace() {
		// TODO Auto-generated method stub
		return new CollegeInImpl();
	}

	public static DepartmentInterface DepartmentInterFace(){
		return new DepartmentInImpl();
	}
	
	public static ProfessionInterface ProfessionInterFace(){
		return new ProfessionInImpl();
	}
	
	public static ClassInterface ClassInterFace(){
		return new ClassInImpl();
	}
	
	public static StudentInterface StudentInterFace(){
		return new StudentInImpl();
	}
	
	public static CourseInterface CourseInterFace(){
		return new CourseInImpl();
	}
	
	public static TeacherInterface TeacherInterFace(){
		return new TeacherInImpl();
	}
	
	public static ClassRoomInterface ClassRoomInterFace(){
		return new ClassRoomInImpl();
	}
	
	public static TeachTaskInterface TeachTaskInterFace() {
		return new TeachTaskInImpl();
		
	}
	public static ScheduleInterface ScheduleInterFace(){
		return new ScheduleInImpl();
	}
	public static CourseScheduleInterface CourseScheduleInterFace(){
		return new CourseScheduleInImpl();
	}
	public static OptCourseScheduleInterface OptCourseScheduleInterFace(){
		return new OptCourseScheduleInImpl();
	}
	public static NoticeInterface NoticeInterFace(){
		return new NoticeInImpl();
	}

}
