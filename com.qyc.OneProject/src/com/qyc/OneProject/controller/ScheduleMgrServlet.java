package com.qyc.OneProject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qyc.OneProject.Model.Schedule;
import com.qyc.OneProject.sevice.ScheduleInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class ScheduleMgrServlet
 */
@WebServlet("/ScheduleMgrServlet")
public class ScheduleMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScheduleMgrServlet() {
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
		if (pd.equals("in")) {// øŒ±Ì≈‰÷√
			insert(request, response);
			response.sendRedirect("Teacher/Arrange.jsp");
		}
		
	}
	

	// øŒ±Ì≈‰÷√
	void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Schedule sch = new Schedule();
		if (request.getParameter("TeachTaskID") != "") {
			sch.setTeachTaskID(Integer.parseInt(request
					.getParameter("TeachTaskID")));
			sch.setClassRoomID(request.getParameter("ClassRoomName"));
			sch.setClassTime(request.getParameter("ClassTime"));
			sch.setClassfestival(request.getParameter("Classfestival"));
			sch.setRemark(request.getParameter("Remark"));
			ScheduleInterface sInterface=SchoolFactory.ScheduleInterFace();
			sInterface.insert(sch);
		}
	}

}
