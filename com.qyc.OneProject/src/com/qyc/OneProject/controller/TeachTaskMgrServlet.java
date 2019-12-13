package com.qyc.OneProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.qyc.OneProject.Model.Course;
import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.Model.VTeachTask;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.sevice.TeachTaskInterface;
import com.qyc.OneProject.util.util;

/**
 * Servlet implementation class TeachTaskMgrServlet
 */
@WebServlet("/TeachTaskMgrServlet")
public class TeachTaskMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeachTaskMgrServlet() {
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
		if (pd.equals("in")) {//课程发布
			insert(request, response);
			response.sendRedirect("Teacher/TCourse.jsp");
		}
		if (pd.equals("de")) {//课程删除
			delete(request, response);
			response.sendRedirect("Teacher/TCourse.jsp");
		}
		if(pd.equals("se")){//开课查询
			select(request,response);
		}
		if(pd.equals("Ase")){//课表配置
			ArrangeSelect(request,response);
		}
		
	}
	

	//课表配置
	void ArrangeSelect(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String TeacherID=((Teacher)(request.getSession().getAttribute("Tlogin"))).getTeacherID();
			String Curricula=util.getNewSemester();
			TeachTaskInterface teachTaskInterface=SchoolFactory.TeachTaskInterFace();
			List<VTeachTask> list=teachTaskInterface.ArrangeSelect(Curricula,TeacherID);
			JSONArray json=JSONArray.fromObject(list);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw=response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//开课查询
	void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String Curricula=request.getParameter("Curricula");
			Curricula="%"+Curricula+"%";
			String TeacherID=((Teacher)(request.getSession().getAttribute("Tlogin"))).getTeacherID();
			TeachTaskInterface teachTaskInterface=SchoolFactory.TeachTaskInterFace();
			List<VTeachTask> list=teachTaskInterface.select(Curricula,TeacherID);
			JSONArray json=JSONArray.fromObject(list);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw=response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//课程发布
	void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String State = new String(request.getParameter("State").getBytes("iso8859-1"),"utf-8");
			if (State.equals("未开课")) {
				TeachTask task = new TeachTask();
				Teacher teacher = new Teacher();
				Course course = new Course();
				teacher.setTeacherID(((Teacher) request.getSession().getAttribute(
						"Tlogin")).getTeacherID());
				task.setTeacher(teacher);
				course.setCourseID(request.getParameter("CourseID"));
				task.setCourse(course);
				task.setCurricula(util.getNewSemester());
				task.setAuditing("未审核");
				TeachTaskInterface teachTaskInterface = SchoolFactory.TeachTaskInterFace();
				teachTaskInterface.insert(task);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//课程删除
	void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		TeachTask task=new TeachTask();
		Teacher teacher = new Teacher();
		teacher.setTeacherID(((Teacher) request.getSession().getAttribute("Tlogin")).getTeacherID());
		Course course = new Course();
		course.setCourseID(request.getParameter("CourseID"));
		task.setTeacher(teacher);
		task.setCourse(course);
		TeachTaskInterface teachTaskInterface = SchoolFactory.TeachTaskInterFace();
		teachTaskInterface.delete(task);

	}

}
