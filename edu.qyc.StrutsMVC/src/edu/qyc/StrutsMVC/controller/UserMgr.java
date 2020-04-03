package edu.qyc.StrutsMVC.controller;

import com.opensymphony.xwork2.ModelDriven;

import edu.qyc.StrutsMVC.Mode.User;

public class UserMgr implements ModelDriven<User>{
	
	private User user=new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
	public String add(){
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		return "useradd";
	}
	

}
