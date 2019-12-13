package com.qyc.OneProject.Model;

public class TeachTask {

	private int ID;
	private Teacher teacher;
	private Course course;
	private String Curricula;
	private String Auditing;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getCurricula() {
		return Curricula;
	}
	public void setCurricula(String curricula) {
		Curricula = curricula;
	}
	public String getAuditing() {
		return Auditing;
	}
	public void setAuditing(String auditing) {
		Auditing = auditing;
	}

	
}
