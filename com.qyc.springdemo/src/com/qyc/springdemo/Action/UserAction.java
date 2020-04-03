package com.qyc.springdemo.Action;

import com.qyc.springdemo.mode.User;

public class UserAction {
	// 注入方法一二
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*// 注入方法三
	public UserAction(User user) {
		super();
		this.user = user;
	}*/

	public void print() {
		System.out.println(user.getName());
	}

}
