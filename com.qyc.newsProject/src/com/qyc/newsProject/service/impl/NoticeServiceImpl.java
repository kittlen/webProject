package com.qyc.newsProject.service.impl;

import java.io.Serializable;
import java.util.List;

import com.qyc.newsProject.dao.NoticeDao;
import com.qyc.newsProject.model.Notice;
import com.qyc.newsProject.model.User;
import com.qyc.newsProject.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao;

	@Override
	public boolean save(Notice notice) {
		// TODO Auto-generated method stub
		Serializable sl = noticeDao.save(notice);
		if (sl != null) {
			return true;
		}
		return false;

	}

	@Override
	public List<Notice> noticeInfo(int index) {
		// TODO Auto-generated method stub
		String HQL = " from Notice no where no.audit='审核通过' order by no.releaseTime desc";
		List<Notice> list = noticeDao.selectPage(HQL, 3, index);
		return list;
	}

	@Override
	public Notice noticecont(Notice notice) {
		// TODO Auto-generated method stub
		Notice thisNotice = noticeDao.getObj(Notice.class, notice.getnID());
		return thisNotice;
	}

	@Override
	public List<Notice> noticeListInfo(User user) {
		// TODO Auto-generated method stub
		String HQL = "from Notice no where no.user.uID=? and no.audit='审核通过' order by no.releaseTime desc";
		Object[] parmas = { user.getuID() };
		List<Notice> list = noticeDao.select(HQL, parmas);
		return list;
	}

	@Override
	public List<Notice> noticeTypeInfo(String typeIndex, int index) {
		// TODO Auto-generated method stub
		String HQL = "from Notice no where no.nType.nTID=? and no.audit='审核通过'";
		Object[] parmas = { typeIndex };
		List<Notice> list = noticeDao.selectPage(HQL, parmas, 3, index);
		return list;
	}

	@Override
	public void delete(Notice notice) {
		// TODO Auto-generated method stub
		noticeDao.delete(notice);
	}

	@Override
	public List<Notice> seachInfo(String seatext) {
		// TODO Auto-generated method stub
		String HQL = "from Notice no where (no.noticeTitle like ? or no.noticeContent like ? or no.noticeBrief like ?) "
				+ "and no.audit='审核通过' order by no.heat desc,no.releaseTime desc";
		Object[] parmas = { "%" + seatext + "%", "%" + seatext + "%",
				"%" + seatext + "%" };
		List<Notice> list = noticeDao.selectPage(HQL, parmas, 50, 1);
		return list;
	}
	@Override
	public List<Notice> auditInfo() {
		// TODO Auto-generated method stub
		String HQL = "from Notice no where no.audit='未审核' or no.audit=''";
		List<Notice> list=noticeDao.select(HQL);
		return list;
	}
	
	@Override
	public void auditup(Notice notice) {
		// TODO Auto-generated method stub
		Notice thisnNotice=noticeDao.getObj(Notice.class, notice.getnID());
		thisnNotice.setAudit(notice.getAudit());
		noticeDao.update(thisnNotice);
	}


	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	
	

}
