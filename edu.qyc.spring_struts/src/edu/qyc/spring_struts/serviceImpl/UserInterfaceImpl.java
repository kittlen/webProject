package edu.qyc.spring_struts.serviceImpl;

import edu.qyc.spring_struts.mode.User;
import edu.qyc.spring_struts.service.UserInterface;

public class UserInterfaceImpl implements UserInterface{

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getName());
		
	}

}
