package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Profession;

public interface ProfessionInterface {

	boolean insert(Profession pro);
	boolean update(Profession pro);
	boolean delete(Profession pro);
	List<Profession> select(String DepartmentID);
}
