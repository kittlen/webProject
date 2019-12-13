package com.qyc.OneProject.Model;

public class Class {
	
	private String Class_ID;
	private String GradeName;
	private String YearName;
	private Profession profession;
	private String Remark;
	public String getClass_ID() {
		return Class_ID;
	}
	public void setClass_ID(String class_ID) {
		Class_ID = class_ID;
	}
	public String getGradeName() {
		return GradeName;
	}
	public void setGradeName(String gradeName) {
		GradeName = gradeName;
	}
	public String getYearName() {
		return YearName;
	}
	public void setYearName(String yearName) {
		YearName = yearName;
	}
	
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
