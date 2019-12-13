package com.qyc.newsProject.action;

import java.io.IOException;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.qyc.newsProject.service.NTypeService;
import com.qyc.newsProject.util.util;

public class NTypeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8815929379618225525L;
	private NTypeService iNTypeService;
	
	public void nTypeInfo() throws IOException{
		JSONArray json=JSONArray.fromObject(iNTypeService.select());
		util.writ(json);
	}
	
	public NTypeService getiNTypeService() {
		return iNTypeService;
	}
	public void setiNTypeService(NTypeService iNTypeService) {
		this.iNTypeService = iNTypeService;
	}
	

}
