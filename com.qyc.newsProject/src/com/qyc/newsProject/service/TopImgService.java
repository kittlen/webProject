package com.qyc.newsProject.service;

import java.util.List;

import com.qyc.newsProject.model.TopImg;


public interface TopImgService {
	
	boolean save(TopImg topImg);
	List<TopImg> topImgInfo();
}
