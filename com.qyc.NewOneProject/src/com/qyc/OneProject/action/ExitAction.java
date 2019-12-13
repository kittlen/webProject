package com.qyc.OneProject.action;

import com.opensymphony.xwork2.ActionContext;

public class ExitAction {
	
	public String AdminExit(){
		ActionContext.getContext().getSession().put("login", null);
		return "success";
		
	}
	
	public String StudentExit(){
		ActionContext.getContext().getSession().put("Slogin", null);
		return "success";
		
	}
	public String TeacherExit(){
		ActionContext.getContext().getSession().put("Tlogin", null);
		return "success";
		
	}

}
