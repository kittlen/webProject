package com.qyc.OneProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.Model.VOptCourseSchedule;
import com.qyc.OneProject.sevice.OptCourseScheduleInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class VOptCourseScheduleMgrServlet
 */
@WebServlet("/VOptCourseScheduleMgrServlet")
public class OptCourseScheduleMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OptCourseScheduleMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubrequest.setCharacterEncoding("UTF-8");
		String pd=request.getParameter("judge");
		if(pd.equals("se")){//��ȡ��ѧ��ѧ������ѡ������
			select(request, response);
		}
		if(pd.equals("de")){
			delete(request,response);
			response.sendRedirect("Student/OptCourseSchedule.jsp");
		}
		if(pd.equals("Tse")){//��ʦ�ɼ�¼��
			Tselect(request,response);
		}
		if(pd.equals("Sse")){//ѧ���ɼ���ѯ
			Sselect(request,response);
		}
		if(pd.equals("TSse")){//ѧ���γ̱�
			TSselect(request,response);
		}
	}
	//ѧ���γ̱�
	void TSselect(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		OptCourseScheduleInterface oInterface=SchoolFactory.OptCourseScheduleInterFace();
		List<VOptCourseSchedule> list=oInterface.TSselect(((Student)request.getSession().getAttribute("Slogin")).getStu_ID());
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//ѧ���ɼ���ѯ
	void Sselect(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		OptCourseScheduleInterface oInterface=SchoolFactory.OptCourseScheduleInterFace();
		List<VOptCourseSchedule> list=oInterface.Sselect(((Student)(request.getSession().getAttribute("Slogin"))).getStu_ID());
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//��ʦ�ɼ�¼��
	void Tselect(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		OptCourseScheduleInterface oInterface=SchoolFactory.OptCourseScheduleInterFace();
		String CourseID=request.getParameter("CourseID");
		List<VOptCourseSchedule> list=oInterface.Tselect(((Teacher)request.getSession().getAttribute("Tlogin")).getTeacherID(),CourseID);
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String CourseScheduleID=request.getParameter("CourseScheduleID");
		OptCourseScheduleInterface oInterface=SchoolFactory.OptCourseScheduleInterFace();
		oInterface.delete(CourseScheduleID);
	}

	//��ȡ��ѧ��ѧ������ѡ������
	void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		OptCourseScheduleInterface oInterface=SchoolFactory.OptCourseScheduleInterFace();
		List<VOptCourseSchedule> list=oInterface.select(((Student)request.getSession().getAttribute("Slogin")).getStu_ID());
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
