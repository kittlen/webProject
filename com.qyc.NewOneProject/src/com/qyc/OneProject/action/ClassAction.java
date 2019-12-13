package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Class;
import com.qyc.OneProject.sevice.ClassInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

public class ClassAction implements ModelDriven<Class> {
	private Class cla = new Class();

	ClassInterface icla = SchoolFactory.ClassInterFace();

	public String insert() {
		icla.insert(cla);
		return "success";
	}

	public String update() {
		icla.update(cla);
		return "success";
	}

	public String delete() {
		icla.delete(cla);
		return "success";
	}

	public void ClassInfo() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Class> list = icla.select(request.getParameter("ProfessionID"));
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	@Override
	public Class getModel() {
		// TODO Auto-generated method stub
		return cla;
	}

}
