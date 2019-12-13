package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Course;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.CourseInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

public class CourseAction implements ModelDriven<Course> {

	private Course course = new Course();

	iHibernatedao hb = new Hibernatedao();
	CourseInterface icou = SchoolFactory.CourseInterFace();

	public String insert() {
		icou.insert(course);
		return "success";
	}

	public String update() {
		icou.update(course);
		return "success";
	}

	public String delete() {
		icou.delete(course);
		return "success";
	}

	public void CourseInfo() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Course> list = icou.select(request.getParameter("ProfessionID"));
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	public void CourseTInfo() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Teacher teacher=(Teacher) request.getSession().getAttribute("Tlogin");
		List<Course> list=icou.TCselect(course, teacher.getTeacherID());
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
	
	@Override
	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}

}
