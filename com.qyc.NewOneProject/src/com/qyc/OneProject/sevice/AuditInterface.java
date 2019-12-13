package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.VTeachTask;

public interface AuditInterface {

	List<VTeachTask> select(TeachTask teachTask);
	boolean update(TeachTask teachTask, Admin admin);
}
