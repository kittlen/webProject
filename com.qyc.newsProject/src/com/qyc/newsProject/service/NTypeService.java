package com.qyc.newsProject.service;

import java.util.List;

import com.qyc.newsProject.model.NType;



public interface NTypeService {
	/**
	 * 获取新闻类型
	 * @return
	 */
	List<NType> select();
	
	/*User save(User user);
	User login(User user);
	void update(User user);
	void updatePwd(User user);*/
}
