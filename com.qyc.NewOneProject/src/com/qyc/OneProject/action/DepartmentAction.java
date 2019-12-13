package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Department;
import com.qyc.OneProject.sevice.DepartmentInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

public class DepartmentAction implements ModelDriven<Department>{

	private Department dep=new Department();
	DepartmentInterface idep=SchoolFactory.DepartmentInterFace();
	
	public String insert(){
		idep.insert(dep);
		return "success";
	}
	public String update(){
		idep.update(dep);
		return "success";
	}
	public String delete(){
		idep.delete(dep);
		return "success";
	}
	public void DepartmentInfo() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		List<Department> list=idep.select(request.getParameter("CollegeID"));
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
	
	
	
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return dep;
	}

}
