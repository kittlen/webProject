package com.qyc.springdemo.Action;

import com.qyc.springdemo.mode.User;

public class UserAction {
	// ע�뷽��һ��
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*// ע�뷽����
	public UserAction(User user) {
		super();
		this.user = user;
	}*/

	public void print() {
		System.out.println(user.getName());
	}

}
