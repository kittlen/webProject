package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.ClassRoom;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.ClassRoomInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

public class ClassRoomAction implements ModelDriven<ClassRoom> {
	private ClassRoom classRoom = new ClassRoom();
	iHibernatedao hb = new Hibernatedao();
	ClassRoomInterface iCR = SchoolFactory.ClassRoomInterFace();

	public String insert() {
		iCR.insert(classRoom);
		return "success";
	}

	public String update() {
		iCR.update(classRoom);
		return "success";
	}

	public String delete() {
		iCR.delete(classRoom);
		return "success";
	}
	
	public void ClassRoomNameInfo() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<ClassRoom> list = iCR.Nameselect(classRoom);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
	
	public void ClassRoomInfo() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<ClassRoom> list = iCR.select();
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	@Override
	public ClassRoom getModel() {
		// TODO Auto-generated method stub
		return classRoom;
	}

}
