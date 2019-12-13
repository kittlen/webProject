package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.Model.VOptCourseSchedule;
import com.qyc.OneProject.sevice.OptCourseScheduleInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

public class OptCourseScheduleAction implements ModelDriven<VOptCourseSchedule> {
	private VOptCourseSchedule vOpC = new VOptCourseSchedule();
	OptCourseScheduleInterface iOCS = SchoolFactory
			.OptCourseScheduleInterFace();

	public String delete() {
		iOCS.delete(vOpC);
		return "success";
	}

	// 获取本学期学生所选课内容
	public void OptCourseScheduleInfo() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Student student = (Student) request.getSession().getAttribute("Slogin");
		List<VOptCourseSchedule> list = iOCS.select(student);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	// 学生课程表&成绩查询
	public void TSselect() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Student student = (Student) request.getSession().getAttribute("Slogin");
		List<VOptCourseSchedule> list = iOCS.TSselect(student);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	// 教师成绩录入
	public void Tselect() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Teacher teacher = (Teacher) request.getSession().getAttribute("Tlogin");
		vOpC.setTeacherID(teacher.getTeacherID());
		List<VOptCourseSchedule> list = iOCS.Tselect(vOpC);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	@Override
	public VOptCourseSchedule getModel() {
		// TODO Auto-generated method stub
		return vOpC;
	}

}
