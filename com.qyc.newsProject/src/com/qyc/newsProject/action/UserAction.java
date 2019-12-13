package com.qyc.newsProject.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qyc.newsProject.model.User;
import com.qyc.newsProject.service.UserService;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5492128347957636927L;
	private User user;
	private UserService iUserService;
	private String lo;// ×¢²á
	private String la;// µÇÂ½
	private String newPassword;//ÐÂÃÜÂë
	private String er;//ÃÜÂëÐÞ¸Ä
	private String ur;//ÐÅÏ¢ÐÞ¸Ä

	// ×¢²á
	public String enroll() {
		User thisUser = iUserService.save(user);
		if (thisUser != null) {
			ActionContext.getContext().getSession().put("login", thisUser);
			setLo("1");
		} else {
			setLo("0");
		}
		return "success";
	}

	// µÇÂ½
	public String landing() {
		User thisUser = iUserService.login(user);
		if (thisUser != null) {
			ActionContext.getContext().getSession().put("login", thisUser);
			setLa("1");
		} else {
			setLa("0");
		}
		return "success";
	}

	// ÐÞ¸Ä
	public String update() {
		user.setuID(((User) ServletActionContext.getRequest().getSession()
				.getAttribute("login")).getuID());
		iUserService.update(user);
		setUr("1");
		return "success";
	}
	public String updatePwd(){
		user.setuID(((User) ServletActionContext.getRequest().getSession()
				.getAttribute("login")).getuID());
		User thisUser=iUserService.login(user);
		if(thisUser==null){
			setEr("0");
		}else {
			thisUser.setPassword(newPassword);
			iUserService.updatePwd(thisUser);
			setEr("1");
		}
		return "success";
	}

	// ÍË³ö
	public String exit() {
		ServletActionContext.getRequest().getSession()
				.setAttribute("login", null);
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(UserService iUserService) {
		this.iUserService = iUserService;
	}

	public String getLo() {
		return lo;
	}

	public void setLo(String lo) {
		this.lo = lo;
	}

	public String getLa() {
		return la;
	}

	public void setLa(String la) {
		this.la = la;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getEr() {
		return er;
	}

	public void setEr(String er) {
		this.er = er;
	}

	public String getUr() {
		return ur;
	}

	public void setUr(String ur) {
		this.ur = ur;
	}

}
