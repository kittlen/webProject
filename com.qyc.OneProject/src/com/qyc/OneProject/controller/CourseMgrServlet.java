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

import com.qyc.OneProject.Model.Course;
import com.qyc.OneProject.Model.Profession;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.sevice.CourseInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class CourseMgrServlet
 */
@WebServlet("/CourseMgrServlet")
public class CourseMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseMgrServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String pd = request.getParameter("judge");
		if (pd.equals("in")) {
			insert(request, response);
			response.sendRedirect("admin/Course/Course.jsp");
		}
		if (pd.equals("up")) {
			update(request, response);
			response.sendRedirect("admin/Course/Course.jsp");
		}
		if (pd.equals("de")) {
			delete(request, response);
			response.sendRedirect("admin/Course/Course.jsp");
		}
		if (pd.equals("se")) {
			CourseInfo(request, response);
		}
		if (pd.equals("Tse")) {// 对应教师的课程
			TCourseInfo(request, response);
		}
		
	}

	void insert(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (request.getParameter("CourseID") != "") {
			Course cou = new Course();
			Profession pro = new Profession();
			cou.setCourseID(request.getParameter("CourseID"));
			cou.setCourse(request.getParameter("Course"));
			pro.setProfessionID(request.getParameter("ProfessionID"));
			cou.setProfession(pro);
			if (request.getParameter("StudyTime") != "") {
				cou.setStudyTime(Integer.parseInt(request
						.getParameter("StudyTime")));
			}
			if (request.getParameter("Crediy") != "") {
				cou.setCrediy(Float.parseFloat(request.getParameter("Crediy")));
			}
			cou.setCurriculumTime(request.getParameter("CurriculumTime"));
			cou.setRemark(request.getParameter("Remark"));
			CourseInterface Sch = SchoolFactory.CourseInterFace();
			Sch.insert(cou);
		}
	}

	void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Course cou = new Course();
		Profession pro = new Profession();
		cou.setCourseID(request.getParameter("CourseID"));
		cou.setCourse(request.getParameter("Course"));
		pro.setProfessionID(request.getParameter("ProfessionID"));
		cou.setProfession(pro);
		cou.setStudyTime(Integer.parseInt(request.getParameter("StudyTime")));
		cou.setCrediy(Float.parseFloat(request.getParameter("Crediy")));
		cou.setCurriculumTime(request.getParameter("CurriculumTime"));
		cou.setRemark(request.getParameter("Remark"));
		CourseInterface Sch = SchoolFactory.CourseInterFace();
		Sch.update(cou);
	}

	void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String CourseID = request.getParameter("CourseID");
		CourseInterface Sch = SchoolFactory.CourseInterFace();
		Sch.delete(CourseID);
	}

	void CourseInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		CourseInterface Sch = SchoolFactory.CourseInterFace();
		List<Course> list = Sch.select(request.getParameter("ProfessionID"));
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	void TCourseInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		CourseInterface Sch = SchoolFactory.CourseInterFace();
		String TeacherID = ((Teacher) request.getSession().getAttribute(
				"Tlogin")).getTeacherID();
		/* System.out.println(TeacherID); */
		List<Course> list = Sch.TCselect(request.getParameter("ProfessionID"),
				TeacherID);
		JSONArray json = JSONArray.fromObject(list);
		/* System.out.println(json); */
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

}
