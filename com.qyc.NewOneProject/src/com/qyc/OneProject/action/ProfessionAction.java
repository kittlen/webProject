package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Profession;
import com.qyc.OneProject.sevice.ProfessionInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

public class ProfessionAction implements ModelDriven<Profession>{
	private Profession pro=new Profession();

	ProfessionInterface ipro=SchoolFactory.ProfessionInterFace();
	
	public String insert(){
		ipro.insert(pro);
		return "success";
	}
	public String update(){
		ipro.update(pro);
		return "success";
	}
	public String delete(){
		ipro.delete(pro);
		return "success";
	}
	public void ProfessionInfo() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		List<Profession> list=ipro.select(request.getParameter("DepartmentID"));
		
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
	
	
	@Override
	public Profession getModel() {
		// TODO Auto-generated method stub
		return pro;
	}

}
