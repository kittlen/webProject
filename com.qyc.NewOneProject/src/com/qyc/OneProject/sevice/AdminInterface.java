package com.qyc.OneProject.sevice;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.qyc.OneProject.Model.Admin;

public interface AdminInterface {

	Admin login(Admin admin) throws NoSuchAlgorithmException;
	boolean insert(Admin admin) throws NoSuchAlgorithmException;
	boolean update(Admin admin);
	boolean delete(Admin admin);
	boolean UpdatePwd(Admin admin);
	List<Admin> select();
	Admin UpdateIn(Admin admin);
}
