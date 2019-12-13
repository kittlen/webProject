package com.qyc.newsProject.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.qyc.newsProject.dao.UserDao;
import com.qyc.newsProject.model.Power;
import com.qyc.newsProject.model.User;
import com.qyc.newsProject.service.UserService;
import com.qyc.newsProject.util.util;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private Power power;
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		try {
			User serUser=userDao.getObj(User.class, user.getuID());
			if(serUser!=null){
				return null;
			}
			user.setPassword(util.UseMD5(user.getPassword()));
			power.setpID("0");
			user.setPower(power);
			user.setPhone(0);
			user.setPhoto(user.getuID());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPhoto(user.getuID());
		if(userDao.save(user)!=null){
			return user;
		}
		return null;
		
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		try {
			String HQL="from User us where us.uID=? and us.password=?";
			Object [] parmas={user.getuID(),util.UseMD5(user.getPassword())};
			List<User> list=userDao.select(HQL, parmas);
			if(list.size()>0){
				return list.get(0);
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		User thisUser=userDao.getObj(User.class, user.getuID());
		thisUser.setName(user.getName());
		thisUser.setPhone(user.getPhone());
		thisUser.setRemark(user.getRemark());
		userDao.update(thisUser);
		ActionContext.getContext().getSession().put("login", thisUser);
	}
	
	@Override
	public void updatePwd(User user) {
		// TODO Auto-generated method stub
		try {
			user.setPassword(util.UseMD5(user.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userDao.update(user);
		ActionContext.getContext().getSession().put("login", user);
	}
	@Override
	public void updatePhoto(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
		ActionContext.getContext().getSession().put("login", user);
	}
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	

	
}
