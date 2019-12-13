package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.Model.VTeachTask;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.sevice.TeachTaskInterface;
import com.qyc.OneProject.util.util;

public class TeachTaskAction implements ModelDriven<TeachTask>{
	private TeachTask teachtask=new TeachTask();
	TeachTaskInterface itt=SchoolFactory.TeachTaskInterFace();
	
	public String insert(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Teacher teacher=(Teacher) request.getSession().getAttribute("Tlogin");
		teachtask.setTeacher(teacher);
		teachtask.setCurricula(util.getNewSemester());
		teachtask.setAuditing("Œ¥…Û∫À");
		itt.insert(teachtask);
		return "success";
	}
	
	public String delete(){
		HttpServletRequest request=ServletActionContext.getRequest();
		Teacher teacher=(Teacher) request.getSession().getAttribute("Tlogin");
		teachtask.setTeacher(teacher);
		itt.delete(teachtask);
		return "success";
	}
	
	//ø™øŒ≤È—Ø
	public void TeachTaskInfo() throws IOException {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Teacher teacher=(Teacher) request.getSession().getAttribute("Tlogin");
		teachtask.setTeacher(teacher);
		teachtask.setCurricula("%"+teachtask.getCurricula()+"%");
		List<VTeachTask> list = itt.select(teachtask);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
	
	//øŒ±Ì≈‰÷√
	public void ArrangeSelect() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Teacher teacher=(Teacher) request.getSession().getAttribute("Tlogin");
		teachtask.setTeacher(teacher);
		teachtask.setAuditing("…Û∫ÀÕ®π˝");
		teachtask.setCurricula(util.getNewSemester());
		List<VTeachTask> list = itt.ArrangeSelect(teachtask);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
	@Override
	public TeachTask getModel() {
		// TODO Auto-generated method stub
		return teachtask;
	}
	

}
