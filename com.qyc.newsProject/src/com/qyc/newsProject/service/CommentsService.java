package com.qyc.newsProject.service;

import java.util.List;

import com.qyc.newsProject.model.Comment;
import com.qyc.newsProject.model.Notice;

public interface CommentsService {
	
	boolean save(Comment comment);
	List<Comment> CommentInfo(Notice notice);
	List<Comment> allComment(Notice notice);
	
}
