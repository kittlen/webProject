package com.qyc.OneProject.Model;

public class Department {
	private String DepartmentID;
	private String DepartmentName;
	private College college;
	private String Remark;
	public String getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
