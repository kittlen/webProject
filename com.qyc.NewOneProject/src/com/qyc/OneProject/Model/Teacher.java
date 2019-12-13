package com.qyc.OneProject.Model;


public class Teacher {

	private String TeacherID;
	private String Name;
	private College College;
	private String Sex;
	private String Birthday;
	private String Kulture;
	private String Phone;
	private String Home;
	private String Photo;
	private String Password;
	private String Remark;

	public String getTeacherID() {
		return TeacherID;
	}

	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}
	
	public College getCollege() {
		return College;
	}

	public void setCollege(College college) {
		College = college;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getKulture() {
		return Kulture;
	}

	public void setKulture(String kulture) {
		Kulture = kulture;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getHome() {
		return Home;
	}

	public void setHome(String home) {
		Home = home;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

}
