package com.qyc.OneProject.Model;

public class Profession {

	private String ProfessionID;
	private String ProfessionName;
	private Department department;
	private String Remark;
	public String getProfessionID() {
		return ProfessionID;
	}
	public void setProfessionID(String professionID) {
		ProfessionID = professionID;
	}
	public String getProfessionName() {
		return ProfessionName;
	}
	public void setProfessionName(String professionName) {
		ProfessionName = professionName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}

	
}
