package edu.qyc.spring_struts.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.qyc.spring_struts.mode.User;
import edu.qyc.spring_struts.service.UserInterface;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private User user;
	private UserInterface userInterface;

	public String insert() {
		userInterface.insert(user);
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserInterface getUserInterface() {
		return userInterface;
	}

	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}

}
