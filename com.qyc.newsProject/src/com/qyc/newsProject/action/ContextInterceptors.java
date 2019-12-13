package com.qyc.newsProject.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ContextInterceptors extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 821778890959244494L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		if(ServletActionContext.getRequest().getSession().getAttribute("noticeCont")!=null){
			arg0.invoke();
		}
		return "index";
	}


}
