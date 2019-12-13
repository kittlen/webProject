package com.qyc.newsProject.model;


public class Notice {
	private int nID;
	private NType nType;
	private User user;
	private String noticeTitle;
	private String noticeContent;
	private String noticeBrief;
	private String noticephoto1;
	private String noticephoto2;
	private String noticephoto3;
	private String releaseTime;
	private int heat;
	private String audit;
	
	public int getnID() {
		return nID;
	}
	public void setnID(int nID) {
		this.nID = nID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public int getHeat() {
		return heat;
	}
	public void setHeat(int heat) {
		this.heat = heat;
	}
	public NType getnType() {
		return nType;
	}
	public void setnType(NType nType) {
		this.nType = nType;
	}
	public String getNoticeBrief() {
		return noticeBrief;
	}
	public void setNoticeBrief(String noticeBrief) {
		this.noticeBrief = noticeBrief;
	}
	public String getNoticephoto1() {
		return noticephoto1;
	}
	public void setNoticephoto1(String noticephoto1) {
		this.noticephoto1 = noticephoto1;
	}
	public String getNoticephoto2() {
		return noticephoto2;
	}
	public void setNoticephoto2(String noticephoto2) {
		this.noticephoto2 = noticephoto2;
	}
	public String getNoticephoto3() {
		return noticephoto3;
	}
	public void setNoticephoto3(String noticephoto3) {
		this.noticephoto3 = noticephoto3;
	}
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	

}
