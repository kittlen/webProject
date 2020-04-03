package edu.qyc.StrutsMVC.controller;

import edu.qyc.StrutsMVC.Mode.User;

public class UserMgr2 {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String add(){
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		return "useradd";
	}
	public String useradd(){
		return "userde";
	}
	

}
