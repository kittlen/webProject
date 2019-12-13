package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.VTeachTask;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.AdminFactory;
import com.qyc.OneProject.sevice.AuditInterface;

public class AuditAction implements ModelDriven<TeachTask> {
	private TeachTask teachTask=new TeachTask();
	iHibernatedao hb = new Hibernatedao();
	AuditInterface iAud=AdminFactory.AuditInterFace();

	//π‹¿Ì‘±…Û∫À
	public String update() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Admin admin=(Admin) request.getSession().getAttribute("login");
		iAud.update(teachTask,admin);
		return "success";
	}

	public void AuditInfo() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<VTeachTask> list = iAud.select(teachTask);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	@Override
	public  TeachTask getModel() {
		// TODO Auto-generated method stub
		return teachTask;
	}

}
