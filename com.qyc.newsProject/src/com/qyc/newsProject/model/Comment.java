package com.qyc.newsProject.model;

public class Comment {
	private int cID;
	private String context;
	private User user;
	private Notice notice;
	private String time;
	private int heat;
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getHeat() {
		return heat;
	}
	public void setHeat(int heat) {
		this.heat = heat;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	

}
