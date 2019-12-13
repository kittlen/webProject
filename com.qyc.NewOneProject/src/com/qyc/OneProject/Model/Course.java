package com.qyc.OneProject.Model;

public class Course {

	private String CourseID;
	private String Course;
	private Profession profession;
	private int StudyTime;
	private float Crediy;
	private String CurriculumTime;
	private String Remark;
	private String state;//用于教师选课
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public int getStudyTime() {
		return StudyTime;
	}
	public void setStudyTime(int studyTime) {
		StudyTime = studyTime;
	}
	public float getCrediy() {
		return Crediy;
	}
	public void setCrediy(float crediy) {
		Crediy = crediy;
	}
	public String getCurriculumTime() {
		return CurriculumTime;
	}
	public void setCurriculumTime(String curriculumTime) {
		CurriculumTime = curriculumTime;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
