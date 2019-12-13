package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.CourseSchedule;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.Model.VCourseSchedule;
import com.qyc.OneProject.sevice.CourseScheduleInterface;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.util.util;

@SuppressWarnings("serial")
public class CourseScheduleAction extends ActionSupport implements ModelDriven<VCourseSchedule> {
	private VCourseSchedule vCS = new VCourseSchedule();
	CourseScheduleInterface iCSI = SchoolFactory.CourseScheduleInterFace();
	private CourseSchedule cSchedule;

	// �Ѿ�������ɵĿγ�
	public void Tselect() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		Teacher teacher = (Teacher) request.getSession().getAttribute("Tlogin");
		vCS.setTeacherID(teacher.getTeacherID());
		List<VCourseSchedule> list = iCSI.Tselect(vCS);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	// ѧ��ѡ��
	public void CourseScheduleInfo() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		vCS.setCurricula(util.getNewSemester());
		List<VCourseSchedule> list = iCSI.select(vCS);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	// ѧ��ѡ�����
	public String insert() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Student student = (Student) request.getSession().getAttribute("Slogin");
		if (iCSI.insert(vCS, student)) {
		} else {
			request.getSession().setAttribute("error", "false");
		}
		return "success";
	}

	// ��ʦ�γ̱�
	public void TTselect() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Teacher teacher = (Teacher) request.getSession().getAttribute("Tlogin");
		List<VCourseSchedule> list = iCSI.TTselect(teacher);
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	// ѧ���ɼ��޸�
	public String update() {
		iCSI.update(cSchedule);
		return "success";
	}

	@Override
	public VCourseSchedule getModel() {
		// TODO Auto-generated method stub
		return vCS;
	}

	public CourseSchedule getcSchedule() {
		return cSchedule;
	}

	public void setcSchedule(CourseSchedule cSchedule) {
		this.cSchedule = cSchedule;
	}

}
