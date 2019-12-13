package com.qyc.OneProject.Model;

public class Schedule {
	private int ID;
	private int TeachTaskID;
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
	public int getTeachTaskID() {
		return TeachTaskID;
	}
	public void setTeachTaskID(int teachTaskID) {
		TeachTaskID = teachTaskID;
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
