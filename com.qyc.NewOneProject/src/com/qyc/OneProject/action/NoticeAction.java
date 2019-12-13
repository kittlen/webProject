package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.Model.Notice;
import com.qyc.OneProject.sevice.NoticeInterface;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.util.util;

public class NoticeAction implements ModelDriven<Notice> {

	private Notice notice = new Notice();
	NoticeInterface iNI = SchoolFactory.NoticeInterFace();

	public String insert() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Admin admin = (Admin) request.getSession().getAttribute("login");
		notice.setAdmin(admin);
		notice.setReleaseTime(util.getNowDetailedTime());
		if (iNI.insert(notice)) {
			request.getSession().setAttribute("AdInsert", "true");
		} else {
			request.getSession().setAttribute("AdInsert", "false");
		}
		return "success";
	}

	public void NoticeInfo() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Notice> list = iNI.select();
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	public String Noselect() {
		Notice thisNotice = iNI.Noselect(notice);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("notice", thisNotice);
		String user = request.getParameter("user");
		if (user.equals("A")) {
			return "Asuccess";
		} else if (user.equals("S")) {
			return "Ssuccess";
		} else {
			return "Tsuccess";
		}
	}

	public String delete() {
		iNI.delete(notice);
		return "success";
	}

	@Override
	public Notice getModel() {
		// TODO Auto-generated method stub
		return notice;
	}

}
