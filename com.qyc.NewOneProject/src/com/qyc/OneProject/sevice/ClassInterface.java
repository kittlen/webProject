package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Class;

public interface ClassInterface {

	boolean insert(Class cla);
	boolean update(Class cla);
	boolean delete(Class cla);
	List<Class> select(String ProfessionID);
}
