package com.qyc.OneProject.Model;

import java.security.NoSuchAlgorithmException;

import com.qyc.OneProject.util.util;

public class Student {

	private String Stu_ID;
	private String Name;
	private String Sex;
	private String Birth;
	private Class TClass;
	private String Phone;
	private String Family;
	private String Photo;
	private String Password;
	private String Remark;
	public String getStu_ID() {
		return Stu_ID;
	}
	public void setStu_ID(String stu_ID) {
		Stu_ID = stu_ID;
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
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getBirth() {
		return Birth;
	}
	public void setBirth(String birth) {
		Birth = birth;
	}
	public Class getTClass() {
		return TClass;
	}
	public void setTClass(Class tClass) {
		TClass = tClass;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getFamily() {
		return Family;
	}
	public void setFamily(String family) {
		Family = family;
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
		try {
			Password = util.UseMD5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
