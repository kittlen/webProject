package com.qyc.OneProject.Model;

public class Audit {
	private int ID;
	private TeachTask TeachTask;
	private String AuditDate;
	private Admin Admin;
	private String Remark;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public TeachTask getTeachTask() {
		return TeachTask;
	}
	public void setTeachTask(TeachTask teachTask) {
		TeachTask = teachTask;
	}
	public String getAuditDate() {
		return AuditDate;
	}
	public void setAuditDate(String auditDate) {
		AuditDate = auditDate;
	}
	public Admin getAdmin() {
		return Admin;
	}
	public void setAdmin(Admin admin) {
		Admin = admin;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	

}
