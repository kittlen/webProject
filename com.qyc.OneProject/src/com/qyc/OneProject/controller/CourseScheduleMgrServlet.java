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

import com.qyc.OneProject.Model.CourseSchedule;
import com.qyc.OneProject.Model.Schedule;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.Model.VCourseSchedule;
import com.qyc.OneProject.sevice.CourseScheduleInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class CourseScheduleMgrServlet
 */
@WebServlet("/CourseScheduleMgrServlet")
public class CourseScheduleMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseScheduleMgrServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String pd=request.getParameter("judge");
		if(pd.equals("se")){//获取本学期所有选课内容
			select(request, response);
		}
		if(pd.equals("in")){//学生选课数据添加
			insert(request,response);
			response.sendRedirect("Student/CourseSchedule.jsp");
		}
		if(pd.equals("up")){//学生成绩录入(修改)
			update(request,response);
			response.sendRedirect("Teacher/Success.jsp");
		}
		if(pd.equals("Tse")){//对应教师的对应课程
			Tselect(request,response);
		}
		if(pd.equals("de")){//取消教师所配课程
			delete(request,response);
			response.sendRedirect("Teacher/Arrange.jsp");
		}
		if(pd.equals("TTse")){//教师课程表
			TTimeTablesSelect(request,response);
		}
	}
	
	//教师课程表
	void TTimeTablesSelect(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		String TeacherID=((Teacher)(request.getSession().getAttribute("Tlogin"))).getTeacherID();
		CourseScheduleInterface cInterface=SchoolFactory.CourseScheduleInterFace();
		List<VCourseSchedule> list=cInterface.TTselect(TeacherID);
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
			
	
	//取消教师所配课程
	void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String ScheduleID=request.getParameter("ScheduleID");
		CourseScheduleInterface cInterface=SchoolFactory.CourseScheduleInterFace();
		cInterface.delete(ScheduleID);
		
	}

	//对应教师的对应课程
	void Tselect(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String TeacherID=((Teacher)(request.getSession().getAttribute("Tlogin"))).getTeacherID();
		CourseScheduleInterface cInterface=SchoolFactory.CourseScheduleInterFace();
		List<VCourseSchedule> list=cInterface.Tselect(TeacherID,request.getParameter("CourseID"));
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

	//学生成绩录入(修改)
	void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CourseSchedule cSchedule=new CourseSchedule();
		cSchedule.setID(Integer.parseInt(request.getParameter("CourseScheduleID")));
		cSchedule.setScoreOne(Double.parseDouble(request.getParameter("ScoreOne")));
		cSchedule.setScoreTwo(Double.parseDouble(request.getParameter("ScoreTwo")));
		cSchedule.setScoreThree(Double.parseDouble(request.getParameter("ScoreThree")));
		cSchedule.setTotalScore(cSchedule.getScoreOne()+cSchedule.getScoreTwo()+cSchedule.getScoreThree());
		CourseScheduleInterface cInterface=SchoolFactory.CourseScheduleInterFace();
		cInterface.update(cSchedule);
			
	}
	
	void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Schedule schedule=new Schedule();
		schedule.setID(Integer.parseInt(request.getParameter("ScheduleID")));
		CourseScheduleInterface cInterface=SchoolFactory.CourseScheduleInterFace();
		Student student=(Student)(request.getSession().getAttribute("Slogin"));
		CourseSchedule cSchedule=new CourseSchedule();
		cSchedule.setStudent(student);
		cSchedule.setSchedule(schedule);
		if(cInterface.Cselect(cSchedule)){
			cInterface.insert(cSchedule);
		}else {
			request.getSession().setAttribute("error", "false");
		}
	}

	//获取本学期所有选课内容
	void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CourseScheduleInterface cInterface=SchoolFactory.CourseScheduleInterFace();
		List<VCourseSchedule> list=cInterface.select(request.getParameter("ProfessionID"));
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
