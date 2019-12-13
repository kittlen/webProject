package com.qyc.OneProject.Model;

public class Schedule {
	private int ID;
	private TeachTask teachTask;
	private String ClassRoomID;
	private String ClassTime;
	private String Classfestival;
	private String Remark;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public TeachTask getTeachTask() {
		return teachTask;
	}
	public void setTeachTask(TeachTask teachTask) {
		this.teachTask = teachTask;
	}
	public String getClassRoomID() {
		return ClassRoomID;
	}
	public void setClassRoomID(String classRoomID) {
		ClassRoomID = classRoomID;
	}
	public String getClassTime() {
		return ClassTime;
	}
	public void setClassTime(String classTime) {
		ClassTime = classTime;
	}
	public String getClassfestival() {
		return Classfestival;
	}
	public void setClassfestival(String classfestival) {
		Classfestival = classfestival;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
