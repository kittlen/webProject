package edu.qyc.StrutsMVC.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import edu.qyc.StrutsMVC.Mode.User;

public class StudentAction {
	private String name;
	private JSONArray jsonString;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public JSONArray getJsonString() {
		return jsonString;
	}

	public void setJsonString(JSONArray jsonString) {
		this.jsonString = jsonString;
	}

	public String add(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("req", name);
		ActionContext.getContext().getSession().put("ses", name);
		ActionContext.getContext().getApplication().put("appl", "appl");
		return Action.SUCCESS;
		
	}
	public void select() throws IOException{
		List<User> list=new ArrayList<User>();
		for(int i=0;i<10;i++){
			User user=new User();
			user.setName("李"+i);
			user.setPassword(String.valueOf(123+i));
			user.setRemark("i");
			list.add(user);
		}
		JSONArray json=JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
	public String select2(){
		List<User> list=new ArrayList<User>();
		for(int i=0;i<10;i++){
			User user=new User();
			user.setName("张"+i);
			user.setPassword(String.valueOf(123+i));
			user.setRemark("i");
			list.add(user);
		}
		JSONArray json=JSONArray.fromObject(list);
		jsonString=json;
		return "StudentJson";
		
	}

	

}
