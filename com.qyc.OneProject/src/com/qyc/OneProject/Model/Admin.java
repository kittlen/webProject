package com.qyc.OneProject.Model;

import java.security.NoSuchAlgorithmException;

import com.qyc.OneProject.util.util;

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
		try {
			Password = util.UseMD5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
