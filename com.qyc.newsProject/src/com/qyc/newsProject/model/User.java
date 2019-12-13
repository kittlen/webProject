package com.qyc.newsProject.model;

public class User {
	private String uID;
	private String name;
	private String password;
	private int phone;
	private String photo;
	private String photoType;
	private String remark;
	private Power power;
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	
	
}
