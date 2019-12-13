package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.College;

public interface CollegeInterface {

	boolean insert(College coll);
	boolean update(College coll);
	boolean delete(String id);
	List<College> select();
	
	
}
