package com.qyc.newsProject.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;

import com.qyc.newsProject.model.Comment;
import com.qyc.newsProject.model.Notice;
import com.qyc.newsProject.service.CommentsService;
import com.qyc.newsProject.util.util;

public class CommentsAction {
	
	private CommentsService iCommentsService;
	private Comment comment;
	private Notice notice;
	//发表评论
	public void addComment(){
		iCommentsService.save(comment);
	}
	//热能评论
	public void CommentInfo() throws IOException{
		List<Comment> list=iCommentsService.CommentInfo(notice);
		util.writ(JSONArray.fromObject(list));
	}
	//前50条评论
	public void allComment() throws IOException{
		List<Comment> list=iCommentsService.allComment(notice);
		util.writ(JSONArray.fromObject(list));
	}

	public CommentsService getiCommentsService() {
		return iCommentsService;
	}

	public void setiCommentsService(CommentsService iCommentsService) {
		this.iCommentsService = iCommentsService;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}

}
