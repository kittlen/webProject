package com.qyc.newsProject.service;

import java.util.List;

import com.qyc.newsProject.model.Notice;
import com.qyc.newsProject.model.User;



public interface NoticeService {
	
	boolean save(Notice notice);
	List<Notice> noticeInfo(int index);
	Notice noticecont(Notice notice);
	List<Notice> noticeListInfo(User user);
	void delete(Notice notice);
	List<Notice> noticeTypeInfo(String typeIndex, int index);
	List<Notice> seachInfo(String seatext);
	List<Notice> auditInfo();
	void auditup(Notice notice);
	
}
