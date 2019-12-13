package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.VTeachTask;

public interface TeachTaskInterface {
	
	boolean insert(TeachTask task);
	boolean delete(TeachTask task);
	List<VTeachTask> select(TeachTask teachtask);
	List<VTeachTask> ArrangeSelect(TeachTask teachtask);

}
