package com.qyc.newsProject.service.impl;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.qyc.newsProject.dao.CommentsDao;
import com.qyc.newsProject.model.Comment;
import com.qyc.newsProject.model.Notice;
import com.qyc.newsProject.model.User;
import com.qyc.newsProject.service.CommentsService;
import com.qyc.newsProject.util.util;

public class CommentsServiceImpl implements CommentsService {

	private CommentsDao commentsDao;

	@Override
	public boolean save(Comment comment) {
		// TODO Auto-generated method stub
		comment.setHeat(0);
		comment.setUser((User) ServletActionContext.getRequest().getSession()
				.getAttribute("login"));
		comment.setTime(util.getNowDetailedTime());
		if (commentsDao.save(comment) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Comment> CommentInfo(Notice notice) {
		// TODO Auto-generated method stub
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("login");
		String HQL = "";
		if (user != null) {
			HQL = "from Comment com where com.user.uID=? and com.notice.nID=? order by com.time desc";
			Object[] parmas = { user.getuID(), notice.getnID() };
			List<Comment> list = commentsDao.selectPage(HQL, parmas, 3, 1);
			HQL = "from Comment com where com.notice.nID=? and com.user.uID<>? order by com.heat desc,com.time desc";
			Object[] parmas2 = { notice.getnID(), user.getuID() };
			List<Comment> list2 = commentsDao.selectPage(HQL, parmas2, 3, 1);
			list.addAll(list2);
			return list;
		} else {
			HQL = "from Comment com where com.notice.nID=? order by com.heat desc,com.time desc";
			Object[] parmas = { notice.getnID() };
			List<Comment> list = commentsDao.selectPage(HQL, parmas, 3, 1);
			return list;
		}

	}
	@Override
	public List<Comment> allComment(Notice notice) {
		// TODO Auto-generated method stub
		String HQL = "from Comment com where com.notice.nID=? order by com.heat desc,com.time desc";
		Object[] parmas = { notice.getnID() };
		List<Comment> list = commentsDao.selectPage(HQL, parmas, 50, 1);
		return list;
	}
	public CommentsDao getCommentsDao() {
		return commentsDao;
	}

	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}

	

}
