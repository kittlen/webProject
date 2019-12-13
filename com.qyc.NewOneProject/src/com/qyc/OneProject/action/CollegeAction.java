package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.College;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.CollegeInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

public class CollegeAction implements ModelDriven<College> {
	private College college = new College();
	iHibernatedao hb = new Hibernatedao();
	CollegeInterface collegeInterface = SchoolFactory.CollegeInterFace();

	public String insert() {
		collegeInterface.insert(college);
		return "success";
	}

	public String update() {
		collegeInterface.update(college);
		return "success";
	}

	public String delete() {
		collegeInterface.delete(college);
		return "success";
	}

	public void CollegeInfo() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<College> list = collegeInterface.select();
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	@Override
	public College getModel() {
		// TODO Auto-generated method stub
		return college;
	}

}
