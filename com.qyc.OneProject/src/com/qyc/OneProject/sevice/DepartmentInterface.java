package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Department;

public interface DepartmentInterface {
	boolean insert(Department dep);
	boolean update(Department dep);
	boolean delete(String DepartmentID);
	List<Department> select(String CollegeID);
}
