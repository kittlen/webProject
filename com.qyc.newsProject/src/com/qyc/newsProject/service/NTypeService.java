package com.qyc.newsProject.service;

import java.util.List;

import com.qyc.newsProject.model.NType;



public interface NTypeService {
	/**
	 * ��ȡ��������
	 * @return
	 */
	List<NType> select();
	
	/*User save(User user);
	User login(User user);
	void update(User user);
	void updatePwd(User user);*/
}
