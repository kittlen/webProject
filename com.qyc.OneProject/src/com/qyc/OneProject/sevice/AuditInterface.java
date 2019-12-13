package com.qyc.OneProject.sevice;

import java.util.List;

import com.qyc.OneProject.Model.Audit;
import com.qyc.OneProject.Model.VTeachTask;

public interface AuditInterface {

	List<VTeachTask> select(String Curricula);
	boolean insert(Audit audit, String Auditing);
}
