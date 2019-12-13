package com.qyc.OneProject.Model;


public class Admin {

	private String AdminID;
	private String AdminName;
	private String Password;
	private String power;
	private String Photo;
	private String Remark;
	
	public String getAdminID() {
		return AdminID;
	}
	public void setAdminID(String adminID) {
		AdminID = adminID;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	
	
}
