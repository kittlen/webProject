package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.sevice.TeacherInterface;

public class TeacherAction implements ModelDriven<Teacher> {
	private Teacher tea = new Teacher();
	private String err;
	private String pd;

	TeacherInterface itea = SchoolFactory.TeacherInterFace();

	public String Login() {
		Teacher thisTeacher = itea.login(tea);
		if (thisTeacher != null) {
			ActionContext.getContext().getSession().put("Tlogin", thisTeacher);
			return "success";
		} else {
			setErr("账号或密码错误");
			return "error";
		}
	}

	public String insert() {
		itea.insert(tea);
		return "success";
	}

	public String update() {
		itea.update(tea);
		return "success";
	}

	public String delete() {
		itea.delete(tea);
		return "success";
	}

	// 密码重置
	public String reset() {
		tea.setPassword("123456");
		itea.UpdatePwd(tea);
		return "success";
	}

	public void teacherInfo() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Teacher> list = itea.select(request.getParameter("CollegeID"));
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	// 个人基本信息修改
	public String updateIn() {
		Teacher thisTea=itea.UpdateIn(tea);
		if (thisTea!=null) {
			ActionContext.getContext().getSession().put("Tlogin", thisTea);
		}
		return "success";
	}

	// 密码修改
	public String updatePwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String PastPassword = request.getParameter("PastPassword");// 旧密码
		String NewPassword = request.getParameter("NewPassword");// 新密码
		tea.setPassword(PastPassword);
		Teacher thisTea = null;
		thisTea = itea.login(tea);
		if (thisTea != null) {
			thisTea.setPassword(NewPassword);
			itea.UpdatePwd(thisTea);
			request.getSession().setAttribute("Slogin", thisTea);
			setPd("true");
		} else {
			setPd("false");
		}
		return "success";
	}

	@Override
	public Teacher getModel() {
		// TODO Auto-generated method stub
		return tea;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public String getPd() {
		return pd;
	}

	public void setPd(String pd) {
		this.pd = pd;
	}

}
