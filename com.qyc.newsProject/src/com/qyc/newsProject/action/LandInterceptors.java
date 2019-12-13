package com.qyc.newsProject.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LandInterceptors extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8154590752727675444L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		if(ServletActionContext.getRequest().getSession().getAttribute("login")!=null){
			return arg0.invoke();
		}
		return "Land";
	}

}
