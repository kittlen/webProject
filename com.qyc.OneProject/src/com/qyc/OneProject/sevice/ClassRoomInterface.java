package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.ClassRoom;


public interface ClassRoomInterface {

	boolean insert(ClassRoom claRo);
	boolean update(ClassRoom claRo);
	boolean delete(String ID);
	List<ClassRoom> select();
	List<ClassRoom> Nameselect(String ClassRoomCategory);
}
