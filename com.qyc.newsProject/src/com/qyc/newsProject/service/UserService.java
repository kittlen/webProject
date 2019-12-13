package com.qyc.newsProject.service;

import com.qyc.newsProject.model.User;

public interface UserService {

	User save(User user);
	User login(User user);
	void update(User user);
	void updatePwd(User user);
	void updatePhoto(User user);
}
